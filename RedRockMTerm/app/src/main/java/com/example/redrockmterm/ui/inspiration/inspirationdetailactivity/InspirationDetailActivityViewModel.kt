package com.example.redrockmterm.ui.inspiration.inspirationdetailactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redrockmterm.bean.ideabeans.DataIdeaDetail
import com.example.redrockmterm.repository.IdeaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class InspirationDetailActivityViewModel:ViewModel() {

    private val job= Job()
    private val scope= CoroutineScope(job)


    private val ideaDetailMuData=MutableLiveData<List<DataIdeaDetail>>()
    val ideaDetailLiveData:LiveData<List<DataIdeaDetail>> =ideaDetailMuData

    fun getDetailData(){
        scope.launch(Dispatchers.IO) {
            val list=IdeaRepository.getIdeaDetail()
            ideaDetailMuData.postValue(list)
        }

    }

}