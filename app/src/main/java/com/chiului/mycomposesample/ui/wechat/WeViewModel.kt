package com.chiului.mycomposesample.ui.wechat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * ViewModel$
 * @author    Lei
 * @date      2022/05/18 01:26
 */
class WeViewModel: ViewModel() {

    var selectTab by mutableStateOf(0)

}