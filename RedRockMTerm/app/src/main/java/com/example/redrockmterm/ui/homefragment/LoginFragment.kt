package com.example.redrockmterm.ui.homefragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.redrockmterm.R
import com.example.redrockmterm.databinding.FragmentLoginBinding
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import kotlin.concurrent.thread

class LoginFragment: Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private lateinit var sp:SharedPreferences
    private lateinit var edit:SharedPreferences.Editor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding= FragmentLoginBinding.inflate(inflater)

        sp=requireActivity().getSharedPreferences("token",MODE_PRIVATE)
        edit=sp.edit()


        binding.fragmentSignin.setOnClickListener{
            val manager: FragmentManager = requireActivity().supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.home_activity_fragment, SignInFragment())
            transaction.commit()
        }

        Toast.makeText(requireContext(),"点击登录按钮登录，或点击注册按钮注册。。。",Toast.LENGTH_LONG).show()

        binding.fragmentLogin.setOnClickListener {
            if(binding.fragmentPhoneLoginEdit.text.isEmpty()){
                Toast.makeText(requireContext(),"手机号不能为空",Toast.LENGTH_SHORT).show()
            }else{

                thread {

                    try {
                        val client= OkHttpClient()
                        val phone=binding.fragmentPhoneLoginEdit.text.toString()
                        val body= FormBody.Builder().add("phone_number",phone).build()
                        val request= Request.Builder().url("http://redrock.udday.cn:8888/user/long_login").post(body).build()
                        val data=client.newCall(request).execute()
                        val a=data.body()!!.string()
                        val r=JSONObject(a)
                        val j=r.getJSONObject("data")
                        val d=j.getString("token")

                        if(d.isNotEmpty()){
                            requireActivity().runOnUiThread{
                                Toast.makeText(requireContext(),"登录成功",Toast.LENGTH_SHORT).show()
                            }
                        }

                        edit.putString("t",d)
                        edit.apply()


                        val manager: FragmentManager = requireActivity().supportFragmentManager
                        val transaction = manager.beginTransaction()
                        transaction.replace(R.id.home_activity_fragment, SFragment())
                        transaction.commit()

                    }catch (e:Exception){

                        requireActivity().runOnUiThread{
                            Toast.makeText(requireContext(),e.message,Toast.LENGTH_SHORT).show()
                        }

                    }


                }
            }
        }
        return binding.root
    }


}