package com.example.hrec.presentation.navigation

const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"

<<<<<<< HEAD
sealed class Screen(val route : String){

    object ForgotPassword : Screen("forgot_password_screen")
    object ForgotPasswordNew : Screen("forgot_password_new_screen")
    object Profile : Screen("profile_account")
    object testScreen : Screen("test_screen")
    object test2Screen : Screen("test_2_screen")

}
=======
<<<<<<< HEAD
const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
const val PROFILE_ROUTE = "profileaccount"
const val ROOT_ROUTE = "root"
=======
>>>>>>> 415502e1b709cb6af62c2d4972f31475ef4acaa2
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

<<<<<<< HEAD
            >>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f
            >>>>>>> 49787092dedc400239df3c43477617fbd043402a
        }
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
=======
}
>>>>>>> 415502e1b709cb6af62c2d4972f31475ef4acaa2
