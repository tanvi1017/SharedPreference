package com.tanvi.sharedpreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tanvi.sharedpreference.databinding.ActivityMainBinding
import com.tanvi.sharedpreference.databinding.LoginActivityBinding

class LoginActivity:AppCompatActivity() {
    lateinit var binding:LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}