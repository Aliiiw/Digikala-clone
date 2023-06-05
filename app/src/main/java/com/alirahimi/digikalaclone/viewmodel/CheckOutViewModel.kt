package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import com.alirahimi.digikalaclone.repository.CheckOutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckOutViewModel @Inject constructor(private val repository: CheckOutRepository) :
    ViewModel() {


}