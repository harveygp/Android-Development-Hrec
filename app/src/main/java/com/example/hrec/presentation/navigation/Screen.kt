package com.example.hrec.presentation.navigation

const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"

//Splash Screen
const val SPLASH_ROUTE = "splash"
//Onboarding Screen
const val ONBOARD_ROUTE  = "onboard"

sealed class Screen(val route : String){

    object ForgotPassword : Screen("forgot_password_screen")
    object ForgotPasswordNew : Screen("forgot_password_new_screen")
    object Profile : Screen("profile_account")
    object testScreen : Screen("test_screen")
    object test2Screen : Screen("test_2_screen")

    //Splash Screen
    object splashScreen : Screen(route = "splash_screen")

    //Onboarding Screen
    object OnboardingScreen : Screen(route = "onboard_screen")
    object OnboardingScreen2 : Screen(route = "onboard2_screen")
    object OnboardingScreen3 : Screen(route = "onboard3_screen")


}
