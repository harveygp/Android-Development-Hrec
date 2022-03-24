package com.example.hrec.presentation.signIn

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.FORGOT_PASSWORD_ROUTE
import com.example.hrec.presentation.navigation.Screen
import com.example.hrec.presentation.profile.Profile

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
                    .padding(dimensionResource(id = R.dimen.large_to_huge))
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
                            .padding(start = dimensionResource(id = R.dimen.large)),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Row(modifier = Modifier
                            .height(130.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                style = MaterialTheme.typography.h4,
                                color = colorResource(id = R.color.primary),
                                fontWeight = FontWeight.ExtraBold,
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
                    placeholder = { Text(text = stringResource(id = R.string.tv_Password))},
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
                                    fontWeight = FontWeight.SemiBold)
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
                                    fontWeight = FontWeight.SemiBold)
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
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small))),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.primary),
                            contentColor = colorResource(id = R.color.white)),) {
                        Text(
                            modifier = Modifier.padding(dimensionResource(id = R.dimen.very_small_to_small)),
                            style = MaterialTheme.typography.h6,
                            text = stringResource(id = R.string.btn_signIn),
                            )
                    }
                }

                Row() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier
                                        .padding(dimensionResource(id = R.dimen.padding_small)),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(text = stringResource(id = R.string.tv_noAccount),
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorResource(id = R.color.primary))
                                }
                            }
                            Button(
                                onClick = {
                                            navController.navigate(
                                                route = Screen.SignUp.route
                                            )
                                          },
                                contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.padding_small)),
                                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.white),
                                    contentColor = colorResource(id = R.color.dark_green)
                                ),
                            ) {
                                Text(
                                    text = stringResource(id = R.string.btn_signUp),
                                    fontWeight = FontWeight.SemiBold,
                                    style = TextStyle(
                                        textDecoration = TextDecoration.Underline
                                    )
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.text_normal)))

//                Row(modifier = Modifier
//                    .padding(horizontal = dimensionResource(id = R.dimen.large_to_huge)),
//                ) {
//                    OutlinedTextField(modifier = Modifier
//                        .fillMaxWidth(),
//                        value = "nameProfile",
//                        textStyle = MaterialTheme.typography.body1,
//                        onValueChange ={
////                        nameProfile = it
//                        },label = {
//                            Text(text = stringResource(id = R.string.tv_name))
//                        },
//                        maxLines = 1,
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = colorResource(id = R.color.primary)),
//                        trailingIcon = {
//                            Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit" )
//                        }
//                    )
//
//                    Spacer(modifier = Modifier
//                        .height(dimensionResource(id = R.dimen.small_to_normal)))
//
//                    OutlinedTextField(modifier = Modifier
//                        .fillMaxWidth(),
//                        value = "email",
//                        textStyle = MaterialTheme.typography.body1,
//                        onValueChange ={
////                        email= it
//                        },label = {
//                            Text(text = stringResource(id = R.string.tv_Email))
//                        },
//                        maxLines = 1,
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = colorResource(id = R.color.primary)),
//                        trailingIcon = {
//                            Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Check" )
//                        }
//                    )
//                }
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
                modifier = Modifier.padding(bottom = 14.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignIn(navController = rememberNavController())
}