package com.example.redrockmterm.ui.colorview.chrdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redrockmterm.databinding.ActivityChrDetailBinding


class ChrDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityChrDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChrDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}