package com.example.hrec.domain.repository

import com.example.hrec.Utils.Condition
import com.example.hrec.domain.model.Auth.AuthResult
import com.example.hrec.domain.model.UserDetail
import com.example.hrec.domain.model.UserDetailApplicant
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signUp(email: String, password: String): AuthResult<Unit>
    suspend fun signIn(email: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>

    suspend fun getUser(userId : String) : Flow<Condition<List<UserDetail>>>
}