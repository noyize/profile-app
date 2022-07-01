package com.noyize.profileapp.app.util

import com.skydoves.sandwich.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> ApiResponse<RequestType>,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { Unit },
    crossinline shouldFetch: () -> Boolean = { true }
) = flow<Resource<ResultType>> {
    emit(Resource.Loading)
    val data = query().first()

    if (shouldFetch()) {
        emit(Resource.Loading)
        fetch().suspendOnSuccess {
            saveFetchResult(this.data)
            emit(Resource.Success(query().first()))
        }.suspendOnError {
            when (statusCode) {
                StatusCode.InternalServerError -> emit(Resource.Error(SERVER_ERROR))
                else -> emit(Resource.Error(INTERNET_ERROR))
            }
        }.suspendOnException {
            onFetchFailed(this.exception)
            emit(Resource.Error(this.message ?: UNKNOWN_ERROR))
        }
    } else {
        emit(Resource.Success(data))
    }

}.flowOn(Dispatchers.IO)

const val SERVER_ERROR = "Server error"
const val UNKNOWN_ERROR = "Unknown error"
const val INTERNET_ERROR = "Error. Please check your internet connection and try again"
