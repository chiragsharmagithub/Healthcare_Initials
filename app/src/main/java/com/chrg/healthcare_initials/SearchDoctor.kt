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

        listOfhealthcareFacility.add(Healthcare("General Physician", "General Physicians are highly trained specialists who provide a range of non-surgical health care to adult patients. They care for difficult, serious or unusual medical problems and continue to see the patient until these problems have resolved or stabilised.", R.drawable.doc1))
        listOfhealthcareFacility.add(Healthcare("General Surgeon", "A general surgeon is a physician who has been educated and trained in the diagnosis and preoperative, operative, and postoperative management of patient care.", R.drawable.doc2))
        listOfhealthcareFacility.add(Healthcare("Dentist", "One who is skilled in and licensed to practice the prevention, diagnosis, and treatment of diseases, injuries, and malformations of the teeth, jaws, and mouth and who makes and inserts false teeth.", R.drawable.doc3))
        listOfhealthcareFacility.add(Healthcare("Orthopedist", "A doctor who specializes in the branch of medicine concerned with the correction or prevention of deformities, disorders, or injuries of the skeleton and associated structures An orthopedist treated her knee injury.", R.drawable.doc4))
        listOfhealthcareFacility.add(Healthcare("Gynecologist", "Gynaecology or gynecology is the medical practice dealing with the health of the female reproductive system. Outside medicine, the term means \"the science of women\". Its counterpart is andrology, which deals with medical issues specific to the male reproductive system. ", R.drawable.doc1))
        listOfhealthcareFacility.add(Healthcare("Pediatrician", "Pediatrics is the branch of medicine that involves the medical care of infants, children, and adolescents. The American Academy of Pediatrics recommends people be under pediatric care up to the age of 21. A medical doctor who specializes in this area is known as a pediatrician, or paediatrician.", R.drawable.doc2))
        listOfhealthcareFacility.add(Healthcare("Dermatologist", "Dermatology is the branch of medicine dealing with the skin. It is a speciality with both medical and surgical aspects. A dermatologist is a specialist doctor who manages diseases related to skin, hair and nails and some cosmetic problems.", R.drawable.doc3))
        listOfhealthcareFacility.add(Healthcare("Physiotherapist", "Physiotherapists help people affected by injury, illness or disability through movement and exercise, manual therapy, education and advice. They maintain health for people of all ages, helping patients to manage pain and prevent disease.", R.drawable.doc4))


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
