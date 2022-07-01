package com.noyize.profileapp.data.source.remote

import com.noyize.profileapp.data.source.remote.dto.ProfileDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ProfileService {

    @GET("v2/5d565297300000680030a986")
    suspend fun getProfiles(): ApiResponse<List<ProfileDto>>

}