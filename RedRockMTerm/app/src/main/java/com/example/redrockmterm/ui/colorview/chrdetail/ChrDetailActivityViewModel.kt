package com.example.redrockmterm.ui.colorview.chrdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmterm.bean.colorbeans.Colors
import com.example.redrockmterm.bean.colorbeans.DataColorDetail
import com.example.redrockmterm.repository.ChrActivityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ChrDetailActivityViewModel:ViewModel(){

    private val job= Job()
    private val scope= CoroutineScope(job)

    private val chrDetailMuData=MutableLiveData<DataColorDetail>()
    val chrDetailLiveData:LiveData<DataColorDetail> =chrDetailMuData


    fun getDetail(n:Int){

        scope.launch(Dispatchers.IO) {
            val a=ChrActivityRepository.getDetail(n).data
            chrDetailMuData.postValue(a)
        }

    }

}