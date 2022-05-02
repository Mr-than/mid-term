package com.example.redrockmterm.bean.collectionbean

data class CollectionList(
    val code: Int,
    val `data`: CollectionData,
    val message: String
)

data class CollectionData(
    val has_more: Boolean,
    val star_list: List<Star>
)

data class Star(
    val colorShade: List<CollectionColorShade>,
    val id: Int,
    val name: String
)

data class CollectionColorShade(
    val id:Int,
    val color: CollectionColor
)

data class CollectionColor(
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