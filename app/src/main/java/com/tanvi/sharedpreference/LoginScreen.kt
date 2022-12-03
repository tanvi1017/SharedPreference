package com.tanvi.sharedpreference

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tanvi.sharedpreference.databinding.ActivityLoginScreenBinding
import com.tanvi.sharedpreference.databinding.LoginActivityBinding

class LoginScreen : AppCompatActivity() {
    lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            checkIfUserAlreadyExist()
        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, RegisterScreen::class.java)
            startActivity(intent)
        }
    }
   private fun checkIfUserAlreadyExist(){
        val sharedPref=getSharedPreferences("tanviSP", MODE_PRIVATE)
        val savedEmail= sharedPref.getString("email","")
        val savedPassword =sharedPref.getString("password","")
        val email = binding.etEmail.text.toString()
        val password =binding.etPassword.text.toString()
        if (email==savedEmail&&password==savedPassword) {
            Toast.makeText(this, "loginsuccesfully!", Toast.LENGTH_LONG).show()
            val editor = sharedPref.edit()
            editor.apply {
                putBoolean("isLogin", true)
                apply()
            }
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(
                this, "Unable to login, email or password didn't match", Toast.LENGTH_LONG).show()
        }
    }
}