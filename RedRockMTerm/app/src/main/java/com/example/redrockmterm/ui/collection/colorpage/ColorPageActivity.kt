package com.example.redrockmterm.ui.collection.colorpage

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.redrockmterm.R
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.databinding.ActivityColorPageBinding
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import kotlin.concurrent.thread

class ColorPageActivity : BaseActivity() {
    private lateinit var binding:ActivityColorPageBinding
    private lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityColorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)







        sp=getSharedPreferences("token", MODE_PRIVATE)
        val b=intent.extras

        val size=b!!.getInt("size")
        val id=b.getInt("id")
        val arr=ArrayList<Int>(2)

        for(j in 0 until size){
            arr.add((b.getInt("$j")))
        }
        val drawable= GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,arr.toIntArray())
        drawable.gradientType = GradientDrawable.LINEAR_GRADIENT

        Glide.with(this).load(drawable).into(binding.color)

        binding.collection.setOnClickListener {
            val t=sp.getString("t","")

            thread {
                val client= OkHttpClient()
                val body= FormBody.Builder().add("shade_id",id.toString()).build()
                val request= Request.Builder().url("http://redrock.udday.cn:8888/star/star").addHeader("Authorization","bearer $t").post(body).build()
                val data=client.newCall(request).execute()
                val a=data.body()!!.string()

                val s=JSONObject(a)
                val json=s.getString("message")

                runOnUiThread{
                    Toast.makeText(this,json,Toast.LENGTH_SHORT).show()
                    if(json=="收藏成功"){
                        binding.collection.setImageResource(R.drawable.like)
                    }

                }
            }
        }
    }


}