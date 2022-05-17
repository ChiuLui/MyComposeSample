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
fun onboardingFourPage(onBackClick: () -> Unit, onNextClick: () -> Unit, onJumpClick: () -> Unit) {
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
            Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = "尋找下個目的地", modifier =  Modifier.size(181.dp), contentScale = ContentScale.Crop)
            Text(text = "尋找下個目的地", fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(32.dp, 53.dp, 32.dp, 0.dp))
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "你亦可通過程式上的瀏覽或搜尋功能，於你的當前位置尋找附近地點，包括商店、餐廳、洗手間、或出入口位置。", fontSize = 14.sp
            )
        }

        ButtonNextAntJump(isJump = true, onNextClick = onNextClick, onJumpClick = onJumpClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingFour() {
    onboardingFourPage({},{},{})
}