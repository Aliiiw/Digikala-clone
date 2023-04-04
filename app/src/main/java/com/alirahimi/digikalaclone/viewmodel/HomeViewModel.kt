package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import com.alirahimi.digikalaclone.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

}