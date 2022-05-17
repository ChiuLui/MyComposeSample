package com.chiului.mycomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chiului.mycomposesample.navigation.NavGraph
import com.chiului.mycomposesample.ui.theme.MyComposeSampleTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeSampleTheme {
                NavGraph()
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity(){
    MyComposeSampleTheme {
        NavGraph()
    }
}