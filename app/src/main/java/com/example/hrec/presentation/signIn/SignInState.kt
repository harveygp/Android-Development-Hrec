package com.example.hrec.presentation.signIn

data class SignInState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)
