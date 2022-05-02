package com.example.redrockmterm.ui.inspiration.inspirationactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.redrockmterm.R
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.databinding.ActivityInspirationBinding
import com.example.redrockmterm.ui.inspiration.inspirationdetailactivity.InspirationDetailActivity

class InspirationActivity : BaseActivity() {

    private lateinit var binding:ActivityInspirationBinding
    private lateinit var viewModel:InspirationActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInspirationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initContent()
        liveDataSet()

    }

    private fun liveDataSet() {
        viewModel.homePageLiveData.observe(this){
            binding.iView.setPhoto(it[0])
            binding.jView.setPhoto(it[1])
            binding.kView.setPhoto(it[2])
            binding.mView.setPhoto(it[3])
        }
        viewModel.getHomePage()
    }

    private fun initContent(){
        viewModel=ViewModelProvider(this).get(InspirationActivityViewModel::class.java)

        binding.inspirationImageView.setOnClickListener {
            finish()
        }

        binding.iView.setOnClickListener {
            startActivity(Intent(this,InspirationDetailActivity::class.java))
        }
        binding.jView.setOnClickListener {
            startActivity(Intent(this,InspirationDetailActivity::class.java))
        }
        binding.kView.setOnClickListener {
            startActivity(Intent(this,InspirationDetailActivity::class.java))
        }
        binding.mView.setOnClickListener {
            startActivity(Intent(this,InspirationDetailActivity::class.java))
        }


    }




}