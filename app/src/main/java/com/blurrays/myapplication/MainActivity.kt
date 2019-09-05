package com.blurrays.myapplication

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var mediaPlayer = MediaPlayer.create(this,R.raw.sample)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Hello World!")
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            mediaPlayer.start()
            val rnd = Random.nextInt(0,200)
            findViewById<TextView>(R.id.textView).text = "This:"+rnd+" is a random number!"
            vibrate()
        }

        val inputButton = findViewById<Button>(R.id.InputButton)
        inputButton.setOnClickListener {
            val textBox = findViewById<TextView>(R.id.editText)
            val label = findViewById<TextView>(R.id.textViewInput)
            if( textBox.text != "" )
            {
                label.text = textBox.text
            }
        }


        val upgradeBtn = findViewById<Button>(R.id.UpgradeButton)
        upgradeBtn.setOnClickListener {

            mediaPlayer.start()
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun vibrate(milliseconds:Long = 500) {
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // Check whether device/hardware has a vibrator
        val canVibrate:Boolean = vibrator.hasVibrator()

        if(canVibrate){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                // void vibrate (VibrationEffect vibe)
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        milliseconds,
                        // The default vibration strength of the device.
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            }
        }
    }
}


