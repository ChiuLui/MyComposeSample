package com.chiului.mycomposesample.ui.googlesample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiului.mycomposesample.navigation.NavConstant.GOOGLE_SAMPLE_PAGE_LIST

/**
 * Google 官网学习样例$
 * @author    Lei
 * @date      2022/05/18 10:07
 */

@Composable
fun GoogleSampleHome(onSelectPage: (page: String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(GOOGLE_SAMPLE_PAGE_LIST) {
            Text(
                text = it,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth().clickable { onSelectPage(it) }.padding(15.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GoogleSampleHomePreview() {
    GoogleSampleHome {}
}