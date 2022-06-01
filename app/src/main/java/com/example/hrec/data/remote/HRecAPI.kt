package com.example.hrec.data.remote

import com.example.hrec.domain.model.UserApplicant
import com.example.hrec.domain.model.UserDetailApplicant
import retrofit2.http.GET
import retrofit2.http.Path

interface HRecAPI {

    @GET("userapprec/users")
    suspend fun getApplicants() : List<UserApplicant>

    @GET("userapprec/users/{appId}")
    suspend fun getApplicantId(@Path("appId") appId : String ) : UserDetailApplicant

}