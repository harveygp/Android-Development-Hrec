package com.example.hrec.presentation.profile

import com.example.hrec.domain.model.UserDetail

data class UserState(
    val isLoading : Boolean = false,
    val user : List<UserDetail>? = emptyList(),
    val error : String = ""
)
