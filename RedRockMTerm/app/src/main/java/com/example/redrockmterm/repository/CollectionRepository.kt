package com.example.redrockmterm.repository

import android.content.SharedPreferences
import com.example.redrockmterm.bean.collectionbean.CollectionData
import com.example.redrockmterm.dataservice.CollectionService
import com.example.redrockmterm.tool.RetrofitTool
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object CollectionRepository {

    suspend fun getCollection(sp:SharedPreferences)= suspendCoroutine<CollectionData?> {
        val t=sp.getString("t","")!!
        val data=RetrofitTool.getService(CollectionService::class.java).getCollection("bearer $t",1,10).execute().body()
        it.resume(data?.data)

    }
}