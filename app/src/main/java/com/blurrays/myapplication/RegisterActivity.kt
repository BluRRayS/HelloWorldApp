package com.blurrays.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.blurrays.myapplication.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.time.LocalDate

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerBtn = findViewById<Button>(R.id.CreateAccountButton)
        registerBtn.setOnClickListener{
            var email = findViewById<EditText>(R.id.EmailTextBox).text
            var password = findViewById<EditText>(R.id.PasswordTextBox).text
            var confirmPassword = findViewById<EditText>(R.id.ConfirmPasswordTextBox).text
            var firstname = findViewById<EditText>(R.id.FirstnameTextBox).text
            var lastname = findViewById<EditText>(R.id.LastnameTextBox).text
            var dateOfBirth = findViewById<EditText>(R.id.DateTextBox).text
            //var isCompanyOwner = findViewById<CheckBox>(R.id.CompanyOwnerCheckBox).isChecked
            var agreed = findViewById<CheckBox>(R.id.AgreeCheckBox).isChecked


        }
    }
}
