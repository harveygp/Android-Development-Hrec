package com.example.hrec.presentation.signUp

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.R

@Composable
fun SignUp(
    navController: NavHostController
//    onClick : () -> Unit
) {

    var nameProfile by remember{
        mutableStateOf("")
    }

    var email by remember{
        mutableStateOf("")
    }

    var position by remember{
        mutableStateOf("")
    }

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    val iconPassword = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

    val iconConfirmPassword = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

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
                )
                {
                    Text(
                        text = stringResource(id = R.string.tv_signUp),
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
                //body
                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.large)))

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = nameProfile,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange ={
                        nameProfile = it
                    },label = {
                        Text(text = stringResource(id = R.string.edt_hintFullName))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary))
                )

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.small_to_normal)))

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = email,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange ={
                        email= it
                    },label = {
                        Text(text = stringResource(id = R.string.edt_hintEmail))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary))
                )

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.small_to_normal)))

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = password,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange ={
                        password = it
                    },
                    placeholder = { Text(text = stringResource(id = R.string.edt_hintPassword))},
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
                                painter = iconPassword,
                                contentDescription = "Visibility"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.small_to_normal)))

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = password,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange ={
                        password = it
                    },
                    placeholder = { Text(text = stringResource(id = R.string.edt_hintConfirmPassword))},
                    label = {
                        Text(text = stringResource(id = R.string.tv_confirmPassword))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)),
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisibility = !confirmPasswordVisibility
                        }) {
                            Icon(
                                painter = iconConfirmPassword,
                                contentDescription = "Visibility"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.small_to_normal)))

                Row(modifier = Modifier.fillMaxWidth())
                {
                    Row(modifier = Modifier
                        .weight(1f)) {

                        OutlinedTextField(modifier = Modifier
                            .fillMaxWidth(),
                            value = position,
                            textStyle = MaterialTheme.typography.body1,
                            onValueChange ={
                                position= it
                            },label = {
                                Text(text = stringResource(id = R.string.edt_position))
                            },
                            maxLines = 1,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = colorResource(id = R.color.primary)),
                            trailingIcon = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_dropdown),
                                        contentDescription = "Job Position" ,
                                        tint = colorResource(id = R.color.primary)
                                    )
                                }
                            }
                        )
                    }

                    Row(modifier = Modifier
                        .weight(1f)
                        .padding(start = dimensionResource(id = R.dimen.small))
                        .align(Alignment.CenterVertically)) {
                    }
                }
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start)
                {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_unchecked),
                                contentDescription = "Unchecked",
                                tint = colorResource(id = R.color.teal_primary) )
                            Text(
                                text = stringResource(id = R.string.tv_termsService),
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier.padding(horizontal = 4.dp),
                                color = colorResource(id = R.color.teal_primary)
                            )
                        }
                    }

                    Spacer(modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small)))

                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(dimensionResource(id = R.dimen.small_to_normal))
                        ),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primary)),
                        onClick = { Toast.makeText(context,"Button Clicked ", Toast.LENGTH_LONG).show() }) {
                        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.very_small_to_small))){
                            Text(
                                text = stringResource(id = R.string.tv_signUp),
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White)
                        }
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

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp(navController = rememberNavController())
}