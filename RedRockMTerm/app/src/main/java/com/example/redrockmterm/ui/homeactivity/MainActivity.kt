package com.example.redrockmterm.ui.homeactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redrockmterm.databinding.ActivityMainBinding
import com.example.redrockmterm.databinding.TopActivityMainBinding
import com.example.redrockmterm.ui.colorview.chractivity.ChrActivity
import com.example.redrockmterm.ui.inspiration.inspirationactivity.InspirationActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var topBinding:TopActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initContent()


    }

    private fun initContent(){
        topBinding=mainBinding.topLayout
        topBinding.topActivityMainBackHome.setOnClickListener{
            mainBinding.mainRootView.backScroll()
        }
        topBinding.topActivityMainHome.setOnClickListener{
            mainBinding.mainRootView.backScroll()
        }


        topBinding.topActivityMainChromatographic.setOnClickListener{
            startActivity(Intent(this,ChrActivity::class.java))
        }

        topBinding.topActivityMainInspiration.setOnClickListener {
            startActivity(Intent(this,InspirationActivity::class.java))
        }
    }

}