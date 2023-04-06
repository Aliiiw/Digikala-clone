package com.alirahimi.digikalaclone.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.util.Constants.USER_LANGUAGE
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel

@Composable
fun AppConfig(dataStore: DataStoreViewModel = hiltViewModel()) {

    getDataStoreVariables(dataStore = dataStore)

}

private fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(value = USER_LANGUAGE)
}

