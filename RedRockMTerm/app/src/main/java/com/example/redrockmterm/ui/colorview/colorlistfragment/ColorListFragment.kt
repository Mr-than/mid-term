package com.example.redrockmterm.ui.colorview.colorlistfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.redrockmterm.databinding.FragmentChrColorListBinding

class ColorListFragment: Fragment() {
    private lateinit var binding:FragmentChrColorListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentChrColorListBinding.inflate(inflater)


        return binding.root
    }
}