package com.alirahimi.digikalaclone.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.profile.LoginRequest
import com.alirahimi.digikalaclone.data.model.profile.LoginResponse
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.repository.ProfileRepository
import com.alirahimi.digikalaclone.ui.screens.profile.ProfileScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository) :
    ViewModel() {

    var screenState by mutableStateOf(ProfileScreenState.LOGIN_STATE)

    var inputPhoneState by mutableStateOf("")
    var inputPasswordState by mutableStateOf("")

    val loginResponseFlow = MutableStateFlow<NetworkResult<LoginResponse>>(NetworkResult.Loading())

    var loadingState by mutableStateOf(false)

    fun login() {
        viewModelScope.launch {
            loadingState = true
            val loginRequest = LoginRequest(phone = inputPhoneState, password = inputPasswordState)
            loginResponseFlow.emit(repository.login(loginRequest))
        }
    }

    fun refreshToken(phone: String, password: String) {
        viewModelScope.launch {
            val loginRequest = LoginRequest(phone = phone, password = password)
            loginResponseFlow.emit(repository.login(loginRequest))
        }
    }

}