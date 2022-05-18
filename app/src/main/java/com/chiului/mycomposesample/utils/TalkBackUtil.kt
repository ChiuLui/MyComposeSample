package com.chiului.mycomposesample.utils

import android.app.Activity
import android.content.Context
import android.view.accessibility.AccessibilityManager

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
        return (context.getSystemService(Activity.ACCESSIBILITY_SERVICE) as AccessibilityManager).isEnabled
    }

}