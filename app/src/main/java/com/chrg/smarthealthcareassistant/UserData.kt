package com.chrg.smarthealthcareassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
    }

    fun toEditData(view: View) {
        val intent = Intent(this, edit_user_data::class.java)
        startActivity(intent)
    }

    fun goToView(view: View){
        val intent = Intent(this, view_user_data::class.java)
        startActivity(intent)
    }
}
