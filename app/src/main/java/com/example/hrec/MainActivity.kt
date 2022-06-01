package com.example.hrec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.presentation.SetupNavGraph
import com.example.hrec.presentation.ui.theme.HRecTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HRecTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                navController = rememberNavController()
//                SetupNavGraph(navController = navController)
//                ForgotPasswordNew()
//                ForgotPassword()
//                Profile()
//                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = stringResource(id = R.string.tv_emailCheck, "lol"), style = MaterialTheme.typography.h1)
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    HRecTheme {
//        Greeting("Android")
//    }

