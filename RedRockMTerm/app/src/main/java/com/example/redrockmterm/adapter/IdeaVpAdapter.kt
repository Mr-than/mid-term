package com.example.redrockmterm.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.redrockmterm.R
import com.example.redrockmterm.bean.ideabeans.DataIdeaDetail
import com.example.redrockmterm.tool.toHttp

class IdeaVpAdapter(private val context: Context,private val list:List<DataIdeaDetail>): RecyclerView.Adapter<IdeaVpAdapter.IdeaVpViewHolder>() {


    inner class IdeaVpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val bigPhoto:ImageView=itemView.findViewById(R.id.ins_big_image)
        val roundPhoto1:ImageView=itemView.findViewById(R.id.ins_side_image_1)
        val roundPhoto2:ImageView=itemView.findViewById(R.id.ins_side_image_2)
        val roundPhoto3:ImageView=itemView.findViewById(R.id.ins_side_image_3)

        val bottomText1:TextView=itemView.findViewById(R.id.ins_bottom_text_1)
        val bottomText2:TextView=itemView.findViewById(R.id.ins_bottom_text_2)
        val bottomText3:TextView=itemView.findViewById(R.id.ins_bottom_text_3)
        val bottomText4:TextView=itemView.findViewById(R.id.ins_bottom_text_4)
        val bottomText5:TextView=itemView.findViewById(R.id.ins_bottom_text_5)
        val bottomText6:TextView=itemView.findViewById(R.id.ins_bottom_text_6)

        val bottomTextA:TextView=itemView.findViewById(R.id.ins_bottom_text_1_hex)
        val bottomTextB:TextView=itemView.findViewById(R.id.ins_bottom_text_2_hex)
        val bottomTextC:TextView=itemView.findViewById(R.id.ins_bottom_text_3_hex)
        val bottomTextD:TextView=itemView.findViewById(R.id.ins_bottom_text_4_hex)
        val bottomTextE:TextView=itemView.findViewById(R.id.ins_bottom_text_5_hex)
        val bottomTextF:TextView=itemView.findViewById(R.id.ins_bottom_text_6_hex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=IdeaVpViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.idea_vp_detail,parent,false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: IdeaVpViewHolder, position: Int) {
        Glide.with(context).load(list[position].image.toHttp()).into(holder.bigPhoto)

        holder.bottomText1.setBackgroundColor(Color.parseColor("#${list[position].colors.color_1.hex}"))
        holder.bottomTextA.text="#${list[position].colors.color_1.hex}"

        holder.bottomText2.setBackgroundColor(Color.parseColor("#${list[position].colors.color_2.hex}"))
        holder.bottomTextB.text="#${list[position].colors.color_2.hex}"

        holder.bottomText3.setBackgroundColor(Color.parseColor("#${list[position].colors.color_3.hex}"))
        holder.bottomTextC.text="#${list[position].colors.color_3.hex}"

        holder.bottomText4.setBackgroundColor(Color.parseColor("#${list[position].colors.color_4.hex}"))
        holder.bottomTextD.text="#${list[position].colors.color_4.hex}"

        holder.bottomText5.setBackgroundColor(Color.parseColor("#${list[position].colors.color_5.hex}"))
        holder.bottomTextE.text="#${list[position].colors.color_5.hex}"

        holder.bottomText6.setBackgroundColor(Color.parseColor("#${list[position].colors.color_6.hex}"))
        holder.bottomTextF.text="#${list[position].colors.color_6.hex}"


        for (i in 0 until 4){
            val arr=ArrayList<Int>(2)

            for(j in 0 until list[position].shades.shade_list[i].shade.size){
                arr.add(Color.parseColor("#${list[position].shades.shade_list[i].shade[j].color.hex}"))
            }
            val drawable= GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,arr.toIntArray())
            drawable.gradientType = GradientDrawable.LINEAR_GRADIENT

            when(i){
                0->{
                    Glide.with(context).load(drawable)
                        .apply(RequestOptions.bitmapTransform(CircleCrop()))
                        .into(holder.roundPhoto1)
                }
                1->{
                    Glide.with(context).load(drawable)
                        .apply(RequestOptions.bitmapTransform(CircleCrop()))
                        .into(holder.roundPhoto2)
                }
                2->{
                    Glide.with(context).load(drawable)
                        .apply(RequestOptions.bitmapTransform(CircleCrop()))
                        .into(holder.roundPhoto3)
                }
            }
        }


    }

    override fun getItemCount()=list.size

}