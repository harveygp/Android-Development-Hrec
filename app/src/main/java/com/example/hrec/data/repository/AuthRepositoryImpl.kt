package com.example.hrec.data.repository

import android.content.SharedPreferences
import android.util.Log
import com.example.hrec.Utils.Condition
import com.example.hrec.data.remote.HRecAPI
import com.example.hrec.domain.model.Auth.AuthRequest
import com.example.hrec.domain.model.Auth.AuthResult
import com.example.hrec.domain.model.UserApplicant
import com.example.hrec.domain.model.UserDetail
import com.example.hrec.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api : HRecAPI,
    private val prefs : SharedPreferences
) : AuthRepository{

    override suspend fun signUp(email: String, password: String): AuthResult<Unit> {
        TODO()
//        return try {
//            api.signUp(
//                request = AuthRequest(
//                    email = email,
//                    password = password
//                )
//            )
//            signIn(email, password)
//        } catch (e : HttpException){
//            if (e.code() == 401) {
//                AuthResult.Unauthorized()
//            } else {
//                AuthResult.UnknownError()
//            }
//        } catch (e : Exception){
//            AuthResult.UnknownError()
//        }
    }

    override suspend fun signIn(email: String, password: String): AuthResult<Unit> {
        return try{
            Log.d("Masuk sig in impl", "$api")
            val response = api.signIn(
                request = AuthRequest(
                    email = email,
                    password = password
                )
            )
            Log.d("Masuk sig in impl", "$response")
            prefs.edit()
                .putString("HrecToken", response.token)
                .putString("Hrec", response.id)
                .apply()
            AuthResult.Authorized()
        } catch (e : HttpException){
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e : Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val id = prefs.getString("prefs", null) ?: return AuthResult.Unauthorized()
            if(id.isEmpty()){
                AuthResult.Unauthorized()
            }else{
                AuthResult.Authorized()
            }
        }catch (e : HttpException){
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e : Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun getUser(userId: String): Flow<Condition<List<UserDetail>>> = flow {
        try {
            emit(Condition.Loading())
            val user = api.getUser(userId = userId)
            Log.d("data api masuk", user.toString())
            emit(Condition.Success(user))
        } catch (e : HttpException){
            emit(Condition.Error<List<UserDetail>>(e.localizedMessage ?: "An Error Occurred"))
        } catch (e : IOException){
            emit(Condition.Error<List<UserDetail>>("No Internet Detected"))
        }
    }
}