package com.example.hrec.presentation.dashboard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hrec.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hrec.presentation.dashboard.components.CandidateList
import com.example.hrec.presentation.navigation.PROFILE_ROUTE
import com.example.hrec.presentation.navigation.Screen

@Composable
fun Dashboard(
    navController: NavHostController
) {
    Log.d("iya", "masuk dashbrad")

    TopNavigationBar(navController)
}

@Composable
fun TopNavigationBar(
    navController: NavHostController
) {

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
                                        route = PROFILE_ROUTE
                                    )
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
                DashboardCandidate(navController = navController)
            }
        }

    }
}

@Composable
fun DashboardCandidate(
    navController: NavHostController,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
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

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_to_normal)),
                    ) {
                        items(state.applicants) { applicant ->
                            CandidateList(
                                applicant = applicant,
                                onItemClick = {
                                    navController.navigate(Screen.ApplicantDetail.route + "/${applicant._id}")}
                            )
                        }
                    }
                }
            }
        }
        if(state.error.isNotBlank()){
            Log.d("rusak1", "${state.error}")
        }
        if(state.isLoading){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
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




