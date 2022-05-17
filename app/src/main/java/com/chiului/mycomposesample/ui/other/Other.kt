package com.chiului.mycomposesample.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chiului.mycomposesample.navigation.Greeting

/**
 * $
 * @author    Lei
 * @date      2022/05/17 16:13
 */

@Composable
fun SightedMode() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Greeting("Sighted Mode")
    }
}

@Composable
fun ViMode() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Greeting("VI Mode")
    }
}