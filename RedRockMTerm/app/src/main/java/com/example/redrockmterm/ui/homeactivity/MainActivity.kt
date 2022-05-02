package com.example.redrockmterm.ui.homeactivity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.databinding.ActivityMainBinding
import com.example.redrockmterm.databinding.HomeActivityMainBinding
import com.example.redrockmterm.databinding.TopActivityMainBinding
import com.example.redrockmterm.ui.collection.CollectionActivity
import com.example.redrockmterm.ui.colorview.chractivity.ChrActivity
import com.example.redrockmterm.ui.homefragment.LoginFragment
import com.example.redrockmterm.ui.homefragment.SFragment
import com.example.redrockmterm.ui.inspiration.inspirationactivity.InspirationActivity

class MainActivity : BaseActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var topBinding:TopActivityMainBinding
    private lateinit var homeBinding:HomeActivityMainBinding
    private lateinit var sp:SharedPreferences
    private var token:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initContent()

        if (token=="") {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(homeBinding.homeActivityFragment.id, LoginFragment())
            transaction.commit()
        }else{
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(homeBinding.homeActivityFragment.id, SFragment())
            transaction.commit()
        }
    }

    private fun initContent(){
        sp=getSharedPreferences("token", MODE_PRIVATE)
        token=sp.getString("t","")

        topBinding=mainBinding.topLayout
        homeBinding=mainBinding.homeLayout
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

        topBinding.topActivityMainCollection.setOnClickListener {
            startActivity(Intent(this,CollectionActivity::class.java))
        }

    }

}