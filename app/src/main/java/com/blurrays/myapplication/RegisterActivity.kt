package com.blurrays.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.blurrays.myapplication.R
import com.blurrays.myapplication.ViewModels.UserViewModel
import com.blurrays.myjobappinterfaces.UserType
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.time.LocalDate

class RegisterActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val signInLink = findViewById<TextView>(R.id.SigninTextViewLink)
        signInLink.setOnClickListener{
            val signIntent = Intent(this, LoginActivity::class.java)
            startActivity(signIntent)
        }

        val registerBtn = findViewById<Button>(R.id.CreateAccountButton)
        registerBtn.setOnClickListener{

            val model = UserViewModel()
            model.email = findViewById<EditText>(R.id.EmailTextBox).text.toString()
            model.password = findViewById<EditText>(R.id.PasswordTextBox).text.toString()
            var confirmPassword = findViewById<EditText>(R.id.ConfirmPasswordTextBox).text.toString()
            model.firstname = findViewById<EditText>(R.id.FirstnameTextBox).text.toString()
            model.lastname = findViewById<EditText>(R.id.LastnameTextBox).text.toString()
            model.phone = findViewById<EditText>(R.id.PhoneTextBox).text.toString()
            model.dateOfBirth = LocalDate.parse(findViewById<EditText>(R.id.DateTextBox).text)
            model.type = UserType.values()[findViewById<CheckBox>(R.id.CompanyOwnerCheckBox).isChecked.toString().toInt()]
            var agreed = findViewById<CheckBox>(R.id.AgreeCheckBox).isChecked






        }
    }
}
