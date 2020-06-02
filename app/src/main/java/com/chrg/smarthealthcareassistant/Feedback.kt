package com.chrg.smarthealthcareassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_feedback.*

class Feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("HCname")
        val special = bundle!!.getString("HCspeciality")
        val des = bundle!!.getString("HCdes")
        val image = bundle!!.getInt("HCimage")
        val cost = bundle!!.getString("HCprices")
        val timing =bundle!!.getString("HCtiminds")
        tvDocnameFD.text = name
        tvSpecialFD.text = special

        val button: Button? = FeedbackSubmit
        button!!.setOnClickListener {
            val intent = Intent(this, FeedbackConfirmed::class.java)
            startActivity(intent)
        }

    }

}
