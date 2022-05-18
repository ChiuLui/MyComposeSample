package com.chiului.mycomposesample.ui

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chiului.mycomposesample.R
import com.chiului.mycomposesample.ui.wechat.WeViewModel
import com.chiului.mycomposesample.ui.wechat.ui.ChatList
import com.chiului.mycomposesample.ui.wechat.ui.ChatPage
import com.chiului.mycomposesample.ui.wechat.ui.HomePage
import com.chiului.mycomposesample.ui.wechat.ui.WeBottomBar
import com.chiului.mycomposesample.ui.wechat.ui.theme.WeComposeTheme
import com.chiului.mycomposesample.ui.wechat.ui.theme.black
import com.chiului.mycomposesample.ui.wechat.ui.theme.green3
import com.chiului.mycomposesample.ui.wechat.ui.theme.white1
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

/**
 * $ 微信示例首页
 * @author    Lei
 * @date      2022/05/17 16:23
 */

@Composable
fun WeHome() {

    val viewModel: WeViewModel = viewModel()

    WeComposeTheme(viewModel.theme) {
        Box {
            HomePage(viewModel)
            ChatPage()
        }
    }

    BackHandler(viewModel.chatting) {
        viewModel.endChat()
    }
}
