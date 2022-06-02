package com.example.hrec.domain.repository

import com.example.hrec.domain.model.Auth.AuthResult

interface AuthRepository {
    suspend fun signUp(email: String, password: String): AuthResult<Unit>
    suspend fun signIn(email: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}