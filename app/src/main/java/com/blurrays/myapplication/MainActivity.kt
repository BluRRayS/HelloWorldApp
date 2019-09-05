package com.blurrays.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var mediaPlayer = MediaPlayer.create(this,R.raw.sample);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Hello World!");
        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener(){
            mediaPlayer.start();
            val rnd = Random.nextInt(0,200);
            val Label = findViewById<TextView>(R.id.textView).setText("This:"+rnd+" is a random number!")
        }

        val inputButton = findViewById<Button>(R.id.InputButton)
        inputButton.setOnClickListener(){
            val textBox = findViewById<TextView>(R.id.editText);
            val label = findViewById<TextView>(R.id.textViewInput);
            if( textBox.text != "" )
            {
                label.setText(textBox.text);
            }
        }

        val UpgradeBtn = findViewById<Button>(R.id.UpgradeButton)
        UpgradeBtn.setOnClickListener(){

            mediaPlayer.start();
            val intent = Intent(this, VideoActivity::class.java);
            startActivity(intent);
        }
    }
}
