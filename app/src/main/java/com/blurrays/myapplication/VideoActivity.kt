package com.blurrays.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer
import android.webkit.WebView


class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val goBackBtn = findViewById<Button>(R.id.GoBackButton)
        goBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val webView = findViewById<WebView>(R.id.MemeView)
        webView.loadUrl("https://i.pinimg.com/originals/70/c6/56/70c6564ccd4fa0d3d57d27dba0729284.jpg")
    }
}
