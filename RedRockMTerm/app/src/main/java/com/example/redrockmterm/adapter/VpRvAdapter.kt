package com.example.redrockmterm.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color.parseColor
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.redrockmterm.R
import com.example.redrockmterm.bean.colorbeans.Color
import com.example.redrockmterm.ui.colorview.chrdetail.ChrDetailActivity

class VpRvAdapter(val list:List<Color>,val context: Context):RecyclerView.Adapter<VpRvAdapter.VpRvViewHolder>() {

    inner class VpRvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val hex:TextView=itemView.findViewById(R.id.chr_rv_item_textView_hex_value)
        val rgb:TextView=itemView.findViewById(R.id.chr_rv_item_textView_rgb_value)
        val cmyk:TextView=itemView.findViewById(R.id.chr_rv_item_textView_cmky_value)
        val color:TextView=itemView.findViewById(R.id.chr_rv_item_textView_color)
        val constraintLayout: ConstraintLayout=itemView.findViewById(R.id.chr_color_list_rv_r)

        init {
            itemView.setOnClickListener {
                val position=adapterPosition
                val intent=Intent(context,ChrDetailActivity::class.java)
                intent.putExtra("id",list[position].id)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VpRvViewHolder {
        return VpRvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chr_color_list_rv_item,parent,false))
    }

    override fun onBindViewHolder(holder: VpRvViewHolder, position: Int) {
        holder.hex.text=list[position].hex
        holder.rgb.text=list[position].run { "$r$g$b" }
        holder.cmyk.text=list[position].run { "$c$m$y$k" }
        holder.color.text=list[position].name
        holder.constraintLayout.setBackgroundColor(parseColor("#${list[position].hex}"))
    }

    override fun getItemCount()=list.size

}