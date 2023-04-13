package com.alirahimi.digikalaclone.ui.screens.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.navigation.Screen
import com.alirahimi.digikalaclone.ui.components.Loading3Dots
import com.alirahimi.digikalaclone.ui.theme.splashBackground
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    Splash()

    LaunchedEffect(true) {
        delay(2500)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.splashBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InfiniteAnimation()
//        Image(
//            modifier = Modifier.size(250.dp),
//            painter = painterResource(id = R.drawable.digi_logo),
//            contentDescription = null
//        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(100.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.height(30.dp),
                painter = painterResource(id = R.drawable.digi_txt_white),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Loading3Dots(isDark = false)
        }
    }
}

@Composable
fun InfiniteAnimation() {

    val infiniteTransition = rememberInfiniteTransition()

    val size by infiniteTransition.animateFloat(
        initialValue = 150f,
        targetValue = 250f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,
                delayMillis = 100
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Image(
        modifier = Modifier.size(size.dp),
        painter = painterResource(id = R.drawable.digi_logo),
        contentDescription = null
    )


}