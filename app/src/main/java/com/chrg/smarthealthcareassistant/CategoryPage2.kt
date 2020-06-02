package com.chrg.smarthealthcareassistant

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_category_page2.*
import kotlinx.android.synthetic.main.category_page_ticket.view.*

class CategoryPage2 : AppCompatActivity() {

    private var listHealthcareFacility = ArrayList<Healthcare>()
    private var adapter: HealthAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_page2)

        listHealthcareFacility.add(Healthcare("Poonam mathur", "Nursing Aid", "The healthcare facility focuses on providing good nursing ais/ Care and not first aid.", R.drawable.doc3, 600, "Monday to Saturday: 10 AM to 5PM"))
        listHealthcareFacility.add(Healthcare("Raj Malhotra","Nutritional Support", "A Nutritional support to provide proper nutritional support", R.drawable.doc2, 1000, "Monday to Saturday: 10 AM to 5PM"))
        listHealthcareFacility.add(Healthcare("Siddharth Sharma","Tracking services", "Tracking of both patient and services", R.drawable.doc4, 500, "Monday to Saturday: 10 AM to 5PM"))
        listHealthcareFacility.add(Healthcare("Anuj Garg", "Pediatrician", "Pediatrics is the branch of medicine that involves the medical care of infants, children, and adolescents. The American Academy of Pediatrics recommends people be under pediatric care up to the age of 21. A medical doctor who specializes in this area is known as a pediatrician, or paediatrician.", R.drawable.doc2, 200, "Monday to Saturday: 10 AM to 5PM"))


        adapter = HealthAdapter(this, listHealthcareFacility)
        lvDocTypes2.adapter = adapter
    }

    class HealthAdapter: BaseAdapter {
        private var listHealthcare = ArrayList<Healthcare>()
        var context: Context?=null
        constructor(context: Context, listOfHealthcare: ArrayList<Healthcare>):super() {
            this.listHealthcare = listOfHealthcare
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var healthcare = this.listHealthcare[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.category_page_ticket2, null)
            myView.tvName.text = healthcare.name!!
            myView.tvSpeciality.text = healthcare.speciality!!
            myView.tvCost.text = "Rs. "+ healthcare.price.toString()
            myView.tvTimings.text = healthcare.timing!!
            myView.ivProfileImage.setImageResource(healthcare.image!!)
            myView.docProfile.setOnClickListener {
                val intent = Intent(context, pay_and_book::class.java)
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
            return this.listHealthcare[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return this.listHealthcare.size
        }
    }
}
