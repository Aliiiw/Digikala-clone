package com.alirahimi.digikalaclone.navigation

sealed class Screen(val route: String) {

    object Splash : Screen(route = "splash_screen")

    object Home : Screen(route = "home_screen")

}
