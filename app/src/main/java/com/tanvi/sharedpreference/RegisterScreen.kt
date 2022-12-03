package com.tanvi.sharedpreference

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tanvi.sharedpreference.databinding.ActivityRegisterScreenBinding

class RegisterScreen : AppCompatActivity() {
    lateinit var binding: ActivityRegisterScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnRegister.setOnClickListener {
               saveUserData()
                val intent = Intent(this@RegisterScreen,HomeScreen::class.java)
                startActivity(intent)
            }
            tvlogin.setOnClickListener {
                val intent = Intent(this@RegisterScreen, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun saveUserData(){
        val sharedPref = getSharedPreferences("tanviSP", MODE_PRIVATE)
        val editor = sharedPref.edit()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        editor.apply {
            putString("email", email)
            putString("password", password)
            putBoolean("isLogin", true)
            apply()
        }
    }
}