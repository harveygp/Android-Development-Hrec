package com.example.hrec.presentation.applicantDetail

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hrec.R

@Composable
fun ApplicantDetail(
    viewModel: ApplicantDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Log.d("masukApplciantDetail", state.applicant.toString())

    var nameProfile = ""
    var email = ""
    var specialization = ""
    var lastDegree = ""
    var experience = ""
    var speech = ""
    var leadership = ""
    var thinking = ""
    var math = ""
    var solving = ""
    var organizing = ""
    var score = ""

    if (state.applicant != null ) {
        nameProfile = state.applicant.name
        email = state.applicant.email
        specialization = state.applicant.specialization
        lastDegree = state.applicant.degree
        experience = uiExp(state.applicant.experience)
        speech = state.applicant.evaluation.speech.toString()
        leadership = state.applicant.evaluation.leadership.toString()
        thinking = state.applicant.evaluation.thinking.toString()
        math = state.applicant.evaluation.math.toString()
        solving = state.applicant.evaluation.solving.toString()
        organizing = state.applicant.evaluation.organizing.toString()
        score = listOf(
            state.applicant.evaluation.speech,
            state.applicant.evaluation.leadership,
            state.applicant.evaluation.thinking,
            state.applicant.evaluation.math,
            state.applicant.evaluation.solving,
            state.applicant.evaluation.organizing).sum().div(6).toString()
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
                .verticalScroll(rememberScrollState())
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
                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.large))
                )

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value =nameProfile ,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = {
                    }, label = {
                        Text(text = stringResource(id = R.string.tv_name))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)
                    ),
                    enabled = false
                )

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = email,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = {
                    }, label = {
                        Text(text = stringResource(id = R.string.tv_Email))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)
                    ),
                    enabled = false
                )

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = specialization,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = {
                    }, label = {
                        Text(text = stringResource(id = R.string.tv_specialization))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)
                    ),
                    enabled = false
                )

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = lastDegree,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = {
                    }, label = {
                        Text(text = stringResource(id = R.string.tv_lastDegree))
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)
                    ),
                    enabled = false
                )

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value =experience,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = {
                    }, label = {
                        Text(text = stringResource(id = R.string.tv_experience))
                    },
                    maxLines = 5,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.primary)
                    ),
                    enabled = false
                )


                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.text_normal))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Divider(color = colorResource(id = R.color.light_gray), thickness = 2.dp)
                    }
                    Column(
                        modifier = Modifier.weight(3f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.tv_evaluation),
                            color = colorResource(id = R.color.light_gray),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(modifier = Modifier.weight(5f)) {
                        Divider(color = colorResource(id = R.color.light_gray), thickness = 2.dp)
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {

                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = speech,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_speech))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )

                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = leadership,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_speech))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )

                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = thinking,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_speech))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {

                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = math,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_speech))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )

                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = solving,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_speech))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )

                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = organizing,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        }, label = {
                            Text(text = stringResource(id = R.string.tv_speech))
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.small_to_normal))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.End
                )
                {
                    Text(text = stringResource(id = R.string.tv_score))
                    Spacer(
                        modifier = Modifier
                            .width(dimensionResource(id = R.dimen.small_to_normal))
                    )
                    OutlinedTextField(modifier = Modifier
                        .width(80.dp),
                        value = score,
                        textStyle = MaterialTheme.typography.body1,
                        onValueChange = {
                        },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = colorResource(id = R.color.primary)
                        ),
                        enabled = false
                    )
                }
            }
        }
        if (state.error.isNotBlank()){
            Log.d("Error", state.error)
        }
        if(state.isLoading && state.applicant == null){
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

fun uiExp( a : MutableList<String>) : String {
    if(a.size < 1){
        return "-"
    }
    return "1. ${a[0] ?: "="}\n2. ${a[1] ?: "-"}\n3. ${a[2] ?: "="}"
}

@Preview(showBackground = true)
@Composable
fun ApplicantDetailPreview() {
    ApplicantDetail()
}
