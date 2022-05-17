package com.chiului.mycomposesample.vip.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiului.mycomposesample.R

/**
 * $
 * @author    Lei
 * @date      2022/05/16 17:24
 */


@Composable
fun ButtonNextAntJump(
    isJump: Boolean,
    text: String = "繼續",
    onNextClick: () -> Unit, onJumpClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(32.dp, 0.dp, 32.dp, 32.dp)) {

        Button(
            onClick = onNextClick,
            Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.blue),
                contentColor = Color.White
            )
        ) {
            Text(text = text, fontSize = 16.sp)
        }
        if (isJump) {
            Text(text = "跳過",
                fontSize = 14.sp,
                color = colorResource(id = R.color.grey),
                modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 32.dp)
                    .clickable {
                        onJumpClick()
                    }
            )
        }
    }
}