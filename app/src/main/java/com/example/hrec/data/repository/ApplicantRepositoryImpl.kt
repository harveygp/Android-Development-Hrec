package com.example.hrec.data.repository

import android.util.Log
import com.example.hrec.Utils.Condition
import com.example.hrec.data.remote.HRecAPI
import com.example.hrec.domain.model.UserApplicant
import com.example.hrec.domain.model.UserDetailApplicant
import com.example.hrec.domain.repository.ApplicantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ApplicantRepositoryImpl @Inject constructor(
    private val api : HRecAPI
) : ApplicantRepository{

    override suspend fun getApplicants(): Flow<Condition<List<UserApplicant>>> = flow {
        try {
            emit(Condition.Loading())
            val applicants = api.getApplicants()
            emit(Condition.Success(applicants))
        } catch (e : HttpException){
            emit(Condition.Error<List<UserApplicant>>(e.localizedMessage ?: "An Error Occurred"))
        } catch (e : IOException){
            emit(Condition.Error<List<UserApplicant>>("No Internet Detected"))
        }
    }

    override suspend fun getApplicantId(appId: String): Flow<Condition<UserDetailApplicant>> = flow {
        try {
            emit(Condition.Loading<UserDetailApplicant>())
            val applicants = api.getApplicantId(appId = appId)
            Log.d("data api masuk", applicants.toString())
            emit(Condition.Success<UserDetailApplicant>(applicants))
        } catch (e : HttpException){
            emit(Condition.Error<UserDetailApplicant>(e.localizedMessage ?: "An Error Occurred"))
        } catch (e : IOException){
            emit(Condition.Error<UserDetailApplicant>("No Internet Detected"))
        }
    }
}