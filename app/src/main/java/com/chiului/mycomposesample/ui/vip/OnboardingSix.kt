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
fun onboardingSixPage(onBackClick: () -> Unit, onNextClick: () -> Unit, onJumpClick: () -> Unit) {
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
            Image(painter = painterResource(id = R.drawable.ic_six), contentDescription = "聲音信標助你確認方向", modifier =  Modifier.width(137.dp), contentScale = ContentScale.Crop)
            Text(text = "聲音信標助你確認方向", fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(32.dp, 40.dp, 32.dp, 0.dp))
            Text(
                color = Color.Black,
                modifier = Modifier.padding(32.dp, 24.dp, 32.dp, 0.dp),
                text = "開始導航後，聲音信標將於每個轉彎位啟動，助你準確面向正確的方向，亦能在你旅途中偏離路線時助你重新調整方向。", fontSize = 14.sp
            )
        }

        ButtonNextAntJump(isJump = true, onNextClick = onNextClick, onJumpClick = onJumpClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingSix() {
    onboardingSixPage({},{},{})
}