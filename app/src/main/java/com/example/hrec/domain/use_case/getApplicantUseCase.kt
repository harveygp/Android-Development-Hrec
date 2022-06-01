package com.example.hrec.domain.use_case

import com.example.hrec.Utils.Condition
import com.example.hrec.domain.model.UserApplicant
import com.example.hrec.domain.repository.ApplicantRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class getApplicantUseCase @Inject constructor(
    private val repository : ApplicantRepository
) {
    suspend operator fun invoke() : Flow<Condition<List<UserApplicant>>> = repository.getApplicants()
}