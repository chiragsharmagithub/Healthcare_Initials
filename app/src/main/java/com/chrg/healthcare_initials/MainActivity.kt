package com.chrg.healthcare_initials

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button1:Button = findViewById(R.id.buDoc)
        button1.setOnClickListener {
            val intent = Intent(this, SearchDoctor::class.java)
            startActivity(intent)
        }
        val button2:Button = findViewById(R.id.buHealthcareF)
        button2.setOnClickListener {
            val intent = Intent(this, healthcareFacility::class.java)
            startActivity(intent)
        }
        val button3: Button = findViewById(R.id.buCheckup)
        button3.setOnClickListener {
            val intent = Intent(this, checkup::class.java)
            startActivity(intent)
        }

        val button4: Button = findViewById(R.id.buheathArticle)
        button4.setOnClickListener {
            val intent = Intent(this, healthcareArticles::class.java)
            startActivity(intent)
        }
    }



}
