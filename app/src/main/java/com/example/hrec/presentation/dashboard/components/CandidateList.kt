package com.example.hrec.presentation.dashboard.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hrec.R
import com.example.hrec.domain.model.UserApplicant
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun CandidateList(
    applicant: UserApplicant,
    onItemClick: (UserApplicant) -> Unit
) {
    val score = listOf(
        applicant.evaluation.speech,
        applicant.evaluation.leadership,
        applicant.evaluation.thinking,
        applicant.evaluation.math,
        applicant.evaluation.solving,
        applicant.evaluation.organizing
    ).sum()/6

    val accept = SwipeAction(
        icon = painterResource(R.drawable.ic_btn_accept),
        background = colorResource(id = R.color.white),
        onSwipe = { Log.d("accept", "swipe accept berhasil") }
    )

    val reject = SwipeAction(
        icon = painterResource(R.drawable.ic_btn_reject),
        background = colorResource(id = R.color.white),
        //isUndo = true,
        onSwipe = { Log.d("reject", "swipe reject berhasil") },
    )

    SwipeableActionsBox(
        startActions = listOf(accept),
        endActions = listOf(reject),
        swipeThreshold = 200.dp,
        backgroundUntilSwipeThreshold = colorResource(id = R.color.transparent)
    ) {
        Box(
            modifier = Modifier
                .clickable { onItemClick(applicant) }
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
//                            .clickable {  }
                        .fillMaxWidth()
                        .padding(
                            start = dimensionResource(id = R.dimen.large_to_huge),
                            end = dimensionResource(id = R.dimen.large_to_huge),
                            top = dimensionResource(id = R.dimen.normal)
                        )
                ) {
                    Text(
                        text = applicant.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 72.dp,
                            top = dimensionResource(id = R.dimen.very_small_to_small)
                        ),
                        text = stringResource(
                            id = R.string.tv_positionAndScore,
                            applicant.specialization,
                            score
                        ),
                        style = MaterialTheme.typography.body2,
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
                    .align(Alignment.TopStart)
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
