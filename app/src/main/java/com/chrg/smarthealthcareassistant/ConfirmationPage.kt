package com.chrg.smarthealthcareassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_conformation_page.*


class ConfirmationPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conformation_page)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("HCname")
        val special = bundle!!.getString("HCspeciality")
        val des = bundle!!.getString("HCdes")
        val image = bundle!!.getInt("HCimage")
        val cost = bundle!!.getString("HCprices")
        val timing =bundle!!.getString("HCtiminds")
        tvNameBooked.text = getString(R.string.userName)
        tvPhoneBooked.text = getString(R.string.userPhoneNumbert)
        tvEmailBooked.text = getString(R.string.userEmail)
        tvTransactionIDBooked.text = getString(R.string.userTransactionID)
        tvHCNameBooked.text = name
//        tvCostBooked.text = cost
        tvTimingBooked.text = timing
    }

    fun goToMainPage(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
