package com.chiului.mycomposesample.vip

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun onboardingSecondPage(onBackClick: () -> Unit, onNextClick: () -> Unit, onJumpClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TopBarBack(onBackClick)
        Column(
            Modifier
                .weight(1F),
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.bg_second), contentDescription = "讓聲音帶領你的旅途", modifier =  Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
            Text(text = "讓聲音帶領你的旅途", fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(32.dp, 40.dp, 32.dp, 0.dp))
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "你可通過主頁面菜單上的語音播報按鈕，即時了解你的當前位置，以及離你附近的地點資訊。", fontSize = 14.sp
            )
        }

        ButtonNextAntJump(isJump = true, onNextClick = onNextClick, onJumpClick = onJumpClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingSecond() {
    onboardingSecondPage({},{},{})
}