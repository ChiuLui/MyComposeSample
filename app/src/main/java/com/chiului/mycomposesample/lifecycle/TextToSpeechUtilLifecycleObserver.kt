package com.chiului.mycomposesample.lifecycle

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.chiului.mycomposesample.utils.TextToSpeechUtil

/**
 * $
 * @author    Lei
 * @date      2022/05/27 16:10
 */
class TextToSpeechUtilLifecycleObserver(val context: Context): DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        TextToSpeechUtil.init(context)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        TextToSpeechUtil.getInstance().stop()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        TextToSpeechUtil.getInstance().shutdown()
    }

}