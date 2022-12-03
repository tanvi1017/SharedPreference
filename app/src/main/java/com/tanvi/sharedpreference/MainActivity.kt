package com.tanvi.sharedpreference

import android.content.Intent
import android.icu.text.Normalizer2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tanvi.sharedpreference.databinding.ActivityMainBinding
import com.tanvi.sharedpreference.databinding.RegisterActivityBinding
import android.content.SharedPreferences as ContentSharedPreferences

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref=getSharedPreferences("tanviSP", MODE_PRIVATE)
        val editor=sharedPref.edit()
        binding.apply {
           btnSave.setOnClickListener{
               val userName = edtUsername.text.toString()
               val password = edtPassword.text.toString()
               editor.apply {
                   putString("user_name",userName)
                   putString("password",password)
                   apply()
               }
           }
            btnLoad.setOnClickListener {
                val userName= sharedPref.getString("user_name",null)
                val password =sharedPref.getString("password",null)
                tvUserName.text =userName
                tvPassword.text = password
            }
            btnLogin.setOnClickListener {
                if (edtUsername.text.toString() == "tanvi" && edtPassword.text.toString() == "tanvi123") {
                    Toast.makeText(this@MainActivity, "loginsuccesfully!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity, "name andpassword is wrong", Toast.LENGTH_LONG).show()
                    val intent =Intent(this@MainActivity,LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
