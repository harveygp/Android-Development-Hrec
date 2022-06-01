package com.example.hrec.domain.model

data class UserDetailApplicant(
    val id : String,
    val nama : String,
    val specialization : String?,
    val password : String,
    val experience : List<String>,
    val evaluation : List<UserDetailEval>,
    val score : Int
    )
