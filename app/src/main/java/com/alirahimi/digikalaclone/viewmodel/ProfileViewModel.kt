package com.alirahimi.digikalaclone.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.basket.BasketDetail
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.repository.BasketRepository
import com.alirahimi.digikalaclone.repository.ProfileRepository
import com.alirahimi.digikalaclone.ui.screens.basket.BasketScreenState
import com.alirahimi.digikalaclone.ui.screens.profile.ProfileScreenState
import com.alirahimi.digikalaclone.util.DigitHelper.applyDiscount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository) :
    ViewModel() {

    var screenState by mutableStateOf(ProfileScreenState.LOGIN_STATE)

    var inputPhoneState by mutableStateOf("")

}