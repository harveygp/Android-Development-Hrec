package com.example.hrec.presentation.notification

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import com.example.hrec.presentation.dialogue.DirectorUnchecked

@Composable
fun HeaderNotification() {
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
                        text = stringResource(id = R.string.tv_notification),
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

            }
        }
    }
}

fun Notification() {
    Column() {
        Text(text = )
        Text(text = )
        Text(text = )
        Text(text = )
        Text(text = )
        Text(text = )
        Text(text = )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeaderNotification()
}