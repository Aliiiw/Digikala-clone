package com.alirahimi.digikalaclone.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.util.Constants.USER_LANGUAGE
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun AppConfig(dataStore: DataStoreViewModel = hiltViewModel()) {

    getDataStoreVariables(dataStore = dataStore)

}

private fun getDataStoreVariables(dataStore: DataStoreViewModel) = runBlocking {
    USER_LANGUAGE = dataStore.getUserLanguage()
}

