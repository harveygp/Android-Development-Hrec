package com.example.hrec.presentation.applicantDetail

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hrec.Utils.Condition
import com.example.hrec.domain.use_case.GetApppicantDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplicantDetailViewModel@Inject constructor(
    private val getApppicantDetailUseCase: GetApppicantDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ApplicantDetailState())
    val state : State<ApplicantDetailState> = _state

    val id = savedStateHandle.get<String>("appId")

    init {
        if (id != null) {
            getApplicantDetail(appId = id)
        }
    }


    private fun getApplicantDetail(appId : String) {
        viewModelScope.launch(Dispatchers.IO) {
            getApppicantDetailUseCase(appId).onEach { result ->
                when(result){
                    is Condition.Success -> {
                        _state.value = ApplicantDetailState(applicant = result.data)
                    }
                    is Condition.Error -> {
                        _state.value = ApplicantDetailState(
                            error = result.message ?: "An Unexpected Error Occured"
                        )
                    }
                    is Condition.Loading ->{
                        _state.value = ApplicantDetailState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}