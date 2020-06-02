package com.chrg.smarthealthcareassistant

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterPage : AppCompatActivity() {

    var nameET: EditText? = null
    var emailET: EditText? = null
    var passET: EditText? = null
    var phoneET: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        nameET = findViewById<View>(R.id.etRegName) as EditText
        emailET = findViewById<View>(R.id.etregEmail) as EditText
        passET = findViewById<View>(R.id.etRegPass) as EditText
        phoneET = findViewById<View>(R.id.etRegphone) as EditText

    }

    fun onReg(view: View) {
        val strName: String? = nameET!!.text.toString()
        val strEmail: String? = emailET!!.text.toString()
        val strPass: String? = passET!!.text.toString()
        val strPhone: String? = phoneET!!.text.toString()
        val type = "register"
        val backgroundWorker = BackgroundWorker(this)
        backgroundWorker.execute(type, strName, strEmail, strPass, strPhone)
//        finish()
    }

    fun toLoginPage(view: View) {
        finish()
    }
}