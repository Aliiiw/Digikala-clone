package com.alirahimi.digikalaclone.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.MainActivity
import com.alirahimi.digikalaclone.util.Constants.ENGLISH_LANGUAGE
import com.alirahimi.digikalaclone.util.Constants.PERSIAN_LANGUAGE
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    Text(text = "ProfileScreen")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val activity = LocalContext.current as Activity



        Text(text = "Change the Language")

        Button(onClick = {

            dataStore.saveUserLanguage(value = PERSIAN_LANGUAGE)

            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "Farsi")
        }

        Button(onClick = {

            dataStore.saveUserLanguage(value = ENGLISH_LANGUAGE)

            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }

        }) {
            Text(text = "English")
        }
    }
}