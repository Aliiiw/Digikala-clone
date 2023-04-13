package com.alirahimi.digikalaclone.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.util.Constants.USER_ID
import com.alirahimi.digikalaclone.util.Constants.USER_LANGUAGE
import com.alirahimi.digikalaclone.util.Constants.USER_PASSWORD
import com.alirahimi.digikalaclone.util.Constants.USER_PHONE
import com.alirahimi.digikalaclone.util.Constants.USER_TOKEN
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel
import com.alirahimi.digikalaclone.viewmodel.ProfileViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun AppConfig(
    dataStore: DataStoreViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    getDataStoreVariables(dataStore = dataStore)

    profileViewModel.refreshToken(USER_PHONE, USER_PASSWORD)

    val loginResponse by profileViewModel.loginResponseFlow.collectAsState()
    LaunchedEffect(Dispatchers.Main) {
        when (loginResponse) {
            is NetworkResult.Success -> {
                loginResponse.data?.let { user ->
                    if (user.token.isNotEmpty()) {
                        dataStore.saveUserToken(user.token)
                        dataStore.saveUserID(user.id)
                        dataStore.saveUserPhoneNumber(user.phone)
                        dataStore.saveUserPassword(USER_PASSWORD)

                        getDataStoreVariables(dataStore)
                    }
                }
            }
            else -> {}
        }
    }

}

private fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(value = USER_LANGUAGE)

    USER_PHONE = dataStore.getUserPhoneNumber().toString()
    USER_PASSWORD = dataStore.getUserPassword().toString()
    USER_TOKEN = dataStore.getUserToken().toString()
    USER_ID = dataStore.getUserID().toString()

}

