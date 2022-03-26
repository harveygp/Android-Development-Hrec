package com.example.hrec.presentation.navigation

const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"

// Dashboard Screen
const val DASHBOARD_ROUTE = "dashboard"

sealed class Screen(val route : String){

    object ForgotPassword : Screen("forgot_password_screen")
    object ForgotPasswordNew : Screen("forgot_password_new_screen")
    object Profile : Screen("profile_account")
    object testScreen : Screen("test_screen")
    object test2Screen : Screen("test_2_screen")

    // Dashboard Screen Object
    object Dashboard : Screen("dashboard_screen")

}
