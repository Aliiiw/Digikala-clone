package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.data.model.home.ProposalBanner
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
    val amazingItemsFlow =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val amazingSuperMarketItemsFlow =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val proposalBannerItemsFlow =
        MutableStateFlow<NetworkResult<List<ProposalBanner>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            //fire and forget
            launch {
                sliderFlow.emit(
                    repository.getSlider()
                )
            }

            launch {
                amazingItemsFlow.emit(
                    repository.getAmazingItems()
                )
            }

            launch {
                amazingSuperMarketItemsFlow.emit(
                    repository.getAmazingSuperMarketItems()
                )
            }

            launch {
                proposalBannerItemsFlow.emit(
                    repository.getProposalBanners()
                )
            }
        }
    }
}