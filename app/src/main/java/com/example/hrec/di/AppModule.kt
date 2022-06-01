package com.example.hrec.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.hrec.data.remote.HRecAPI
import com.example.hrec.data.repository.ApplicantRepositoryImpl
import com.example.hrec.domain.repository.ApplicantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi() : HRecAPI {
        return Retrofit.Builder()
            .baseUrl("http://localhost:5000/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

//    @Provides
//    @Singleton
//    fun provideSharedPref(app : Application) : SharedPreferences =
//        app.getSharedPreferences("prefs", MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideUserApplicant(api : HRecAPI) : ApplicantRepository = ApplicantRepositoryImpl(api)


}