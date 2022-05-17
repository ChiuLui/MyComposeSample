package com.chiului.mycomposesample.utils

import android.content.Context
import android.provider.Settings
import android.text.TextUtils
import android.util.Log

/**
 * 判断TalkBack 工具类$
 * @author    Lei
 * @date      2022/05/17 15:40
 */
object TalkBackUtil {

    /**
     * 读屏是否开启
     */
    fun isAccessibilityEnabled(context: Context): Boolean {
        val settingValue = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        )
        if (settingValue != null) {
            val splitter = TextUtils.SimpleStringSplitter(':')
            splitter.setString(settingValue)
            while (splitter.hasNext()) {
                val accessabilityService: String = splitter.next()
                Log.d("SplashActivity", "Setting: $accessabilityService")
                //talkback读屏(大部分Android手机，部分小米华为机型)
                val service1 =
                    "com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService"
                //小米读屏
                val service2 = "com.google.android.marvin.talkback/.TalkBackService"
                //华为读屏
                val service3 = "com.bjbyhd.screenreader_huawei.ScreenReaderService"
                //天坦读屏(三方读屏APP)
                val service4 =
                    "com.android.tback/com.google.android.marvin.talkback.TalkBackService"
                //点名安卓(三方读屏APP)
                val service5 = "com.dianming.phoneapp/com.dianming.phoneapp.MyAccessibilityService"
                if (accessabilityService.contains(service1, false)
                    || accessabilityService.contains(service2, false)
                    || accessabilityService.contains(service3, false)
                    || accessabilityService.contains(service4, false)
                    || accessabilityService.contains(service5, false)
                ) {
                    return true
                }
            }
        }
        return false
    }

}