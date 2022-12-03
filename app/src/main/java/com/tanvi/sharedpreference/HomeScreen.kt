package com.tanvi.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tanvi.sharedpreference.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {
    lateinit var binding:ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref=getSharedPreferences("tanviSP", MODE_PRIVATE)
        val editor=sharedPref.edit()
        binding.apply {
            editor.apply {
                val email = sharedPref.getString("email",null)
                userInfoTV.text=email
            }
        }
        binding.logoutButton.setOnClickListener {
            editor.apply{
                putBoolean("isLogin",false)
                apply()//

            }
            val intent = Intent(this, Splash::class.java)
            startActivity(intent)
        }
    }
}