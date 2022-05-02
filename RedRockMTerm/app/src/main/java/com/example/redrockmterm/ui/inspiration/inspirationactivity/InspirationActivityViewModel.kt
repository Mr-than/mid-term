package com.example.redrockmterm.ui.inspiration.inspirationactivity

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import com.example.redrockmterm.base.APP
import com.example.redrockmterm.bean.ideabeans.DataIdea
import com.example.redrockmterm.repository.IdeaRepository
import com.example.redrockmterm.tool.toHttp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class InspirationActivityViewModel:ViewModel() {

    private val job= Job()
    private val scope= CoroutineScope(job)

    private val homePageDataMuData=MutableLiveData<List<Bitmap>>()
    val homePageLiveData:LiveData<List<Bitmap>> =homePageDataMuData

    fun getHomePage(){
        scope.launch(Dispatchers.IO) {
            val a=IdeaRepository.getHomePage()
            val list=ArrayList<Bitmap>()

            for (i in a.indices) {
                val futureTarget: FutureTarget<Bitmap> = Glide.with(APP.getApp())
                    .asBitmap()
                    .load(a[i].image.toHttp())
                    .submit(500, 500)

                val bitmap = futureTarget.get()
                list.add(bitmap)
                Glide.with(APP.getApp()).clear(futureTarget)
            }

            homePageDataMuData.postValue(list)
        }
    }


}