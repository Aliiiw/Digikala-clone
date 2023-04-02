package com.alirahimi.digikalaclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alirahimi.digikalaclone.navigation.BottomNavigationBar
import com.alirahimi.digikalaclone.navigation.SetupNavGraph
import com.alirahimi.digikalaclone.ui.theme.DigikalaCloneTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaCloneTheme {
                navController = rememberNavController()

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