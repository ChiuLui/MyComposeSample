package com.chiului.mycomposesample.vip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiului.mycomposesample.vip.ui.ButtonNextAntJump

@Composable
fun EnableLocationPage(onStartClick: () -> Unit) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Column(
            Modifier
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "允許「 程式名稱」使用你的位置資訊",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 45.dp, 32.dp, 0.dp)
            )
            Text(
                text = "【程式名稱】根據你的實時位置提供相關位置及地點資訊。",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp)
            )
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "1.開啟手機設定\n" +
                        "2.選擇「【程式名稱】」\n" +
                        "3.選擇「位置」\n" +
                        "4.選擇「使用應用程式時」\n" +
                        "\n" +
                        "如需使用致電功能，請允許「程式名稱」在此裝置撥打電話及管理通話。", fontSize = 14.sp
            )
        }

        Column(Modifier.fillMaxWidth()) {
            ButtonNextAntJump(
                isJump = false,
                text = "開啟設定",
                onNextClick = onStartClick,
                onJumpClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEnableLocation() {
    EnableLocationPage({})
}