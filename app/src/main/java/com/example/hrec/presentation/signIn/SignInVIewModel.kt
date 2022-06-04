package com.example.hrec.presentation.signIn

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrec.domain.model.Auth.AuthResult
import com.example.hrec.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInVIewModel @Inject constructor(
    private val repository: AuthRepository,
    private val prefs : SharedPreferences
) : ViewModel() {

    var state by mutableStateOf(SignInState())

    private val looking = prefs.getString("Hrec", " ")

    private val resultChannel = Channel<AuthResult<Unit>>()
    val authResults = resultChannel.receiveAsFlow()

    init {
        authenticate()
    }

    fun onEvent(event: SignInUIEvent) {
        when(event) {
            is SignInUIEvent.SignInEmailChanged -> {
                state = state.copy( email= event.value)
            }
            is SignInUIEvent.SignInPasswordChanged -> {
                state = state.copy(password = event.value)
            }
            is SignInUIEvent.SignIn -> {
                signIn()
            }
        }
    }

    private fun signIn() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signIn(
                email = state.email.toString(),
                password = state.password.toString()
            )
            resultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }

    private fun authenticate() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.authenticate()
            resultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }
}