package com.chiului.mycomposesample.vip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiului.mycomposesample.vip.ui.ButtonNextAntJump

@Composable
fun onboardingPage(onNextClick: () -> Unit, onJumpClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            Modifier
                .weight(1F),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "歡迎你",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp)
            )
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "使用出行小幫手助你出行，讓你在旅途中隨時掌握地點資訊。\n" +
                        "\n" +
                        "你現可於此程式了解以下地點資訊：\n" +
                        "\n" +
                        "•港鐵觀塘線\n" +
                        "•港鐵啟德站\n" +
                        "•九龍灣德福廣場一期及二期\n" +
                        "•九龍灣企業廣場五期\n" +
                        "•觀塘裕民坊\n" +
                        "\n" +
                        "在開始使用前，請先準備戴上你的耳機以得到最佳體驗。", fontSize = 14.sp
            )
        }

        ButtonNextAntJump(false, "開始使用", onNextClick = onNextClick, onJumpClick = onJumpClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingPage() {
    onboardingPage({}, {})
}