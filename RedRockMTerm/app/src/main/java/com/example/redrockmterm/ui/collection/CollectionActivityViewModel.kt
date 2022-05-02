package com.example.redrockmterm.ui.collection

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmterm.bean.collectionbean.Star
import com.example.redrockmterm.repository.CollectionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CollectionActivityViewModel:ViewModel() {
    private val job= Job()
    private val scope= CoroutineScope(job)

    private val collectionMuData=MutableLiveData<List<Star>>()
    val collectionData:LiveData<List<Star>> =collectionMuData


    fun getList(sp:SharedPreferences){
        scope.launch(Dispatchers.IO){
            val list=CollectionRepository.getCollection(sp)
            collectionMuData.postValue(list?.star_list)
        }
    }
}