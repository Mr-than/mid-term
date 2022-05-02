package com.example.redrockmterm.ui.collection

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redrockmterm.R
import com.example.redrockmterm.adapter.CollectionAdapter
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.bean.collectionbean.Star
import com.example.redrockmterm.databinding.ActivityCollectionBinding
import com.example.redrockmterm.tool.GamItemTouchCallback

class CollectionActivity : BaseActivity() {

    private lateinit var binding:ActivityCollectionBinding
    private lateinit var viewModel:CollectionActivityViewModel
    private lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.activityCollectionImageView.setOnClickListener {
            finish()
        }


        sp=getSharedPreferences("token", MODE_PRIVATE)

        viewModel=ViewModelProvider(this).get(CollectionActivityViewModel::class.java)

        val list= ArrayList<Star>()
        val adapter=CollectionAdapter(this,list)
        val aaa= ItemTouchHelper(GamItemTouchCallback(dpToPx(this,150f),adapter,binding.activityCollectionRv))
        binding.activityCollectionRv.layoutManager=LinearLayoutManager(this)
        binding.activityCollectionRv.adapter=adapter
        aaa.attachToRecyclerView(binding.activityCollectionRv)

        viewModel.collectionData.observe(this){
            if(it!=null)
            adapter.update(it)
        }
        viewModel.getList(sp)

    }

    private fun dpToPx(context: Context, value:Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value,
            context.resources.displayMetrics
        ).toInt()
    }

}