package com.example.hrec.presentation.dashboard

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hrec.R

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hrec.presentation.navigation.PROFILE_ROUTE
import com.example.hrec.presentation.navigation.Screen
import com.example.hrec.presentation.ui.theme.HRecTheme

@Composable
fun Dashboard(navController: NavHostController) {

    val context = LocalContext.current
    var topNavRoute = "candidate"

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
            Scaffold(
                topBar = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(id = R.color.primary)),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Column(
                            modifier = Modifier
                                .padding(
                                    start = dimensionResource(id = R.dimen.small_to_normal),
                                    top = dimensionResource(id = R.dimen.small_to_normal),
                                    bottom = dimensionResource(id = R.dimen.small_to_normal)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Button(modifier = Modifier.clip(
                                RoundedCornerShape(dimensionResource(id = R.dimen.small))
                            ),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(
                                        id = R.color.primary
                                    )
                                ),
                                onClick = {
                                    topNavRoute = "candidate"
                                }) {
                                Row() {
                                    Image(
                                        modifier = Modifier.size(18.dp),
                                        painter = painterResource(id = R.drawable.ic_candidate),
                                        contentDescription = "Candidate"
                                    )

                                    Text(
                                        text = stringResource(id = R.string.tv_titleCandidate),
                                        style = MaterialTheme.typography.body1,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                }
                            }

                        }
                        Column(
                            modifier = Modifier
                                .padding(
                                    start = dimensionResource(id = R.dimen.small_to_normal),
                                    top = dimensionResource(id = R.dimen.small_to_normal),
                                    bottom = dimensionResource(id = R.dimen.small_to_normal)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Button(modifier = Modifier.clip(
                                RoundedCornerShape(dimensionResource(id = R.dimen.small))
                            ),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(
                                        id = R.color.primary
                                    )
                                ),
                                onClick = {
                                    topNavRoute = "accepted"
                                }) {
                                Row() {
                                    Image(
                                        modifier = Modifier.size(18.dp),
                                        painter = painterResource(id = R.drawable.ic_candidate_accepted),
                                        contentDescription = "Accepted"
                                    )

                                    Text(
                                        text = stringResource(id = R.string.tv_titleAccepted),
                                        style = MaterialTheme.typography.body1,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                }
                            }

                        }

                        Column(
                            modifier = Modifier
                                .padding(dimensionResource(id = R.dimen.small_to_normal)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.End
                        ) {
                            Button(modifier = Modifier
                                .size(dimensionResource(id = R.dimen.huge)),
                                contentPadding = PaddingValues(),
                                shape = CircleShape,
                                colors = ButtonDefaults.outlinedButtonColors(
                                    backgroundColor = colorResource(id = R.color.primary)
                                ),
                                onClick = {
                                    navController.navigate(
                                        route = PROFILE_ROUTE)
                                })
                            {
                                Image(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(120.dp)
                                        .border(
                                            2.dp,
                                            colorResource(id = R.color.white),
                                            CircleShape
                                        ),
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = "Profile Image"
                                )
                            }

                        }
                    }
                }
            ) {
                when (topNavRoute) {
                    "candidate" -> DashboardCandidate()
                    "accepted" -> DashboardAccepted()
                }
            }
        }

    }
}

@Composable
fun DashboardNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "candidate") {
        composable("candidate") {
            DashboardCandidate()
        }
        composable("accepted") {
            DashboardAccepted()
        }
    }
}

@Composable
fun DashboardCandidate() {
    Row(modifier = Modifier.fillMaxWidth()) {

    }
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
                SearchSection()
                Column(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.small))) {
                    CandidateList(amount = 10)
                }
            }
        }
    }

}

@Composable
fun DashboardAccepted() {

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
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Column(modifier = Modifier.padding(end = dimensionResource(id = R.dimen.small_to_normal))) {
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(
                                        0xfff1f1f1
                                    )
                                )
                            ) {
                                Text(
                                    text = "ALL",
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                        Column(modifier = Modifier.padding(end = dimensionResource(id = R.dimen.small_to_normal))) {
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                            ) {
                                Text(
                                    text = "ALL",
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Button(modifier = Modifier.clip(
                                RoundedCornerShape(dimensionResource(id = R.dimen.small))
                            ),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.White
                                ),
                                onClick = {
                                    /*TODO*/
                                }) {
                                Row() {
                                    Image(
                                        modifier = Modifier.size(20.dp),
                                        painter = painterResource(id = R.drawable.ic_filter_candidate),
                                        contentDescription = "Accepted"
                                    )
                                }
                            }
                        }
                    }
                }
                Column(modifier = Modifier) {
                    Divider("Ekonomi")
                    CandidateList(amount = 2)
                    Divider("Manajemen")
                    CandidateList(amount = 2)
                    Divider("IT")
                    CandidateList(amount = 2)
                }

            }
        }
    }
}

@Composable
fun CandidateList(amount: Int) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_to_normal)),
    ) {
        items(amount) {
            Box(
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small_to_normal)))
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.white))
                        .border(
                            3.dp,
                            colorResource(id = R.color.primary),
                            RoundedCornerShape(25),
                        )
                        .align(Alignment.BottomStart)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(id = R.dimen.large_to_huge),
                                end = dimensionResource(id = R.dimen.large_to_huge),
                                top = dimensionResource(id = R.dimen.normal)
                            )
                    ) {
                        Text(
                            text = "Derle Bohrmann",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h5,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            modifier = Modifier.padding(start = 72.dp, top = dimensionResource(id = R.dimen.very_small_to_small)),
                            text = "Economy, 90", style = MaterialTheme.typography.body2,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small)))

                }
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                            top = dimensionResource(id = R.dimen.small)
                        )
                        .align(TopStart)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(16.dp)
                            .background(colorResource(id = R.color.bright_green))
                    )
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            bottom = dimensionResource(id = R.dimen.small),
                            end = dimensionResource(id = R.dimen.small)
                        )
                ) {
                    Image(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(80.dp)
                            .border(
                                5.dp,
                                colorResource(id = R.color.primary),
                                CircleShape
                            ),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Profile Image"
                    )
                }

            }

        }
    }
}

@Composable
fun SearchSection() {

    val textState = remember { mutableStateOf(TextFieldValue()) }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.White
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            TextField(
                modifier = Modifier,
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp
                ),
                value = textState.value,
                onValueChange = { textState.value = it },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        tint = colorResource(id = R.color.primary),
                        contentDescription = "Icon Search"
                    )
                },
                label = null,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = colorResource(id = R.color.primary),
                    focusedIndicatorColor = Color.Black, //hide the indicator
                    unfocusedIndicatorColor = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "Search",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )
                }
            )
            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        /*ToDo*/
                    },
                painter = painterResource(id = R.drawable.ic_filter_candidate),
                tint = colorResource(id = R.color.primary),
                contentDescription = "Icon Filter"
            )
        }
    }
}

@Composable
fun Divider(title: String) {
    Surface(
        contentColor = Color.Black,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        Column(modifier = Modifier) {
            Row(
                modifier = Modifier.padding(
                    top = dimensionResource(id = R.dimen.small_to_normal),
                    bottom = dimensionResource(id = R.dimen.small_to_normal)
                ),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Box(
                    modifier = Modifier
                )
                {
                    Divider(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Black, thickness = 2.dp
                    )
                    Surface(
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.small_to_normal)),
                        color = Color.White
                    ) {
                        Text(
                            text = title,
                            color = Color.Black,
                            textAlign = TextAlign.Start,
                            lineHeight = 20.sp,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier
                                .padding(2.dp)
                        )
                    }

                }

            }
        }

    }
}

//@Preview
//@Composable
//fun DashboardPreview() {
//    Dashboard(navController = rememberNavController())
//}

@Preview
@Composable
fun DashboardCandidatePreview() {
    DashboardCandidate()
}
//
//@Preview
//@Composable
//fun DashboardAcceptedPreview() {
//    DashboardAccepted()
//}



