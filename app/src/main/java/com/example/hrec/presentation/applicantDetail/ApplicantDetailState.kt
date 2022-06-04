package com.example.hrec.presentation.applicantDetail

import com.example.hrec.domain.model.UserDetailApplicant

class ApplicantDetailState(
    val isLoading : Boolean = false,
    val applicant : UserDetailApplicant? = null,
    val error : String = ""
)