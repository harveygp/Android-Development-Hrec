package com.example.hrec.presentation.profile

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hrec.R
import com.example.hrec.presentation.navigation.SIGN_IN_ROUTE

@Composable
fun Profile(
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
                        text = stringResource(id = R.string.tv_profile),
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Surface(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp),
                            horizontalArrangement = Arrangement.Center
                        )
                        {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {
                                Image(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(120.dp)
                                        .border(
                                            10.dp,
                                            colorResource(id = R.color.primary),
                                            CircleShape
                                        ),
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = "Profile Image"
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom
                        )
                        {
                            Column(
                                modifier = Modifier.width(120.dp),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Bottom
                            )
                            {
                                Button(modifier = Modifier
                                    .size(dimensionResource(id = R.dimen.huge))
                                    .defaultMinSize(minWidth = 4.dp, minHeight = 4.dp),
                                    contentPadding = PaddingValues(),
                                    shape = CircleShape,
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        backgroundColor = colorResource(id = R.color.primary)
                                    ),
                                    onClick = { /*TODO*/ })
                                {
                                    Image(
                                        modifier = Modifier
                                            .size(dimensionResource(id = R.dimen.normal)),
                                        painter = painterResource(id = R.drawable.ic_profileimage),
                                        contentDescription = "Profile Image"
                                    )
                                }
                            }
                        }
                    }
                }
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
                        Text(text = stringResource(id = R.string.tv_name))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)),
                    trailingIcon = {
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit" )
                    }
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
                        Text(text = stringResource(id = R.string.tv_Email))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)),
                    trailingIcon = {
                        Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Check" )
                    }
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
                                Text(text = stringResource(id = R.string.tv_position))
                            },
                            maxLines = 1,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = colorResource(id = R.color.primary))
                        )
                    }

                    Row(modifier = Modifier
                        .weight(1f)
                        .padding(start = dimensionResource(id = R.dimen.small))
                        .align(Alignment.CenterVertically)) {
                        Image(modifier = Modifier.size(dimensionResource(id = R.dimen.normal_to_large)),
                            painter = painterResource(id = R.drawable.ic_explanation),
                            contentDescription = "Explain")
                    }
                }
                Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start)
                {
                    Button(modifier = Modifier.clip(
                        RoundedCornerShape(dimensionResource(id = R.dimen.small_to_normal))),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_primary)),
                        onClick = {
                            navController.navigate(
                                route = SIGN_IN_ROUTE
                            )
                        }) {
                        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.very_small_to_small))){
                            Image(painter = painterResource(id = R.drawable.ic_out),
                                contentDescription = "Logout")

                            Text(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.small)),
                                text = stringResource(id = R.string.tv_logout),
                                style = MaterialTheme.typography.body1,
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
fun ProfilePreview() {
    Profile(navController = rememberNavController())
}