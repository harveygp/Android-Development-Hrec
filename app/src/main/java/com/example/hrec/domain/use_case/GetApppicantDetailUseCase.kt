package com.example.hrec.domain.use_case

import com.example.hrec.Utils.Condition
import com.example.hrec.domain.model.UserDetailApplicant
import com.example.hrec.domain.repository.ApplicantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetApppicantDetailUseCase@Inject constructor(
    private val repository : ApplicantRepository
) {
    suspend operator fun invoke(appId : String) : Flow<Condition<UserDetailApplicant>> = repository.getApplicantId(appId = appId)
}