package com.blurrays.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private var inputPassword = ""
    private var inputEmail = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.btnLogin)
        inputPassword = findViewById<EditText>(R.id.textBoxPassword).text.toString();
        inputEmail = findViewById<EditText>(R.id.textBoxEmail).text.toString();

        loginBtn.setOnClickListener() {

            inputPassword = findViewById<EditText>(R.id.textBoxPassword).text.toString();
            inputEmail = findViewById<EditText>(R.id.textBoxEmail).text.toString();

            if (checkCredentials(inputEmail, inputPassword)) {

                Snackbar.make(
                    findViewById<View>(R.id.btnLogin),
                    "Login successful!",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action", null).show()

                //Todo: Generate key and move to new activity.
                val intent = Intent(this, HomeActivity::class.java);

            } else {

                Snackbar.make(
                    findViewById<View>(R.id.btnLogin),
                    "Wrong Credentials!",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action", null).show()
            }

        }
    }

    private fun checkCredentials(email: String, password: String): Boolean {
        //Todo: Add logic
        return true;
    }
}
