package com.alirahimi.digikalaclone.data.model.home

data class AmazingItem(
    val _id: String,
    val name: String,
    val seller: String,
    val price: Long,
    val discountPercent: Int,
    val image: String
)