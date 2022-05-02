package com.example.redrockmterm.ui.inspiration.inspirationdetailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.redrockmterm.R
import com.example.redrockmterm.adapter.ChrVpAdapter
import com.example.redrockmterm.adapter.IdeaVpAdapter
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.bean.colorbeans.Color
import com.example.redrockmterm.bean.colorbeans.Season
import com.example.redrockmterm.bean.ideabeans.DataIdeaDetail
import com.example.redrockmterm.databinding.ActivityInspirationDetailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class InspirationDetailActivity : BaseActivity() {

    private lateinit var binding:ActivityInspirationDetailBinding
    private lateinit var viewModel:InspirationDetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInspirationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initContent()
        liveDataSet()


    }

    private fun liveDataSet() {
        viewModel.ideaDetailLiveData.observe(this){
            setVp(it)
        }
        viewModel.getDetailData()

    }

    private fun initContent() {
        viewModel=ViewModelProvider(this).get(InspirationDetailActivityViewModel::class.java)
    }


    private fun setVp(list:List<DataIdeaDetail>){
        binding.activityInViewPager2.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        binding.activityInTabLayout.setSelectedTabIndicator(R.drawable.indicator)

        binding.activityInViewPager2.adapter= IdeaVpAdapter(this,list)

        binding.activityInTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab) {
                val index = tab.position
                //num=index
                binding.insDetailTextView.text=list[index].title
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
        TabLayoutMediator(binding.activityInTabLayout,binding.activityInViewPager2){
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
        binding.insDetailImageView.setOnClickListener{
            finish()
        }
    }


}