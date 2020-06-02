package com.chrg.smarthealthcareassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class edit_user_data : AppCompatActivity() {

    var nameETT: EditText? = null
    var genderETT: EditText? = null
    var maritalStatus: EditText? = null
    var phoneETT: EditText? = null
    var heightETT: EditText? = null
    var weightETT: EditText? = null
    var bloodETT: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_data)

        nameETT = findViewById<View>(R.id.etuEditName) as EditText
        genderETT = findViewById<View>(R.id.etuEditGender) as EditText
        maritalStatus = findViewById<View>(R.id.etuEditmStatus) as EditText
        phoneETT = findViewById<View>(R.id.etuEditPhone) as EditText
        heightETT = findViewById<View>(R.id.etuEditHeight) as EditText
        weightETT = findViewById<View>(R.id.etuEditWeight) as EditText
        bloodETT = findViewById<View>(R.id.etuEditBlood) as EditText

    }

    fun userDataSubmit(view: View){
        val strgender: String? = genderETT!!.text.toString()
        val strmStatus: String? = maritalStatus!!.text.toString()
        val strHeight: String? = heightETT!!.text.toString()
        val strWeight: String? = weightETT!!.text.toString()
        val strBlood: String? = bloodETT!!.text.toString()
        val str_Name: String? = nameETT!!.text.toString()
        val str_Phone: String? = phoneETT!!.text.toString()
        val type = "editData"
        val backgroundWorker = BackgroundWorker(this)
        backgroundWorker.execute(type, strgender, strmStatus,strHeight, strWeight, strBlood, str_Name, str_Phone)
    }
}
