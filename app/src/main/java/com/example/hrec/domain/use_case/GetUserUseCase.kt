package com.example.hrec.domain.use_case

import com.example.hrec.Utils.Condition
import com.example.hrec.domain.model.UserDetail
import com.example.hrec.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(userId : String) : Flow<Condition<List<UserDetail>>> = repository.getUser(userId = userId)
}