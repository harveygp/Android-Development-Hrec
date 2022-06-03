package com.example.hrec.presentation.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.hrec.R

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
//                Column(modifier = Modifier) {
//                    Divider("Ekonomi")
//                    CandidateList()
//                    Divider("Manajemen")
//                    CandidateList()
//                    Divider("IT")
//                    CandidateList()
//                }

            }
        }
    }
}