package com.alirahimi.digikalaclone.data.model.basket

data class BasketDetail(
    val totalCount: Int,
    val totalPrice: Long,
    val totalDiscount: Long,
    val payablePrice: Long
)