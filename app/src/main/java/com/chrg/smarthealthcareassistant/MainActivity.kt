package com.chrg.smarthealthcareassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun DocPage(view: View){
        val intent = Intent(this, CategoryPage::class.java)
        startActivity(intent)
    }

    fun goToCat2(view: View) {
        val intent = Intent(this, CategoryPage2::class.java)
        startActivity(intent)
    }

    fun goToUserData(view: View) {
        val intent = Intent(this, UserData::class.java)
        startActivity(intent)
    }
    fun gotoHistory(view: View){
        val intent = Intent(this, HistoryAppointments::class.java)
        startActivity(intent)
    }
}
