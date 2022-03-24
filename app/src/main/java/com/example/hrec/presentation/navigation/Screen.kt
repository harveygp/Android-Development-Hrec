package com.example.hrec.presentation.navigation

const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"
// Notification
const val NOTIFICATION_ROUTE = "notification"

sealed class Screen(val route : String){

    object ForgotPassword : Screen("forgot_password_screen")
    object ForgotPasswordNew : Screen("forgot_password_new_screen")
    object Profile : Screen("profile_account")
    object testScreen : Screen("test_screen")
    object test2Screen : Screen("test_2_screen")
    // Notification Object
    object Notification : Screen("notification_screen")

}
