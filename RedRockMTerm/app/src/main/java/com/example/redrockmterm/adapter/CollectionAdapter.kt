package com.example.redrockmterm.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.redrockmterm.R
import com.example.redrockmterm.base.APP
import com.example.redrockmterm.bean.collectionbean.Star
import com.example.redrockmterm.tool.GamItemTouchCallback
import com.example.redrockmterm.ui.collection.CollectionActivity
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class CollectionAdapter(val context: Context, private val list:ArrayList<Star>):RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>(),GamItemTouchCallback.Move{


    inner class CollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img1:ImageView=itemView.findViewById(R.id.collection_image_1)
        val img2:ImageView=itemView.findViewById(R.id.collection_image_2)
        val img3:ImageView=itemView.findViewById(R.id.collection_image_3)
        val img4:ImageView=itemView.findViewById(R.id.collection_image_4)
        val text:TextView=itemView.findViewById(R.id.collection_text)
        private val t:TextView=itemView.findViewById(R.id.delete)

        init {
            t.setOnClickListener {
                val position=adapterPosition
                thread {
                    val id=list[position].id.toString()

                    val sp=context.getSharedPreferences("token", AppCompatActivity.MODE_PRIVATE)

                    val client= OkHttpClient()
                    val body= FormBody.Builder().add("star_id",id).build()
                    val request= Request.Builder().url("http://redrock.udday.cn:8888/star/delete_star").addHeader("Authorization","bearer ${sp.getString("t","")}").post(body).build()
                    val data=client.newCall(request).execute()
                    val a=data.body()!!.string()

                    val s= JSONObject(a)
                    val json=s.getString("message")

                    (context as CollectionActivity).runOnUiThread {
                        Toast.makeText(context,json,Toast.LENGTH_SHORT).show()
                        val aaa=ArrayList<Star>()
                        aaa.addAll(list)
                        aaa.removeAt(position)
                        update(aaa)
                    }
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
       return CollectionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_collection_rv_tiem,parent,false))
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val arr=ArrayList<Int>(2)

        holder.img1.setBackgroundColor(Color.parseColor("#${list[position].colorShade[0].color.hex}"))
        holder.img2.setBackgroundColor(Color.parseColor("#${list[position].colorShade[1].color.hex}"))

        arr.add(Color.parseColor("#${list[position].colorShade[0].color.hex}"))
         arr.add(Color.parseColor("#${list[position].colorShade[1].color.hex}"))
        if(list[position].colorShade.size>2) {
            holder.img3.setBackgroundColor(Color.parseColor("#${list[position].colorShade[2].color.hex}"))
            arr.add(Color.parseColor("#${list[position].colorShade[2].color.hex}"))
        }
        val drawable= GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,arr.toIntArray())
        drawable.gradientType = GradientDrawable.LINEAR_GRADIENT

        Glide.with(context).load(drawable).into(holder.img4)

        holder.text.text=list[position].name
    }


    override fun getItemCount()=list.size


    inner class Diff(private val newData:List<Star>, private val oldData:List<Star>): DiffUtil.Callback() {

        override fun getOldListSize()=oldData.size

        override fun getNewListSize()=newData.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)=oldData[oldItemPosition]==newData[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)=false

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int) = ""
    }


    fun update(newList:List<Star>){
      val result: DiffUtil.DiffResult = DiffUtil.calculateDiff(Diff(newList, list), true)
      list.clear()
      list.addAll(newList)
      result.dispatchUpdatesTo(this)

    }

    override fun onItemMove(from: Int, to: Int) {
        val aaa=ArrayList<Star>()
        aaa.addAll(list)
        Collections.swap(aaa,from,to)
        update(aaa)
    }

}