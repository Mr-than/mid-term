package com.example.redrockmterm.ui.collection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redrockmterm.R
import com.example.redrockmterm.databinding.ActivityCollectionBinding

class CollectionActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCollectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}