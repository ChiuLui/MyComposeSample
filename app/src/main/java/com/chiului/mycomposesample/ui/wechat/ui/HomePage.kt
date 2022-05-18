package com.chiului.mycomposesample.ui.wechat.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chiului.mycomposesample.ui.wechat.WeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

/**
 * $
 * @author    Lei
 * @date      2022/05/18 23:39
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(viewModel: WeViewModel) {
    Column {

        HorizontalPager(count = 4, Modifier.weight(1f)) { page ->
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }
        }

        WeBottomBar(viewModel.selectTab) { viewModel.selectTab = it }
    }
}