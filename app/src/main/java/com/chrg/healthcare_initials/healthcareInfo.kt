package com.chrg.healthcare_initials

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.healthcare_info.*

class healthcareInfo:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.healthcare_info)

        val bundle:Bundle = intent.extras
        val name = bundle.getString("HCname")
        val des = bundle.getString("HCdes")
        val image = bundle.getInt("HCimage")
        ivHealthcareImage.setImageResource(image)
        tvHealthcareName.text = name
        tvHealthcareDes.text = des
    }
}