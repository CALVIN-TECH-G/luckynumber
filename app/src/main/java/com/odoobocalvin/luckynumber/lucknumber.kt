package com.odoobocalvin.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.odoobocalvin.luckynumber.databinding.ActivityMainBinding
import kotlin.random.Random

class lucknumber : AppCompatActivity() {
    private lateinit var  binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_lucknumber)

        val txt2:EditText = findViewById(R.id.tvmyluck)
        val sbtn2: Button = findViewById(R.id.btn_2)
        var user_name = recieveUserName()
        var random_num = generateRandomNum()

        txt2.setText(""+random_num)

        sbtn2.setOnClickListener{
            shareData(user_name,random_num)
        }


    }




    fun recieveUserName(): String {
         val bundle: Bundle? = intent.extras
         val userName =  bundle?.get("name").toString()
         return userName


    }
    fun generateRandomNum(): Int {
        val random = Random.nextInt(1000)
        return random
    }
// sharing username and number
    fun shareData(userName: String, randomNum: Int) {
        //implist intents
        val i = Intent(Intent.ACTION_SEND)
    i.setType("text/plain")
    i.putExtra(Intent.EXTRA_SUBJECT,"$userName is lucky today")
    i.putExtra(Intent.EXTRA_TEXT,"$randomNum is  ur luckynumber")
    startActivity(i)
}

}


