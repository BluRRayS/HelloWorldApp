package com.blurrays.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Hello World!");
        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener(){
            val rnd = Random.nextInt(0,200);
            val Label = findViewById<TextView>(R.id.textView).setText("This:"+rnd+" is a random number!")
        }
    }
}
