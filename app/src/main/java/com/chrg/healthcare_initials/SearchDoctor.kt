package com.chrg.healthcare_initials

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_search_doctor.*
import kotlinx.android.synthetic.main.healthcare_info.view.*


class SearchDoctor : AppCompatActivity() {
    var listOfhealthcareFacility = ArrayList<Healthcare>()
    private var adapter:HealthcareAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_doctor)

        listOfhealthcareFacility.add(Healthcare("GeneralPhysician", "Des", R.drawable.banner2))
        listOfhealthcareFacility.add(Healthcare("GeneralSurgeon", "DES", R.drawable.banner2))
        listOfhealthcareFacility.add(Healthcare("Dentist", "Des", R.drawable.banner2))
        listOfhealthcareFacility.add(Healthcare("Orthopedist", "DEs123", R.drawable.banner2))

        adapter = HealthcareAdapter(this, listOfhealthcareFacility)
        docTypes.adapter = adapter
    }

    class HealthcareAdapter: BaseAdapter {
        var listOfhealthcareFacility = ArrayList<Healthcare>()
        var context: Context?=null
        constructor(context: Context, listOfHealthcare: ArrayList<Healthcare>):super() {
            this.listOfhealthcareFacility = listOfHealthcare
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var healthcare = listOfhealthcareFacility[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.healthcare_ticket, null)
            myView.tvHealthcareName.text = healthcare.name!!
            myView.tvHealthcareDes.text = healthcare.des!!
            myView.ivHealthcareImage.setImageResource(healthcare.image!!)
            myView.ivHealthcareImage.setOnClickListener {
                val intent = Intent(context, healthcareInfo::class.java)
                intent.putExtra("HCname", healthcare.name!!)
                intent.putExtra("HCdes", healthcare.des!!)
                intent.putExtra("HCimage", healthcare.image!!)
                context!!.startActivity(intent)
            }
//            myView.tvHealthcareName.text = Healthcare.name!!

            return myView
        }

        override fun getItem(position: Int): Any {
                return listOfhealthcareFacility[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfhealthcareFacility.size
        }
    }
}
