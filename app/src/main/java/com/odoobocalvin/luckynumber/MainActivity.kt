package com.odoobocalvin.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.odoobocalvin.luckynumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val edittxt = binding.txtview.text

        binding.btnluck.setOnClickListener{
            // explist intents
            val i = Intent(this,lucknumber::class.java)
            //passing the user name
            i.putExtra("name", edittxt)
            startActivity(i)
        }
    }

}