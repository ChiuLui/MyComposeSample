package com.chiului.mycomposesample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.chiului.mycomposesample.ui.SightedMode
import com.chiului.mycomposesample.ui.ViMode
import com.chiului.mycomposesample.ui.WeHome
import com.chiului.mycomposesample.ui.googlesample.*
import com.chiului.mycomposesample.utils.TalkBackUtil
import com.chiului.mycomposesample.vip.*

/**
 * 导航图$
 * @author    Lei
 * @date      2022/05/17 15:15
 */
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavConstant.Home) {
        composable(NavConstant.Home) {
            var context = LocalContext.current
            Home({
                navController.navigate(NavConstant.GOOGLE_SAMPLE)
            }, {
                navController.navigate(NavConstant.WECHAT)
            }, {
                navController.navigate(NavConstant.VIP)
            }, {
                if (TalkBackUtil.isAccessibilityEnabled(context)) {
                    navController.navigate(NavConstant.OTHER_VI)
                } else {
                    navController.navigate(NavConstant.OTHER_SIGHTED)
                }
            })
        }
        googleSampleGraph(navController)
        wechatGraph(navController)
        vipGraph(navController)
        otherGraph(navController)
    }

}

fun NavGraphBuilder.googleSampleGraph(navController: NavController) {
    navigation(startDestination = NavConstant.GOOGLE_SAMPLE_HOME, NavConstant.GOOGLE_SAMPLE) {
        composable(NavConstant.GOOGLE_SAMPLE_HOME) {
            GoogleSampleHome {
                navController.navigate(it)
            }
        }
        composable(NavConstant.GOOGLE_SAMPLE_BASICS) { GoogleSampleBasics() }
        composable(NavConstant.GOOGLE_SAMPLE_BASICS_CODELAB) { GoogleSampleBasicsCodelab() }
        composable(NavConstant.GOOGLE_SAMPLE_LAYOUT) { GoogleSampleLayout() }
        composable(NavConstant.GOOGLE_SAMPLE_LAYOUT_CODELAB) { GoogleSampleLayoutsCodelab() }
        composable(NavConstant.GOOGLE_SAMPLE_SIMPLE_CUSTOM_LAYOUT) { GoogleSampleSimpleCustomLayout() }
        composable(NavConstant.GOOGLE_SAMPLE_COMPLICATED_CUSTOM_LAYOUT) { GoogleSampleComplicatedCustomLayout() }
        composable(NavConstant.GOOGLE_SAMPLE_CONSTRAINT_LAYOUT) { GoogleSampleConstraintLayout() }
        composable(NavConstant.GOOGLE_SAMPLE_STATE) { GoogleSampleState() }
    }
}

fun NavGraphBuilder.wechatGraph(navController: NavController) {
    navigation(startDestination = NavConstant.WECHAT_HOME, NavConstant.WECHAT) {
        composable(NavConstant.WECHAT_HOME) { WeHome() }
    }
}

fun NavGraphBuilder.vipGraph(navController: NavController) {
    navigation(startDestination = NavConstant.VIP_HOME, NavConstant.VIP) {
        composable(NavConstant.VIP_HOME) { onboardingPage({navController.navigate(NavConstant.VIP_SECOND)}, { toVipEnableLocation(navController) }) }
        composable(NavConstant.VIP_SECOND) { onboardingSecondPage({navUp(navController)}, {navController.navigate(NavConstant.VIP_THIRD)}, {toVipEnableLocation(navController)}) }
        composable(NavConstant.VIP_THIRD) { onboardingThirdPage({navUp(navController)}, {navController.navigate(NavConstant.VIP_FOUR)}, {toVipEnableLocation(navController)}) }
        composable(NavConstant.VIP_FOUR) { onboardingFourPage({navUp(navController)}, {navController.navigate(NavConstant.VIP_FIVE)}, {toVipEnableLocation(navController)}) }
        composable(NavConstant.VIP_FIVE) { onboardingFivePage({navUp(navController)}, {navController.navigate(NavConstant.VIP_SIX)}, {toVipEnableLocation(navController)}) }
        composable(NavConstant.VIP_SIX) { onboardingSixPage({navUp(navController)}, {navController.navigate(NavConstant.VIP_ENABLE_LOCATION)}, {toVipEnableLocation(navController)}) }
        composable(NavConstant.VIP_ENABLE_LOCATION) { EnableLocationPage({}) }
    }
}

fun NavGraphBuilder.otherGraph(navController: NavController) {
    navigation(startDestination = NavConstant.OTHER_VI, NavConstant.OTHER) {
        composable(NavConstant.OTHER_VI) { ViMode() }
        composable(NavConstant.OTHER_SIGHTED) { SightedMode() }
    }
}

fun navUp(navController: NavController) {
    navController.navigateUp()
}

fun toVipEnableLocation(navController: NavController) {
    navController.navigate(NavConstant.VIP_ENABLE_LOCATION)
}