package com.alirahimi.digikalaclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.ui.unit.LayoutDirection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alirahimi.digikalaclone.navigation.BottomNavigationBar
import com.alirahimi.digikalaclone.navigation.SetupNavGraph
import com.alirahimi.digikalaclone.ui.theme.DigikalaCloneTheme
import com.alirahimi.digikalaclone.utils.Constants.PERSIAN_LANGUAGE
import com.alirahimi.digikalaclone.utils.LocaleUtils

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaCloneTheme {
                navController = rememberNavController()

                val context = LocalContext.current
                LocaleUtils.setLocale(context = context, language = PERSIAN_LANGUAGE)

                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Scaffold(
                        topBar = {},
                        floatingActionButton = {},
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        },
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}