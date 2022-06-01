package com.example.hrec.presentation.signIn

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.*

@Composable
fun SignIn(
    navController: NavHostController
//    onClick : () -> Unit
    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
    ) {
        Surface(modifier = Modifier
            .weight(13f)
            .fillMaxWidth()
            ) {

            Column(modifier = Modifier
                .padding(dimensionResource(id = R.dimen.large_to_huge))) {
                Row(modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.large_to_huge))
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(130.dp),
                        painter = painterResource(id = R.drawable.ic_logo), contentDescription = "App Logo",
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.large))
                    ) {
                        Row(modifier = Modifier
                            .height(130.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                style = MaterialTheme.typography.h1,
                                fontSize = 42.sp,
                                color = colorResource(id = R.color.primary),
                                fontWeight = FontWeight.Bold,
                                text = stringResource(id = R.string.app_name))
                        }
                    }
                }

                var email by rememberSaveable { mutableStateOf("") }

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = email,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange ={
                        email = it
                    },label = {
                        Text(text = stringResource(id = R.string.tv_Email))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary))
                )

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.small_to_normal)))

                var password by rememberSaveable { mutableStateOf("") }
                var passwordVisibility by remember { mutableStateOf(false) }

                val icon = if (passwordVisibility)
                    painterResource(id = R.drawable.design_ic_visibility)
                else
                    painterResource(id = R.drawable.design_ic_visibility_off)

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = password,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange ={
                        password = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.tv_Password))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = icon,
                                contentDescription = "Visibility"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
                )
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Row() {
                            Button(
                                onClick = { /*TODO*/ },
                                contentPadding = PaddingValues(),
                                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.white),
                                    contentColor = colorResource(id = R.color.primary)
                                ),
                            ) {
                                Image(painter = painterResource(id = R.drawable.ic_unchecked), contentDescription = "Unchecked Logo")
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 4.dp),
                                    text = stringResource(id = R.string.tv_checkStaySigned),
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.subtitle1)
                            }
                        }
                    }

                    Column() {
                        Row() {
                            Button(onClick = {
                                                navController.navigate(
                                                    route = FORGOT_PASSWORD_ROUTE
                                                )
                                             },
                                contentPadding = PaddingValues(),
                                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.white),
                                    contentColor = colorResource(id = R.color.dark_green)),
                            ) {
                                Text(
                                    text = stringResource(id = R.string.tv_forgotPassword),
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.subtitle1)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.normal_to_large)))
                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.normal_to_large)))
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(onClick = {
                        navController.navigate(
                            route = ONBOARD_ROUTE)
                                     },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small))),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.primary),
                            contentColor = colorResource(id = R.color.white)),) {
                        Text(
                            modifier = Modifier.padding(dimensionResource(id = R.dimen.very_small_to_small)),
                            style = MaterialTheme.typography.h6,
                            fontSize = 18.sp,
                            text = stringResource(id = R.string.btn_signIn),
                            )
                    }
                }

                Row() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier
                                        .padding(dimensionResource(id = R.dimen.very_small_to_small)),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(text = stringResource(id = R.string.tv_noAccount),
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorResource(id = R.color.primary),
                                        style = MaterialTheme.typography.subtitle1)
                                }
                            }
                                Text(modifier = Modifier.clickable {
                                    navController.navigate(
                                        route = SIGN_UP_ROUTE)
                                },
                                    text = stringResource(id = R.string.btn_signUp),
                                    fontWeight = FontWeight.SemiBold,
                                    style = TextStyle(
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.dark_green)
                                )
                        }
                    }
                }

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.text_normal)))
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(5f)) {
                Divider(color = colorResource(id = R.color.light_gray), thickness = 2.dp)
            }
            Column(modifier = Modifier.weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = R.string.tv_or),
                color = colorResource(id = R.color.light_gray),
                fontWeight = FontWeight.SemiBold
                )
            }
            Column(modifier = Modifier.weight(5f)) {
                Divider(color = colorResource(id = R.color.light_gray), thickness = 2.dp)
            }
        }

        Spacer(modifier = Modifier
            .height(dimensionResource(id = R.dimen.normal_to_large)))

        Surface(modifier = Modifier
            .weight(3f)
            .fillMaxWidth()) {

            Column(
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(modifier = Modifier.weight(5f),
                    horizontalAlignment = Alignment.End) {
                        Button(
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.dp, colorResource(id = R.color.black)),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.white),
                                contentColor = colorResource(id = R.color.black)
                            ),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.small)),
                            modifier = Modifier
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small)))
                                .padding(horizontal = dimensionResource(id = R.dimen.small)),
                        ) {
                            Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = "Google")
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = dimensionResource(id = R.dimen.small_to_normal)),
                                text = stringResource(id = R.string.btn_google),
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold)
                        }
                    }

                    Column(modifier = Modifier.weight(1f)) {

                    }

                    Column(modifier = Modifier.weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.dp, colorResource(id = R.color.light_gray)),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.teal_primary),
                                contentColor = colorResource(id = R.color.white)
                            ),
                            modifier = Modifier
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small))),
                        ) {
                            Image(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "Facebook")
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp),
                                text = stringResource(id = R.string.btn_facebook),
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement =  Arrangement.Bottom
            ) {
                Text(text = stringResource(id = R.string.app_copyrightClaim),
                    color = colorResource(id = R.color.light_gray),
                    modifier = Modifier.padding(bottom = 14.dp),
                    fontSize = 10.sp,
                    style = MaterialTheme.typography.subtitle2)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignIn(navController = rememberNavController())
}