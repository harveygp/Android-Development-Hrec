package com.example.hrec.presentation.navigation

const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"

// Notification
const val NOTIFICATION_ROUTE = "notification"

//Sign In
const val SIGN_IN_ROUTE = "signin"

//Sign Up
const val SIGN_UP_ROUTE = "signup"

// Dashboard Screen
const val DASHBOARD_ROUTE = "dashboard"

//Splash Screen
const val SPLASH_ROUTE = "splash"

//Onboarding Screen
const val ONBOARD_ROUTE = "onboard"

sealed class Screen(val route: String) {

    object ForgotPassword : Screen("forgot_password_screen")
    object ForgotPasswordNew : Screen("forgot_password_new_screen")
    object Profile : Screen("profile_account")

    // Notification Object
    object Notification : Screen("notification_screen")

    //Splash Screen
    object splashScreen : Screen(route = "splash_screen")

    //Onboarding Screen
    object OnboardingScreen : Screen(route = "onboard_screen")
    object OnboardingScreen2 : Screen(route = "onboard2_screen")
    object OnboardingScreen3 : Screen(route = "onboard3_screen")

    // Dashboard Screen Object
    object Dashboard : Screen("dashboard_screen")

    //  Sign In
    object SignIn : Screen("signin_screen")
    //  Sign Up
    object SignUp : Screen("signup_screen")

}

