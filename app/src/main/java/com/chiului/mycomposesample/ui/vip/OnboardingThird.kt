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
fun onboardingThirdPage(onBackClick: () -> Unit, onNextClick: () -> Unit, onJumpClick: () -> Unit) {
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
            Image(painter = painterResource(id = R.drawable.bg_third), contentDescription = "讓聲音帶領你的旅途", modifier =  Modifier.size(164.dp, 172.dp), contentScale = ContentScale.Crop)
            Text(text = "隨時隨地掌握周邊地點資訊", fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(32.dp, 40.dp, 32.dp, 0.dp))
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "你亦可通過主頁面菜單開啟實時地圖，定位你的所在位置，或探索你身處的室外或室內環境。", fontSize = 14.sp
            )
        }

        ButtonNextAntJump(isJump = true, onNextClick = onNextClick, onJumpClick = onJumpClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingThird() {
    onboardingThirdPage({},{},{})
}