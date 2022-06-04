package com.example.hrec.presentation.profile

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrec.Utils.Condition
import com.example.hrec.domain.model.UserDetail
import com.example.hrec.domain.repository.AuthRepository
import com.example.hrec.domain.use_case.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val prefs : SharedPreferences,
    private val getUserUseCase : GetUserUseCase
) : ViewModel(){

    private val _state = mutableStateOf(UserState())
    val state : State<UserState> = _state

    private val _prefs = prefs.getString("prefs", "")
    val pref = _prefs

    init {
        if (pref != null) {
            getUser(pref)
        }
    }


    private fun getUser(userId : String){
        viewModelScope.launch(Dispatchers.IO) {
            getUserUseCase(userId = userId).onEach { result ->
                when(result){
                    is Condition.Success -> {
                        _state.value = UserState(user = result.data)
                    }
                    is Condition.Error -> {
                        _state.value = UserState(error = result.message ?: " an Error Occurred")
                    }
                    is Condition.Loading -> {
                        _state.value = UserState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}