package com.chiului.mycomposesample.vip.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chiului.mycomposesample.R

/**
 * $
 * @author    Lei
 * @date      2022/05/16 17:27
 */

@Composable
fun TopBarBack(onClick: () -> Unit){
    Box(modifier = Modifier.padding(16.dp, 20.dp)) {
        Image(painter = painterResource(id = R.drawable.back),
            contentDescription = "back",
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .clickable { onClick() })
    }
}