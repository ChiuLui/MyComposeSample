package com.chiului.mycomposesample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.chiului.mycomposesample.R

/**
 * $ 微信示例首页
 * @author    Lei
 * @date      2022/05/17 16:23
 */

@Composable
fun WeBottomBar() {
    Row(Modifier.fillMaxWidth()) {
        Column {
            Image(painter = painterResource(id = R.drawable.ic_chat_outlined), contentDescription = "聊天")
            Text(text = "聊天")
        }
    }
}