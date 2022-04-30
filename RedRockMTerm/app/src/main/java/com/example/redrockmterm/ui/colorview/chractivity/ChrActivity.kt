package com.example.redrockmterm.ui.colorview.chractivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.redrockmterm.R
import com.example.redrockmterm.adapter.ChrVpAdapter
import com.example.redrockmterm.databinding.ActivityChrBinding

import com.example.redrockmterm.ui.colorview.colorlistfragment.ColorListFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ChrActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initContent()

    }

    private fun initContent(){

        binding.activityChrViewPager2.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

        binding.activityChrTabLayout.setSelectedTabIndicator(R.drawable.indicator)

        val list=ArrayList<Fragment>()
        val l=ArrayList<String>()
        for (a in 0..6){
            list.add(ColorListFragment())
            l.add(a.toString())
        }

        binding.activityChrViewPager2.adapter=ChrVpAdapter(this,list)

        binding.activityChrTabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab) {
                val index = tab.position
                binding.chrTextView.text=l[index]
                tab.setIcon(R.drawable.unse)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.setIcon(R.drawable.se)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        TabLayoutMediator(binding.activityChrTabLayout,binding.activityChrViewPager2){
            tab,_->
            tab.setIcon(R.drawable.se)
        }.attach()
        binding.chrImageView.setOnClickListener{
         finish()
        }

    }

}