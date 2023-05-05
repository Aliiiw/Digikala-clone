package com.alirahimi.digikalaclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alirahimi.digikalaclone.navigation.BottomNavigationBar
import com.alirahimi.digikalaclone.navigation.SetupNavGraph
import com.alirahimi.digikalaclone.ui.components.AppConfig
import com.alirahimi.digikalaclone.ui.components.ChangeStatusBarColor
import com.alirahimi.digikalaclone.ui.theme.DigikalaCloneTheme
import com.alirahimi.digikalaclone.util.Constants.ENGLISH_LANGUAGE
import com.alirahimi.digikalaclone.util.Constants.USER_LANGUAGE
import com.alirahimi.digikalaclone.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaCloneTheme {
                navController = rememberNavController()

                ChangeStatusBarColor(navController = navController)

                AppConfig()

                val context = LocalContext.current
                LocaleUtils.setLocale(context = context, language = USER_LANGUAGE)

                val direction = if (USER_LANGUAGE == ENGLISH_LANGUAGE) LayoutDirection.Ltr
                else LayoutDirection.Rtl


                CompositionLocalProvider(LocalLayoutDirection provides direction) {
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