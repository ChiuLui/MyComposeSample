package com.chiului.mycomposesample.vip

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiului.mycomposesample.R
import com.chiului.mycomposesample.vip.ui.ButtonNextAntJump
import com.chiului.mycomposesample.vip.ui.TopBarBack

@Composable
fun onboardingFivePage(onBackClick: () -> Unit, onNextClick: () -> Unit, onJumpClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TopBarBack(onBackClick)
        Column(
            Modifier
                .weight(1F),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_five),
                contentDescription = "引領你導航到目的地",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "引領你導航到目的地",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 40.dp, 32.dp, 0.dp)
            )
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "透過導航功能，你可於室內及室外空間無縫穿梭。在旅程途中，我們能提供實時路程資訊、以及距離資訊的更新。", fontSize = 14.sp
            )
        }

        ButtonNextAntJump(isJump = true, onNextClick = onNextClick, onJumpClick = onJumpClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingFive() {
    onboardingFivePage({}, {}, {})
}