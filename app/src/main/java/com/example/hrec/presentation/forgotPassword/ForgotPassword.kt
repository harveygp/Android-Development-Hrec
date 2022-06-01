package com.example.hrec.presentation.forgotPassword

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.Screen

@Composable
fun ForgotPassword(
    navController: NavHostController
//    onClick : () -> Unit
) {
    var hintEdtVerify by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.primary)
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.primary)),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.tv_forgotPasswordVerify),
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = dimensionResource(id = R.dimen.small)),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Image(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(35.dp)
                        .clickable { /*TODO*/ },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "back button"
                )
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(12f)
                .clip(
                    RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.large),
                        topEnd = dimensionResource(id = R.dimen.large)
                    )
                ),
            color = Color.White
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.large_to_huge))
            )
            {
                Text(
                    text = stringResource(id = R.string.tv_titleForgotPassword, "dummy"),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.normal_to_large))
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    OutlinedTextField(modifier = Modifier
                        .fillMaxWidth(),
                        value = hintEdtVerify,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                            hintEdtVerify = it
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_verifyCode))
                        },
                        placeholder = {
                            Text(text = stringResource(id = R.string.edt_hintVerifyCode))
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Go
                        ),
                        maxLines = 1,
                        keyboardActions = KeyboardActions(
                            onGo = {
                                Toast.makeText(context, "Button Clicked ", Toast.LENGTH_LONG).show()
                            }
                        )
                    )
                    Spacer(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.small))
                    )

                    Text(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(
                                    route = Screen.ForgotPasswordNew.route
                                )
                            },
                        text = stringResource(id = R.string.tv_sendVerifyCode),
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.dark_green)
                    )
                }
            }
        }
    }
}

//@Composable
//fun BackButtonHrec(
//    onClick : () -> Unit,
//    description : String
//){
//    Image(modifier = Modifier
//        .fillMaxHeight()
//        .width(35.dp)
//        .clickable { onClick },
//        painter = painterResource(id = R.drawable.ic_arrow_back),
//        contentDescription = description)
//}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    ForgotPassword(navController = rememberNavController())
}