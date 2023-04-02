package com.alirahimi.digikalaclone.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFed1b34)
val Purple500 = Color(0xFFCE3C4D)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val Colors.splashBackground: Color
    @Composable
    get() = Color(0xFFed1b34)

val Colors.selectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFF43474c) else Color(0xFFcfd4da)

val Colors.unSelectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFFa4a1a1) else Color(0xFF575a5e)
