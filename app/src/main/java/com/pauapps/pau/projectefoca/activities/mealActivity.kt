package com.pauapps.pau.projectefoca.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.pauapps.pau.projectefoca.R


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
        var relative: LinearLayout = findViewById<LinearLayout>(R.id.relative)
        var linear = LinearLayout(applicationContext)

        var name = EditText(applicationContext)
        name.setHint(R.string.nom)
        linear.addView(name)

        var quantity = EditText(applicationContext)
        quantity.setHint(R.string.quantiat)
        linear.addView(quantity)

        relative.addView(linear)
    }
}