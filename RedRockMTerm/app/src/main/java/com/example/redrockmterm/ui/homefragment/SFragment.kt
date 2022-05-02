package com.example.redrockmterm.ui.homefragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.redrockmterm.databinding.FragmentSBinding
import com.example.redrockmterm.tool.list
import java.util.*
import kotlin.concurrent.thread

class SFragment: Fragment() {

    private lateinit var binding:FragmentSBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentSBinding.inflate(inflater)

        binding.m.text= "悟已往之不谏，知来者之可追"



        thread {

            while (true){

                Thread.sleep(100)
                val calendars = Calendar.getInstance()
                calendars.timeZone = TimeZone.getTimeZone("GMT+8:00")
                val month: String = (calendars.get(Calendar.MONTH) + 1).toString()
                val day: String = calendars.get(Calendar.DATE).toString()
                val h: String = calendars.get(Calendar.HOUR).toString()
                val m:String=calendars.get(Calendar.MINUTE).toString()
                val s: String = calendars.get(Calendar.SECOND).toString()

                requireActivity().runOnUiThread {
                    binding.n.text="$month 月 $day 日 $h 时 $m 分 $s 秒"
                }

            }

        }





        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val r=Random()
        val a=r.nextInt(143)

    }
}