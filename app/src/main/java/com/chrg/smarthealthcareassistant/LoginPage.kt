package com.chrg.smarthealthcareassistant

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LoginPage : AppCompatActivity() {

    private val backgroundWorker = BackgroundWorker(this)

    var usernameET: EditText? = null
    var passwordET: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        usernameET = findViewById<View>(R.id.etEmail) as EditText
        passwordET = findViewById<View>(R.id.etPassword) as EditText
    }

    fun onLogin(view: View?) {
        val username = usernameET!!.text.toString()
        val password = passwordET!!.text.toString()
        val type = "login"

        backgroundWorker.execute(type, username, password)
    }

    fun toRegistrationPage(view: View) {
        var intent = Intent(this, RegisterPage::class.java)
        startActivity(intent)
    }
    fun toMain(view: View) {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}