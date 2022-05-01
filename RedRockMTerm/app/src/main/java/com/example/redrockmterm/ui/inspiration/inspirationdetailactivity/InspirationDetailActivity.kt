package com.example.redrockmterm.ui.inspiration.inspirationdetailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redrockmterm.R
import com.example.redrockmterm.databinding.ActivityInspirationDetailBinding

class InspirationDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityInspirationDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInspirationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}