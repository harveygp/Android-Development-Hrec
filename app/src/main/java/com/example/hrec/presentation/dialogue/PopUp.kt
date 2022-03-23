package com.example.hrec.presentation.dialogue

import android.graphics.Paint
import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hrec.R
import com.example.hrec.presentation.ui.theme.HRecTheme
import com.example.hrec.presentation.ui.theme.RubikTypography

@Composable
fun DirectorUnchecked(
    textButton: String,
    colorButtonOn: Color,
    colorButtonOff: Color,
    iconButton: Painter
) {
    Column(
        modifier = Modifier
            .height(153.dp)
            .width(245.dp)
    ) {
        Text(
            text = stringResource(id = R.string.tv_acceptTo, "Director"),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 9.dp, bottom = 18.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 32.dp, bottom = 20.dp)
                .defaultMinSize(minWidth = 0.dp, minHeight = 0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(
                    id = R.color.transparent
                )
            )
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_unchecked),
                    contentDescription = "Check",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = stringResource(id = R.string.tv_checkYes),
                    style = MaterialTheme.typography.subtitle2,
                    color = colorResource(
                        id = R.color.light_primary
                    )
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(topEnd = dimensionResource(id = R.dimen.very_small)))
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = stringResource(id = R.string.tv_cancel),
                        color = Color.Gray,
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = dimensionResource(id = R.dimen.very_small)))
                    .background(color = colorButtonOff)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Row() {
                        Image(
                            painter = iconButton,
                            contentDescription = "Accept",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = textButton,
                            color = Color.White,
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DirectorUnchecked(
        stringResource(id = R.string.tv_Accept),
        colorResource(id = R.color.dark_red_wrong),
        colorResource(id = R.color.red_wrong),
        painterResource(
            id = R.drawable.ic_out
        )
    )
}