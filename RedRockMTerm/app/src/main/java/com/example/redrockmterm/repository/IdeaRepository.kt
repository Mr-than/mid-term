package com.example.redrockmterm.repository

import com.example.redrockmterm.bean.ideabeans.DataIdea
import com.example.redrockmterm.bean.ideabeans.DataIdeaDetail
import com.example.redrockmterm.dataservice.IdeaService
import com.example.redrockmterm.tool.RetrofitTool
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object IdeaRepository {
    suspend fun getHomePage()= suspendCoroutine<List<DataIdea>> {
        val data=RetrofitTool.getService(IdeaService::class.java).getHomePage().execute().body()
        it.resume(data!!.data)
    }


    suspend fun getIdeaDetail()= suspendCoroutine<List<DataIdeaDetail>> {
        val dataList=ArrayList<DataIdeaDetail>()
        for (i in 1 .. 7){
            val data=RetrofitTool.getService(IdeaService::class.java).getIdeaDetail(i).execute().body()
            dataList.add(data!!.data)
        }
        it.resume(dataList)
    }

}