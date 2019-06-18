package com.pauapps.pau.projectefoca.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.pauapps.pau.projectefoca.R

class mealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal)
        var extras:Bundle = intent.extras
        var nameMeal = extras.getString("nameMeal")
        var today = extras.getString("today")
        var tx = findViewById<TextView>(R.id.text_view)

        tx.setText(nameMeal + " of day: " + today)
    }
}