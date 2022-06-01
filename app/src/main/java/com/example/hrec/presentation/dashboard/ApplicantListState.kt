package com.example.hrec.presentation.dashboard

import com.example.hrec.domain.model.UserApplicant

data class ApplicantListState(
    val isLoading : Boolean = false,
    val applicants : List<UserApplicant> = emptyList(),
    val error : String = ""
)
