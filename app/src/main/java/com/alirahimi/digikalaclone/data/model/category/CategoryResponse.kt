package com.alirahimi.digikalaclone.data.model.category

data class CategoryResponse(
    val tool: List<Tool>,
    val beauty: List<Beauty>,
    val book: List<Book>,
    val digital: List<Digital>,
    val fashion: List<Fashion>,
    val home: List<Home>,
    val mobile: List<Mobile>,
    val native: List<Native>,
    val sport: List<Sport>,
    val supermarket: List<Supermarket>,
    val toy: List<Toy>
)