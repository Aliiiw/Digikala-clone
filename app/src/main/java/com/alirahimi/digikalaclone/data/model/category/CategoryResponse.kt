package com.alirahimi.digikalaclone.data.model.category


data class CategoryResponse(
    val tool: List<SubCategory>,
    val digital: List<SubCategory>,
    val mobile: List<SubCategory>,
    val supermarket: List<SubCategory>,
    val fashion: List<SubCategory>,
    val native: List<SubCategory>,
    val toy: List<SubCategory>,
    val beauty: List<SubCategory>,
    val home: List<SubCategory>,
    val book: List<SubCategory>,
    val sport: List<SubCategory>,
)


data class SubCategory(
    val _id: String,
    val count: Int,
    val image: String,
    val name: String
)
