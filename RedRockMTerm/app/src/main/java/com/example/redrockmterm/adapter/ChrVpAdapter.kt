package com.example.redrockmterm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.redrockmterm.R
import com.example.redrockmterm.bean.colorbeans.Color

class ChrVpAdapter( private val context: Context,private val list:List<List<Color>>):
    RecyclerView.Adapter<ChrVpAdapter.ChrVpViewHolder>() {

   inner class ChrVpViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
       val r:RecyclerView = itemView.findViewById(R.id.vp_rv)
   }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChrVpViewHolder {
        return ChrVpViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vp_rv_item,parent,false))
    }

    override fun onBindViewHolder(holder: ChrVpViewHolder, position: Int){
        holder.r.layoutManager=LinearLayoutManager(context)
        holder.r.adapter=VpRvAdapter(list[position],context)
    }


    override fun getItemCount()=list.size
}