package com.example.hrec.presentation.signIn

sealed class SignInUIEvent {
    data class SignInEmailChanged(val value: String): SignInUIEvent()
    data class SignInPasswordChanged(val value: String): SignInUIEvent()
    object SignIn: SignInUIEvent()
}