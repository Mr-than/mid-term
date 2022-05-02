package com.example.redrockmterm.ui.homefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.redrockmterm.R
import com.example.redrockmterm.databinding.FragmentSigninBinding
import com.google.gson.JsonArray
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import kotlin.concurrent.thread

class SignInFragment: Fragment() {

    private lateinit var binding:FragmentSigninBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding= FragmentSigninBinding.inflate(inflater)

        binding.login.setOnClickListener {
            val manner=requireActivity().supportFragmentManager
            val t=manner.beginTransaction()
            t.replace(R.id.home_activity_fragment,LoginFragment())
            t.commit()
        }
        Toast.makeText(requireContext(),"点击注册按钮注册，或点击登录按钮登录。。。", Toast.LENGTH_LONG).show()

        binding.signin.setOnClickListener {

            if(binding.fragmentNameSigninEdit.text.isEmpty()||binding.fragmentPhoneSigninEdit.text.isEmpty()){
                Toast.makeText(requireContext(),"手机号和用户名都不能为空", Toast.LENGTH_SHORT).show()
            }else{

                thread {
                    val client=OkHttpClient()
                    val phone=binding.fragmentPhoneSigninEdit.text.toString()
                    val name=binding.fragmentNameSigninEdit.text.toString()
                    val body=FormBody.Builder().add("phone_number",phone).add("name",name).build()
                    val request=Request.Builder().url("http://redrock.udday.cn:8888/user/register").post(body).build()
                    val data=client.newCall(request).execute()
                    val a=data.body()!!.string()
                    //Log.d("222222222", "onCreateView--------->$a")
                    val json=JSONObject(a)
                    val msg=json.getString("message")
                    requireActivity().runOnUiThread{
                        Toast.makeText(requireContext(),msg, Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }





        return binding.root
    }
}