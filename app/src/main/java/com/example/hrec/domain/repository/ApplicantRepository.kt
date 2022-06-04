package com.example.hrec.domain.repository

import com.example.hrec.Utils.Condition
import com.example.hrec.domain.model.UserApplicant
import com.example.hrec.domain.model.UserDetailApplicant
import kotlinx.coroutines.flow.Flow

interface ApplicantRepository {

    suspend fun getApplicants() : Flow<Condition<List<UserApplicant>>>

    suspend fun getApplicantId( appId :  String ) : Flow<Condition<UserDetailApplicant>>

}