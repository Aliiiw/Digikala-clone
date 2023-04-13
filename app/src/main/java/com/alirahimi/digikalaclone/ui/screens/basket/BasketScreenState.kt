package com.alirahimi.digikalaclone.ui.screens.basket

sealed class BasketScreenState<out T> {
    object Loading : BasketScreenState<Nothing>()
    data class Success<T>(val data: T) : BasketScreenState<T>()
    data class Error(val error: Exception) : BasketScreenState<Nothing>()
}