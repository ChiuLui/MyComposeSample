package com.chiului.mycomposesample.utils

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import com.chiului.mycomposesample.lifecycle.TextToSpeechUtilLifecycleObserver
import java.util.*

/**
 * 语音播报工具类$
 * @author    Lei
 * @date      2022/05/27 15:06
 */
object TextToSpeechUtil {

    private lateinit var speech: TextToSpeech

    fun addLifecycleObserver(context: Context, lifecycle: Lifecycle){
        lifecycle.addObserver(TextToSpeechUtilLifecycleObserver(context))
    }

    fun init(context: Context) {
        if (!::speech.isInitialized) {
            speech = TextToSpeech(
                context
            ) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    val result = speech.setLanguage(
                        when {
                            Locale.getDefault().language.equals("zh") -> Locale("yue", "HKG")
                            else -> Locale.UK
                        }
                    )
                    if (result != TextToSpeech.LANG_AVAILABLE) {
                        speech?.language = Locale.getDefault()
                    }
                    Log.i(
                        "MainActivityViewModel",
                        "onCreate: ${speech?.availableLanguages}"
                    )
                } else if (status == TextToSpeech.ERROR) {
                    Toast.makeText(context, "tts init failed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun stop() {
        if (::speech.isInitialized) {
            if (speech.isSpeaking) speech.stop()
        } else {
            throw ExceptionInInitializerError()
        }
    }

    fun speak(text: CharSequence, queueMode: Int = TextToSpeech.QUEUE_FLUSH, params: Bundle? = null, utteranceId: String = "tts1") {
        if (::speech.isInitialized) {
            speech.speak(text, queueMode, params, utteranceId)
        } else {
            throw ExceptionInInitializerError()
        }
    }

    fun speakAdd(text: CharSequence) {
        speak(text, TextToSpeech.QUEUE_ADD)
    }

    fun speak(context: Context, @StringRes textRes: Int) {
        speak(context.getString(textRes))
    }

    fun speakAdd(context: Context, @StringRes textRes: Int) {
        speak(context.getString(textRes), TextToSpeech.QUEUE_ADD)
    }

    fun isSpeaking(): Boolean {
        if (::speech.isInitialized) {
            return speech.isSpeaking
        } else {
            throw ExceptionInInitializerError()
        }
    }

    fun getInstance(): TextToSpeech {
        if (::speech.isInitialized) {
            return speech
        } else {
            throw ExceptionInInitializerError()
        }
    }

    fun speakAccessibilityOff(context: Context, text: CharSequence) {
        var accessibilityManager = context.getSystemService(Activity.ACCESSIBILITY_SERVICE) as android.view.accessibility.AccessibilityManager
        if (!accessibilityManager.isEnabled) {
            speak(text)
        }
    }

}

fun CharSequence.speakAccessibilityOff(context: Context){
    TextToSpeechUtil.speakAccessibilityOff(context, this)
}

fun CharSequence.speak(){
    TextToSpeechUtil.speak(this)
}

fun CharSequence.speakAdd(){
    TextToSpeechUtil.speakAdd(this)
}

fun Int.speak(context: Context){
    TextToSpeechUtil.speak(context, this)
}

fun Int.speakAdd(context: Context){
    TextToSpeechUtil.speakAdd(context, this)
}