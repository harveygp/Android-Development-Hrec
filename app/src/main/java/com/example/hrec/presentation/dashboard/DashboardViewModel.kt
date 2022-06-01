package com.example.hrec.presentation.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hrec.domain.use_case.getApplicantUseCase
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.hrec.Utils.Condition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getApplicantsUseCase : getApplicantUseCase
) : ViewModel(){

    private val _state = mutableStateOf(ApplicantListState())
    val state : State<ApplicantListState> = _state

    init {
        getApplicants()
    }

    private fun getApplicants(){
        viewModelScope.launch(Dispatchers.IO) {
            getApplicantsUseCase().onEach { result ->
                when(result){
                    is Condition.Success -> {
                        _state.value = ApplicantListState(applicants = result.data ?: emptyList())
                    }
                    is Condition.Error -> {
                        _state.value = ApplicantListState(error = result.message ?: "An Error Occurred")
                    }
                    is Condition.Loading -> {
                        _state.value = ApplicantListState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }


}