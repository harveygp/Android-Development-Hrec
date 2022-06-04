package com.example.hrec.domain.model

data class UserDetailApplicant(
    val _id : String,
    val name : String,
    val email: String,
    val specialization : String,
    val experience: MutableList<String>,
    val degree : String,
    val status : Boolean,
    val evaluation : Evaluation
    )
