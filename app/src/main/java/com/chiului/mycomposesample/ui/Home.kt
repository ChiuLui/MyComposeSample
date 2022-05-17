package com.chiului.mycomposesample.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chiului.mycomposesample.R

/**
 * 主页$
 * @author    Lei
 * @date      2022/05/17 15:25
 */
@Composable
fun Home(toSample: () -> Unit, toWechat: () -> Unit, toVip: () -> Unit, toOther: () -> Unit) {

    Column(modifier = Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Button(modifier = Modifier.buttonMain(), onClick = toSample) {
            Text(text = "Open Google Official Sample")
        }
        Box {
            Button(modifier = Modifier.buttonMain(), onClick = toWechat) {
                Text(text = "Open Wechat App")
            }
            Image(
                painter = painterResource(id = R.drawable.avatar_rengwuxian),
                contentDescription = "",
                Modifier
                    .size(20.dp)
                    .align(Alignment.TopEnd)
            )
        }
        Button(modifier = Modifier.buttonMain(), onClick = toVip) {
            Text(text = "Open VIP App")
        }
        Button(modifier = Modifier.buttonMain(), onClick = toOther) {
            Text(text = "Open Other App")
        }
    }
}

@Composable
fun Modifier.buttonMain() = this
    .wrapContentHeight()
    .wrapContentWidth()
    .padding(10.dp)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Home({}, {}, {}, {})
}