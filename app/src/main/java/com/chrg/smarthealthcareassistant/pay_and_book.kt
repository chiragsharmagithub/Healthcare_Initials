package com.chrg.smarthealthcareassistant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_pay_and_book.*

class pay_and_book : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_and_book)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("HCname")
        val special = bundle!!.getString("HCspeciality")
        val des = bundle!!.getString("HCdes")
        val image = bundle!!.getInt("HCimage")
        val cost = bundle!!.getString("HCprices")
        val timing =bundle!!.getString("HCtiminds")
        tvHCName.text = name
        tvHCSpeciality.text = special
        tvHCDescription.text = des
        ivHCProfileImage.setImageResource(image)
        tvHCCost.text = cost
        tvHCTimings.text = timing
        paymentMode.setOnClickListener {
            val intent = Intent(this, ConfirmationPage::class.java)
            intent.putExtra("HCname", name)
            intent.putExtra("HCspeciality", special)
            intent.putExtra("HCdes", des)
            intent.putExtra("HCprices", cost)
            intent.putExtra("HCtiminds", timing)
            this.startActivity(intent)
        }
    }

    fun gotoConfirmationPage(view: View){
        val intent = Intent(this, ConfirmationPage::class.java)
        startActivity(intent)
    }


}
