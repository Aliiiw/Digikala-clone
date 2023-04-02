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
    }


    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(key = USER_LANGUAGE_KEY, value = value)
        }
    }

    suspend fun getUserLanguage(): String =
        repository.getString(key = USER_LANGUAGE_KEY) ?: PERSIAN_LANGUAGE


}