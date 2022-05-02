package com.example.redrockmterm.dataservice

import com.example.redrockmterm.bean.collectionbean.CollectionData
import com.example.redrockmterm.bean.collectionbean.CollectionList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CollectionService {
    @GET("/star/star_list")
    fun getCollection(@Header("Authorization") token:String, @Query("page")p:Int, @Query("limit")l:Int): Call<CollectionList>

}