package com.example.redrockmterm.bean.colorbeans

data class ColorId(
    val code: Int,
    val `data`: DataColor,
    val message: String
)

data class DataColor(
    val color_list: List<Color>,
    val has_more: Boolean
)

data class Color(
    val b: Int,
    val c: Int,
    val g: Int,
    val hex: String,
    val id: Int,
    val k: Int,
    val m: Int,
    val name: String,
    val r: Int,
    val y: Int
)