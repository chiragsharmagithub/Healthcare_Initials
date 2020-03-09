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

class healthcareArticles : AppCompatActivity() {

    var listOfhealthcareFacility = ArrayList<Healthcare>()
    private var adapter:HealthcareAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_doctor)

        listOfhealthcareFacility.add(Healthcare("CoronaVirus - COVID-19", "The purpose of this document is to provide a practical guide for the UNCTs and partners to develop a CPRP to immediately support national governments to prepare for and respond to COVID‑19. ", R.drawable.corona))
        listOfhealthcareFacility.add(Healthcare("AI yields new Antibiotic", "An antibiotic is a type of antimicrobial substance active against bacteria and is the most important type of antibacterial agent for fighting bacterial infections. Antibiotic medications are widely used in the treatment and prevention of such infections. ", R.drawable.antibiotic))
        listOfhealthcareFacility.add(Healthcare("Immune System", "The immune system is a complex network of cells and proteins that defends the body against infection. The immune system keeps a record of every germ (microbe) it has ever defeated so it can recognise and destroy the microbe quickly if it enters the body again.", R.drawable.immune))
        listOfhealthcareFacility.add(Healthcare("Aging in Cells", "Cellular ageing is generally defined as the progressive decline in the resistance to stress and other cellular damages, causing a gradual loss of cellular functions and resulting eventually in cell death.", R.drawable.aging))
        listOfhealthcareFacility.add(Healthcare("Scientists monitor brain cells", "The brain and spinal cord are made up of many cells, including neurons and glial cells. Neurons are cells that send and receive electro-chemical signals to and from the brain and nervous system. ", R.drawable.brain))


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