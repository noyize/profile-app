package com.noyize.profileapp.app.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.noyize.profileapp.data.source.local.ProfileAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideShoppingAppDatabase(application: Application) =
        Room.databaseBuilder(application, ProfileAppDatabase::class.java, "profile_app_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCategoryDao(db: ProfileAppDatabase) = db.profileDao

    @Provides
    @Singleton
    fun provideSharedPreference(application: Application): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(application)
}