package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import com.alirahimi.digikalaclone.repository.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(private val repository: AddressRepository) :
    ViewModel() {


}