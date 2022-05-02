package com.example.redrockmterm.ui.colorview.chrdetail

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.redrockmterm.base.BaseActivity
import com.example.redrockmterm.bean.colorbeans.DataColorDetail
import com.example.redrockmterm.bean.colorbeans.Shade
import com.example.redrockmterm.databinding.ActivityChrDetailBinding
import com.example.redrockmterm.ui.collection.colorpage.ColorPageActivity


class ChrDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityChrDetailBinding
    private var id:Int=0
    private lateinit var viewModel:ChrDetailActivityViewModel
    private lateinit var drawable: GradientDrawable
    private lateinit var l:List<Shade>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChrDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id=intent.getIntExtra("id",0)

        initContent()
        livedataSet()

    }


    private fun initContent(){
        viewModel=ViewModelProvider(this).get(ChrDetailActivityViewModel::class.java)

    }

        @SuppressLint("SetTextI18n")
        private fun livedataSet(){
            viewModel.chrDetailLiveData.observe(this){

                l=it.shades.shade_list

                binding.run{
                    chrDetailTextView.text=it.colors.color_1.name
                    chrTextView.text=it.colors.color_1.name
                    chrTextViewHexValue.text=it.colors.color_1.hex
                    chrTextViewRgbValue.text=it.colors.color_1.run {"$r$g$b"}
                    chrTextViewCmkyValue.text=it.colors.color_1.run {"$c$m$y$k"}
                    chrCardR.setBackgroundColor(Color.parseColor("#${it.colors.color_1.hex}"))

                    chrBottomTextView3Hex.text="#${it.colors.color_2.hex}"
                    chrBottomTextView3.setBackgroundColor(Color.parseColor("#${it.colors.color_2.hex}"))

                    chrBottomTextView11Value.text="#${it.colors.color_3.hex}"
                    chrBottomTextView11.setBackgroundColor(Color.parseColor("#${it.colors.color_3.hex}"))

                    chrBottomTextView4Value.text="#${it.colors.color_4.hex}"
                    chrBottomTextView4.setBackgroundColor(Color.parseColor("#${it.colors.color_4.hex}"))

                    chrBottomTextView5Value.text="#${it.colors.color_5.hex}"
                    chrBottomTextView5.setBackgroundColor(Color.parseColor("#${it.colors.color_5.hex}"))

                    chrBottomTextView12Value.text="#${it.colors.color_6.hex}"
                    chrBottomTextView12.setBackgroundColor(Color.parseColor("#${it.colors.color_6.hex}"))

                    chrBottomTextView6Value.text="#${it.colors.color_7.hex}"
                    chrBottomTextView6.setBackgroundColor(Color.parseColor("#${it.colors.color_7.hex}"))


                    for (i in 0 until it.shades.shade_list.size){
                        val arr=ArrayList<Int>(2)

                        for(j in 0 until it.shades.shade_list[i].shade.size){
                            arr.add(Color.parseColor("#${it.shades.shade_list[i].shade[j].color.hex}"))
                        }

                        drawable= GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,arr.toIntArray())
                        drawable.gradientType = GradientDrawable.LINEAR_GRADIENT

                        when(i){
                            0->{

                                binding.chrImageView1.setOnClickListener { _->
                                    val intent=Intent(this@ChrDetailActivity,ColorPageActivity::class.java)
                                    val b=Bundle()
                                    for(j in 0 until it.shades.shade_list[0].shade.size){
                                        b.putInt("$j",Color.parseColor("#${it.shades.shade_list[0].shade[j].color.hex}"))
                                    }
                                    b.putInt("size",it.shades.shade_list[0].shade.size)
                                    b.putInt("id",it.shades.shade_list[0].id)
                                    intent.putExtras(b)
                                    startActivity(intent)
                                }
                                Glide.with(this@ChrDetailActivity).load(drawable)
                                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                                    .into(binding.chrImageView1)
                            }
                            1->{
                                binding.chrImageView2.setOnClickListener { _->
                                    val intent=Intent(this@ChrDetailActivity,ColorPageActivity::class.java)

                                    val b=Bundle()
                                    for(j in 0 until it.shades.shade_list[1].shade.size){
                                        b.putInt("$j",Color.parseColor("#${it.shades.shade_list[1].shade[j].color.hex}"))
                                    }

                                    b.putInt("size",it.shades.shade_list[1].shade.size)

                                    b.putInt("id",it.shades.shade_list[1].id)
                                    intent.putExtras(b)
                                    startActivity(intent)
                                }

                                Glide.with(this@ChrDetailActivity).load(drawable)
                                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                                    .into(binding.chrImageView2)
                            }
                            2->{
                                binding.chrImageView3.setOnClickListener { _->
                                    val intent=Intent(this@ChrDetailActivity,ColorPageActivity::class.java)

                                    val b=Bundle()
                                    for(j in 0 until it.shades.shade_list[2].shade.size){
                                        b.putInt("$j",Color.parseColor("#${it.shades.shade_list[2].shade[j].color.hex}"))
                                    }

                                    b.putInt("size",it.shades.shade_list[2].shade.size)

                                    b.putInt("id",it.shades.shade_list[2].id)
                                    intent.putExtras(b)
                                    startActivity(intent)
                                }

                                Glide.with(this@ChrDetailActivity).load(drawable)
                                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                                    .into(binding.chrImageView3)
                            }
                            3->{
                                binding.chrImageView4.setOnClickListener { _->
                                    val intent=Intent(this@ChrDetailActivity,ColorPageActivity::class.java)

                                    val b=Bundle()
                                    for(j in 0 until it.shades.shade_list[3].shade.size){
                                        b.putInt("$j",Color.parseColor("#${it.shades.shade_list[3].shade[j].color.hex}"))
                                    }

                                    b.putInt("size",it.shades.shade_list[3].shade.size)

                                    b.putInt("id",it.shades.shade_list[3].id)
                                    intent.putExtras(b)
                                    startActivity(intent)
                                }

                                Glide.with(this@ChrDetailActivity).load(drawable)
                                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                                    .into(binding.chrImageView4)
                            }
                            4->{
                                binding.chrImageView5.setOnClickListener { _->
                                    val intent=Intent(this@ChrDetailActivity,ColorPageActivity::class.java)

                                    val b=Bundle()
                                    for(j in 0 until it.shades.shade_list[4].shade.size){
                                        b.putInt("$j",Color.parseColor("#${it.shades.shade_list[4].shade[j].color.hex}"))
                                    }

                                    b.putInt("size",it.shades.shade_list[4].shade.size)

                                    b.putInt("id",it.shades.shade_list[4].id)
                                    intent.putExtras(b)
                                    startActivity(intent)
                                }

                                Glide.with(this@ChrDetailActivity).load(drawable)
                                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                                    .into(binding.chrImageView5)
                            }
                            5->{
                                binding.chrImageView6.setOnClickListener { _->
                                    val intent=Intent(this@ChrDetailActivity,ColorPageActivity::class.java)

                                    val b=Bundle()
                                    for(j in 0 until it.shades.shade_list[5].shade.size){
                                        b.putInt("$j",Color.parseColor("#${it.shades.shade_list[5].shade[j].color.hex}"))
                                    }

                                    b.putInt("size",it.shades.shade_list[5].shade.size)

                                    b.putInt("id",it.shades.shade_list[5].id)
                                    intent.putExtras(b)
                                    startActivity(intent)
                                }

                                Glide.with(this@ChrDetailActivity).load(drawable)
                                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                                    .into(binding.chrImageView6)
                            }
                        }
                    }

                }
            }

            viewModel.getDetail(id)

        }


}