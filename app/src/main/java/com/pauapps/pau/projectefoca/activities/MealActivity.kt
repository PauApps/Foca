package com.pauapps.pau.projectefoca.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.*
import com.pauapps.pau.projectefoca.R
import com.pauapps.pau.projectefoca.Utils.DB


class MealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal)
        var extras: Bundle? = intent.extras
        var nameMeal = extras?.getString("nameMeal")
        var today = extras?.getString("today")
        var tx = findViewById<TextView>(R.id.text_view)

        tx?.setText(nameMeal + " of day: " + today)
    }

    fun addItem(v: View) {
        val db = DB(this)

        var relative: LinearLayout = findViewById(R.id.relative)
        var linear = LinearLayout(applicationContext)

        var name = EditText(applicationContext)
        name.setHint(R.string.nom)
        name.setTag(R.string.idNam)
        linear.addView(name)

        var quantity = EditText(applicationContext)
        quantity.setHint(R.string.quantiat)
        quantity.setTag(R.string.idQuantity)
        linear.addView(quantity)

        var type = Spinner(applicationContext)
        type.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, db.getMeasures()));
        type.setTag(R.string.idType)
        linear.addView(type)

        relative.addView(linear)
    }

    fun addMeal(v: View) {
        var view: LinearLayout = findViewById(R.id.relative)
        var count: Int = view.childCount
        println(count)
        for (child in 0 until count) run {
            println(child)
            var group: View = view.getChildAt(child)

            var name: EditText = group.findViewWithTag(R.string.idNam)
            var nom: Editable? = name.text

            var quantity: EditText = group.findViewWithTag(R.string.idQuantity)
            var quantitat: Editable? = quantity.text

            var type: Spinner = group.findViewWithTag(R.string.idType)
            var tipus: Any? = type.selectedItem

            println(nom.toString() + quantitat.toString() + tipus)

            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
    }
}