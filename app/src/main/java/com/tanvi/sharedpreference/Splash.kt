package com.tanvi.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.tanvi.sharedpreference.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
      supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("tanviSP", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin",false)
            if(isLogin){
                val intent = Intent(this@Splash,HomeScreen::class.java)
                startActivity(intent)
            }else{ val intent = Intent(this@Splash,LoginScreen::class.java)
                startActivity(intent)
            }
        }, 2000)

        }
    }
