package com.example.hrec.data.remote

import com.example.hrec.domain.model.Auth.AuthRequest
import com.example.hrec.domain.model.Auth.UserResponse
import com.example.hrec.domain.model.UserApplicant
import com.example.hrec.domain.model.UserDetail
import com.example.hrec.domain.model.UserDetailApplicant
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HRecAPI {

    @GET("userapprec/users")
    suspend fun getApplicants() : List<UserApplicant>

    @GET("userapprec/users/{appId}")
    suspend fun getApplicantId(@Path("appId") appId : String ) : UserDetailApplicant

    @POST("userrec/login")
    suspend fun signIn(
        @Body request: AuthRequest
    ) : UserResponse

    @POST("userrec/signup")
    suspend fun signUp(
        @Body request : AuthRequest
    )

    @GET("userrec/users/{userId}")
    suspend fun getUser(@Path("userId") userId : String) : UserDetail

}