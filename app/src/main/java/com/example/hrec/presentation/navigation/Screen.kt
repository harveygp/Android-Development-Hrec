package com.example.hrec.presentation.navigation

<<<<<<< HEAD
//Sign In
const val SIGN_IN_ROUTE = "signin"

//Sign Up
const val SIGN_UP_ROUTE = "signup"

=======
>>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f
const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"

<<<<<<< HEAD
sealed class Screen(val route : String){

//  Sign In
    object SignIn : Screen("signin_screen")
//  Sign Up
    object SignUp : Screen("signup_screen")
=======
//Splash Screen
const val SPLASH_ROUTE = "splash"
//Onboarding Screen
const val ONBOARD_ROUTE  = "onboard"

sealed class Screen(val route : String){
>>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f

    object ForgotPassword : Screen("forgot_password_screen")
    object ForgotPasswordNew : Screen("forgot_password_new_screen")
    object Profile : Screen("profile_account")
    object testScreen : Screen("test_screen")
    object test2Screen : Screen("test_2_screen")

<<<<<<< HEAD
=======
    //Splash Screen
    object splashScreen : Screen(route = "splash_screen")

    //Onboarding Screen
    object OnboardingScreen : Screen(route = "onboard_screen")
    object OnboardingScreen2 : Screen(route = "onboard2_screen")
    object OnboardingScreen3 : Screen(route = "onboard3_screen")


>>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f
}
