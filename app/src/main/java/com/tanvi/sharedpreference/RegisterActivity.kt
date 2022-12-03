package com.tanvi.sharedpreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tanvi.sharedpreference.databinding.RegisterActivityBinding

class RegisterActivity:AppCompatActivity() {
    lateinit var binding: RegisterActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref=getSharedPreferences("tanviSP", MODE_PRIVATE)
        val editor=sharedPref.edit()
        binding.apply {
            editor.apply {
                val userName = sharedPref.getString("user_name",null)
                val password = sharedPref.getString("password",null)
                tvTextOne.text=userName
                tvTextView.text=password
            }
        }
    }

}

