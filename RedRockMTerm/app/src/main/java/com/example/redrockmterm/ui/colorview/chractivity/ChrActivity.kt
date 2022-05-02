package com.example.redrockmterm.ui.colorview.chractivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.redrockmterm.R
import com.example.redrockmterm.adapter.ChrVpAdapter
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.bean.colorbeans.Color
import com.example.redrockmterm.bean.colorbeans.Season
import com.example.redrockmterm.databinding.ActivityChrBinding

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ChrActivity : BaseActivity() {
    private lateinit var binding: ActivityChrBinding
    private lateinit var viewModel:ChrActivityViewModel
    //private var num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initContent()
        liveDataSet()

    }

    private fun initContent(){
        viewModel=ViewModelProvider(this).get(ChrActivityViewModel::class.java)
    }
    private fun liveDataSet(){


        viewModel.colorIds()

        viewModel.colorLiveData.observe(this){

            it.a
            it.b

            setVp(it.a,it.b)
        }

    }


    private fun setVp(l:List<Season>,list:List<List<Color>>){
        binding.activityChrViewPager2.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        binding.activityChrTabLayout.setSelectedTabIndicator(R.drawable.indicator)

        binding.activityChrViewPager2.adapter=ChrVpAdapter(this,list)
        binding.activityChrTabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab) {
                val index = tab.position
                //num=index
                binding.chrTextView.text=l[index].theme
                tab.setIcon(R.drawable.unse)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                when(tab.position){
                    0->tab.setIcon(R.drawable.se_1)
                    1->tab.setIcon(R.drawable.se_1)
                    2->tab.setIcon(R.drawable.se_2)
                    3->tab.setIcon(R.drawable.se)
                    4->tab.setIcon(R.drawable.se_2)
                    5->tab.setIcon(R.drawable.se_1)
                    6->tab.setIcon(R.drawable.se_1)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        TabLayoutMediator(binding.activityChrTabLayout,binding.activityChrViewPager2){
                tab,p->
            when(p){
                0->tab.setIcon(R.drawable.se_1)
                1->tab.setIcon(R.drawable.se_2)
                2->tab.setIcon(R.drawable.se)
                3->tab.setIcon(R.drawable.se)
                4->tab.setIcon(R.drawable.se)
                5->tab.setIcon(R.drawable.se_2)
                6->tab.setIcon(R.drawable.se_1)
            }
        }.attach()
        binding.chrImageView.setOnClickListener{
            finish()
        }
    }



}