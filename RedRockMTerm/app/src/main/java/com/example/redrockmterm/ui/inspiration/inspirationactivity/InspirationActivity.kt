package com.example.redrockmterm.ui.inspiration.inspirationactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redrockmterm.R
import com.example.redrockmterm.databinding.ActivityInspirationBinding

class InspirationActivity : AppCompatActivity() {

    private lateinit var binding:ActivityInspirationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInspirationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iView.setPhoto(R.drawable.jq)
        binding.jView.setPhoto(R.drawable.img)
        binding.kView.setPhoto(R.drawable.jq)
        binding.mView.setPhoto(R.drawable.img)
    }
}