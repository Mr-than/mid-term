package com.example.redrockmterm.ui.colorview.chractivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmterm.bean.colorbeans.Color
import com.example.redrockmterm.bean.colorbeans.ColorId
import com.example.redrockmterm.bean.colorbeans.Season
import com.example.redrockmterm.bean.colorbeans.Te
import com.example.redrockmterm.repository.ChrActivityRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

class ChrActivityViewModel:ViewModel() {

    private val job= Job()
    private val scope= CoroutineScope(job)


    private val colorMuData=MutableLiveData<Te>()
    val colorLiveData:LiveData<Te> =colorMuData

    fun colorIds(){

        scope.launch(Dispatchers.IO) {

            val a: List<Season> =ChrActivityRepository.getColorPageId()

            val d=ChrActivityRepository.getColorId()

            //delay(500)

            colorMuData.postValue(Te(a,d))
        }
    }



}