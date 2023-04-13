package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.datastore.DataStoreRepository
import com.alirahimi.digikalaclone.util.Constants.PERSIAN_LANGUAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    companion object {
        const val USER_LANGUAGE_KEY = "USER_LANGUAGE_KEY"
        const val USER_TOKEN_KEY = "USER_TOKEN_KEY"
        const val USER_ID_KEY = "USER_ID_KEY"
        const val USER_PHONE_KEY = "USER_PHONE_KEY"
        const val USER_PASSWORD_KEY = "USER_PASSWORD_KEY"
    }


    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_LANGUAGE_KEY, value = value)
        }
    }

    fun getUserLanguage(): String = runBlocking {
        repository.getString(key = USER_LANGUAGE_KEY) ?: PERSIAN_LANGUAGE
    }

    fun saveUserToken(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_TOKEN_KEY, value = value)
        }
    }

    fun getUserToken(): String? = runBlocking {
        repository.getString(key = USER_TOKEN_KEY)
    }

    fun saveUserID(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_ID_KEY, value = value)
        }
    }

    fun getUserID(): String? = runBlocking {
        repository.getString(key = USER_ID_KEY)
    }

    fun saveUserPhoneNumber(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_PHONE_KEY, value = value)
        }
    }

    fun getUserPhoneNumber(): String? = runBlocking {
        repository.getString(key = USER_PHONE_KEY)
    }

    fun saveUserPassword(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_PASSWORD_KEY, value = value)
        }
    }

    fun getUserPassword(): String? = runBlocking {
        repository.getString(key = USER_PASSWORD_KEY)
    }

}