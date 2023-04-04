package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.home.Slider
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val sliderFlow = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    suspend fun getSlider() {

        viewModelScope.launch {
            sliderFlow.emit(
                repository.getSlider()
            )
        }
    }

}