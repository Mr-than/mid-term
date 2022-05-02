package com.example.redrockmterm.bean.colorbeans

data class ColorPageId(
    val code: Int,
    val `data`: Data,
    val message: String
)

data class Data(
    val count: Int,
    val list: List<Season>
)

data class Season(
    val id: Int,
    val theme: String
)