package com.chiului.mycomposesample.ui.wechat.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chiului.mycomposesample.R
import com.chiului.mycomposesample.ui.wechat.ui.theme.WeComposeTheme


/**
 * $
 * @author    Lei
 * @date      2022/05/18 01:24
 */
@Composable
fun WeBottomBar(select: Int, onSelectedChanged: (int: Int) -> Unit) {
    Row (Modifier.background(WeComposeTheme.colors.bottomBar)) {
        TabItem(
            if (select == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "聊天",
            if (select == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedChanged(0) }
        )
        TabItem(
            if (select == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "通讯录",
            if (select == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedChanged(1) }
        )
        TabItem(
            if (select == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            "发现",
            if (select == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedChanged(2) }
        )
        TabItem(
            if (select == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "我",
            if (select == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedChanged(3) }
        )
    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, tine: Color, modifier: Modifier) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = title,
            Modifier.size(24.dp),
            tint = tine
        )
        Text(text = title, fontSize = 11.sp, color = tine)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        var selectTab by remember{ mutableStateOf(0) }
        WeBottomBar(select = selectTab){ selectTab = it }
    }
}