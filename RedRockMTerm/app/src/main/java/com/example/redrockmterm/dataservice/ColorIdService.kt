package com.example.redrockmterm.dataservice


import com.example.redrockmterm.bean.colorbeans.ColorDetail
import com.example.redrockmterm.bean.colorbeans.ColorId
import com.example.redrockmterm.bean.colorbeans.ColorPageId
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ColorIdService {
    @GET("/color/page")
    fun getColorPageId(): Call<ColorPageId>

    @GET("/color/color_list")
    fun getColorId(@Query("theme_id") page:Int,@Query("limit")n:Int):Call<ColorId>

    @GET("/color/color_detail")
    fun getDetail(@Query("color_detail_id") id:Int):Call<ColorDetail>

}