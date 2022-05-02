package com.example.redrockmterm.bean.colorbeans

import android.os.Parcel
import android.os.Parcelable

data class ColorDetail(
    val code: Int,
    val `data`: DataColorDetail,
    val message: String
)

data class DataColorDetail(
    val colors: Colors,
    val intro: String,
    val shades: Shades
)

data class Colors(
    val color_1: Color1,
    val color_2: Color2,
    val color_3: Color3,
    val color_4: Color4,
    val color_5: Color5,
    val color_6: Color6,
    val color_7: Color7
)

data class Shades(
    val shade_list: List<Shade>
)

data class Color1(
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

data class Color2(
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

data class Color3(
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

data class Color4(
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

data class Color5(
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

data class Color6(
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

data class Color7(
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

data class Shade(
    val id:Int,
    val shade: List<ShadeX>
)

data class ShadeX(
    val color: ColorDe
)

data class ColorDe(
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