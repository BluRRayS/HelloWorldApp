package com.blurrays.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import android.text.TextUtils
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView


class LoginActivity : AppCompatActivity() {

    private var inputPassword = ""
    private var inputEmail = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.btnLogin)
        inputPassword = findViewById<EditText>(R.id.textBoxPassword).text.toString()
        inputEmail = findViewById<EditText>(R.id.textBoxEmail).text.toString()

        loginBtn.setOnClickListener {

            inputPassword = findViewById<EditText>(R.id.textBoxPassword).text.toString()
            inputEmail = findViewById<EditText>(R.id.textBoxEmail).text.toString()

            if (checkCredentials(inputEmail, inputPassword)) {
                Snackbar.make(
                    findViewById<View>(R.id.btnLogin),
                    "Login successful!",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action", null).show()
                vibrate(100)
                //Todo: Generate key and move to new activity.
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("Email",inputEmail)
                startActivity(intent)

            } else {

                Snackbar.make(
                    findViewById<View>(R.id.btnLogin),
                    "Wrong Credentials!",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action", null).show()
            }
            vibrate()
            val registerTextView = findViewById<TextView>(R.id.RegisterTextView)
            registerTextView.setOnClickListener{
                val registerIntent = Intent(this,RegisterActivity::class.java)
                startActivity(registerIntent)
            }
        }
    }

    private fun checkCredentials(email: String, password: String): Boolean {
        //Todo: Add logic
        return isValidEmail(email) && password . isNotEmpty ()

    }


    private fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    private fun vibrate(milliseconds: Long = 500) {
        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // Check whether device/hardware has a vibrator
        val canVibrate: Boolean = vibrator.hasVibrator()

        if (canVibrate) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
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
