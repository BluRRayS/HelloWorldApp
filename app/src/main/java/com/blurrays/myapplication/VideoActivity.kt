package com.blurrays.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_video.*
import java.net.URI
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.webkit.WebView


class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val GoBackBtn = findViewById<Button>(R.id.GoBackButton)
        GoBackBtn.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
        val webView = findViewById<WebView>(R.id.MemeView);
        webView.loadUrl("https://www.youtube.com/watch?v=havhaDYh0Sc&t=1s");

    }
}
