package com.alirahimi.digikalaclone.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val digikalaRed = Color(0xFFed1b34)
val Purple500 = Color(0xFFCE3C4D)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val Colors.splashBackground: Color
    @Composable
    get() = Color(0xFFed1b34)

val Colors.selectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFF43474C) else Color(0xFFCFD4DA)

val Colors.unSelectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFFA4A1A1) else Color(0xFF575A5E)

val Colors.searchBarBackground: Color
    @Composable
    get() = if (isLight) Color(0XFFF1F0EE) else Color(0XFF303235)

val Colors.darkText: Color
    @Composable
    get() = if (isLight) Color(0XFF414244) else Color(0XFFD8D8D8)

val Colors.amber: Color
    @Composable
    get() = Color(0XFFFFBF00)

val Colors.grayCategory: Color
    @Composable
    get() = Color(0XFFF1F0EE)

val Colors.digikalaLightRed: Color
    @Composable
    get() = Color(0XFFEF4056)

val Colors.semiDarkText: Color
    @Composable
    get() = if (isLight) Color(0XFF5C5E61) else Color(0XFFD8D8D8)

val Colors.digikalaDarkRed: Color
    @Composable
    get() = Color(0XFFE6123D)


val Colors.darkCyan: Color
    @Composable
    get() = Color(0XFF0FABC6)

val Colors.digikalaLightGreen: Color
    @Composable
    get() = Color(0XFF86BF3C)

