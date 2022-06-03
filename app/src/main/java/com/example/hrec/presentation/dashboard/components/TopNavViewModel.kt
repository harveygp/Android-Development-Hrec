package com.example.hrec.presentation.dashboard.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TopNavViewModel : ViewModel() {

    private val _state = mutableStateOf(TopNavState())
    val state: State<TopNavState> = _state
    private var _screenState = state.value.isCandidate
    val screenState = _screenState

    fun candidateScreen() {
        _screenState = _state.value.isCandidate
    }

    fun acceptedScreen() {
        _screenState = _state.value.isAccepted
    }

}