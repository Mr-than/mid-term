package com.example.redrockmterm.dataservice

import com.example.redrockmterm.bean.ideabeans.IdeaDetail
import com.example.redrockmterm.bean.ideabeans.IdeaHome
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IdeaService {
    @GET("/idea/idea")
    fun getHomePage():Call<IdeaHome>

    @GET("/idea/idea_detail")
    fun getIdeaDetail(@Query("idea_detail_id")num:Int):Call<IdeaDetail>
}