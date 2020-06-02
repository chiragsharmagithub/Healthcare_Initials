package com.chrg.smarthealthcareassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class view_user_data : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user_data)
        val type = "view"
        val backgroundWorker = BackgroundWorker(this)
        backgroundWorker.execute(type)
    }
}
