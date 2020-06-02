package com.chrg.smarthealthcareassistant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_history_of__appointments.*
import kotlinx.android.synthetic.main.history_of_appointment_ticket.view.*

class HistoryAppointments : AppCompatActivity() {

    var listOfhealthcareFacility = ArrayList<Healthcare>()
    private var adapter: HistoryAppointments.HealthcareAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_of__appointments)

        listOfhealthcareFacility.add(Healthcare("Nikhil Aggrawal","Gynecologist", "Gynaecology or gynecology is the medical practice dealing with the health of the female reproductive system. Outside medicine, the term means \"the science of women\". Its counterpart is andrology, which deals with medical issues specific to the male reproductive system. ", R.drawable.doc1, 800, "Monday to Saturday: 10 AM to 5PM"))
        listOfhealthcareFacility.add(Healthcare("Anuj Garg", "Pediatrician", "Pediatrics is the branch of medicine that involves the medical care of infants, children, and adolescents. The American Academy of Pediatrics recommends people be under pediatric care up to the age of 21. A medical doctor who specializes in this area is known as a pediatrician, or paediatrician.", R.drawable.doc2, 200, "Monday to Saturday: 10 AM to 5PM"))
        listOfhealthcareFacility.add(Healthcare("Amisha Duggal","Dermatologist", "Dermatology is the branch of medicine dealing with the skin. It is a speciality with both medical and surgical aspects. A dermatologist is a specialist doctor who manages diseases related to skin, hair and nails and some cosmetic problems.", R.drawable.doc3, 400, "Monday to Saturday: 10 AM to 5PM"))

        adapter = HealthcareAdapter(context = this, listOfHealthcare = listOfhealthcareFacility)
        lvHistory.adapter = adapter
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
            var myView = inflater.inflate(R.layout.history_of_appointment_ticket, null)
            myView.tvHCNameHist.text = healthcare.name!!
            myView.tvSpecialityHist.text = healthcare.speciality!!
            myView.tvPriceHist.text = "Rs. "+healthcare.price.toString()!!
            myView.tvTimingsHist.text = healthcare.timing!!
            myView.ivProfileImageHist.setImageResource(healthcare.image!!)
            myView.tvFeedback.setOnClickListener {
                val intent = Intent(context, Feedback::class.java)
                intent.putExtra("HCname", healthcare.name!!)
                intent.putExtra("HCspeciality", healthcare.speciality!!)
                intent.putExtra("HCdes", healthcare.des!!)
                intent.putExtra("HCimage", healthcare.image!!)
                intent.putExtra("HCprices", healthcare.price!!)
                intent.putExtra("HCtiminds", healthcare.timing)
                context!!.startActivity(intent)
            }
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

