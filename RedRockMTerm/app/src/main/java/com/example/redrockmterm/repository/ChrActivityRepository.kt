package com.example.redrockmterm.repository

import com.example.redrockmterm.bean.colorbeans.*
import com.example.redrockmterm.dataservice.ColorIdService
import com.example.redrockmterm.tool.RetrofitTool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object ChrActivityRepository {

    suspend fun getColorPageId()= suspendCoroutine<List<Season>>{
      val data=RetrofitTool.getService(ColorIdService::class.java).getColorPageId().execute().body()
        it.resume(data!!.data.list)
    }

    suspend fun getColorId()= suspendCoroutine<ArrayList<List<Color>>>{
            val a:ArrayList<List<Color>> =ArrayList()
            for (i in 1 .. 7) {
                val data=RetrofitTool.getService(ColorIdService::class.java).getColorId(i, 30).execute()
                a.add(data.body()!!.data.color_list)
            }
            it.resume(a)
        }

    suspend fun getDetail(n:Int)= suspendCoroutine<ColorDetail> {
        val data=RetrofitTool.getService(ColorIdService::class.java).getDetail(n).execute()
        it.resume(data.body()!!)
    }

}