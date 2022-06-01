package com.example.hrec.presentation.forgotPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.SIGN_IN_ROUTE

@Composable
fun ForgotPasswordNew(
    navController: NavHostController
//    onClick : () -> Unit
){

    var newPass by remember{
        mutableStateOf("")
    }
    var confPass by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.primary)
        )
        {
            Row(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.primary)),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column(modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(id = R.string.tv_forgotPasswordVerify),
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White)
                }
            }
            Row(modifier = Modifier
                .fillMaxHeight()
                .padding(start = dimensionResource(id = R.dimen.small))
                ,horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically)
            {
                Image(modifier = Modifier
                    .fillMaxHeight()
                    .width(35.dp)
                    .clickable { /*TODO*/ },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "back button")
            }
        }
        Surface(modifier = Modifier
            .fillMaxWidth()
            .weight(12f)
            .clip(
                RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.large),
                    topEnd = dimensionResource(id = R.dimen.large)
                )
            ),
            color = Color.White)
        {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.large_to_huge)))
            {
                Text(text = stringResource(id = R.string.tv_titleSuccessEnterNewPassword, "dummy"),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black)

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.normal_to_large)))

                Column(modifier = Modifier
                    .fillMaxWidth()){
                    OutlinedTextField(modifier = Modifier
                        .fillMaxWidth(),
                        value = newPass,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange ={
                            newPass = it
                        },label = {
                            Text(text = stringResource(id = R.string.tv_newPassword))
                        },
                        placeholder = {
                            Text(text = stringResource(id = R.string.edt_hintPassword))
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        maxLines = 1,
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal)))

                    OutlinedTextField(modifier = Modifier
                        .fillMaxWidth(),
                        textStyle = MaterialTheme.typography.body1,
                        value = confPass,
                        onValueChange ={
                            confPass = it
                        },label = {
                            Text(text = stringResource(id = R.string.tv_confirmNewPassword))
                        },
                        placeholder = {
                            Text(text = stringResource(id = R.string.edt_hintConfirmPassword))
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        maxLines = 1,
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
                Column(modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom)
                {
                    Button(
                        onClick = { navController.navigate(SIGN_IN_ROUTE) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.very_small_to_small))),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primary))
                            ) {
                            Text(modifier = Modifier.padding(dimensionResource(id = R.dimen.very_small_to_small)),
                                text = stringResource(id = R.string.btn_changePassword),
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(id = R.color.white))
                    }
                }
            }
        }
    }
}

//@Preview(name = "Light Mode")
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
//
//@Preview(showBackground = true)
//@Composable
//fun ForgotPasswordNewPreview(){
//    ForgotPasswordNew()
//}