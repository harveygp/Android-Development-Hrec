package com.example.hrec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.presentation.SetupNavGraph
import com.example.hrec.presentation.forgotPassword.ForgotPassword
import com.example.hrec.presentation.forgotPassword.ForgotPasswordNew
import com.example.hrec.presentation.profile.Profile
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
import com.example.hrec.presentation.signIn.SignIn
=======
>>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f
>>>>>>> 49787092dedc400239df3c43477617fbd043402a
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
=======
import com.example.hrec.presentation.signIn.SignIn

>>>>>>> 415502e1b709cb6af62c2d4972f31475ef4acaa2
import com.example.hrec.presentation.ui.theme.HRecTheme

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
<<<<<<< HEAD
//                navController = rememberNavController()
//                SetupNavGraph(navController = navController)
//                ForgotPasswordNew()
//                ForgotPassword()
//                Profile()
<<<<<<< HEAD
=======
                <<<<<<< HEAD
                =======
                <<<<<<< HEAD
//                SignIn()
                =======
                >>>>>>> 4a208073cac62e6583c4eda7eb03d9368a4d1a3f
                >>>>>>> 49787092dedc400239df3c43477617fbd043402a
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
=======
>>>>>>> 415502e1b709cb6af62c2d4972f31475ef4acaa2
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = stringResource(id = R.string.tv_emailCheck, "lol"), style = MaterialTheme.typography.h1)
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    HRecTheme {
//        Greeting("Android")
//    }
<<<<<<< HEAD
//}
=======
//}
>>>>>>> cf1db6205633696024a218af047939ad66e4b9a3
