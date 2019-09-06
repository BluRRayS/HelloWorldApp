package com.blurrays.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                //Todo: Generate key and move to new activity.
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
            } else {
                //Todo: toast notification.
                Toast.makeText(this, "Wrong Credentials!", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun checkCredentials(email: String, password: String): Boolean {
        //Todo: Add logic
        return true;
    }
}
