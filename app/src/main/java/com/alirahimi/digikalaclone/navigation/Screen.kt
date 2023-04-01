package com.alirahimi.digikalaclone.navigation

sealed class Screen(val route: String) {

    object Splash : Screen(route = "splash_screen")

    object Home : Screen(route = "home_screen")

    object Category : Screen(route = "category_screen")

    object Basket : Screen(route = "basket_screen")

    object Profile : Screen(route = "profile_screen")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

}
