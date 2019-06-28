package com.pauapps.pau.projectefoca.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.pauapps.pau.projectefoca.R
import com.pauapps.pau.projectefoca.Utils.DB


class mealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal)
        var extras: Bundle = intent.extras
        var nameMeal = extras.getString("nameMeal")
        var today = extras.getString("today")
        var tx = findViewById<TextView>(R.id.text_view)

        tx?.setText(nameMeal + " of day: " + today)
    }

    fun addItem(v: View) {
        val db = DB(this)

        var relative: LinearLayout = findViewById<LinearLayout>(R.id.relative)
        var linear = LinearLayout(applicationContext)

        var name = EditText(applicationContext)
        name.setHint(R.string.nom)
        linear.addView(name)

        var quantity = EditText(applicationContext)
        quantity.setHint(R.string.quantiat)
        linear.addView(quantity)

        var type = Spinner(applicationContext)
        type.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, db.getMeasures()));
        linear.addView(type)

        relative.addView(linear)
    }

    fun addMeal(v: View) {

    }
}