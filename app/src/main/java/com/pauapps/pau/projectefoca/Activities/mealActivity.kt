package com.pauapps.pau.projectefoca.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.pauapps.pau.projectefoca.R
import android.widget.LinearLayout
import android.widget.RelativeLayout


class mealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal)
        var extras: Bundle = intent.extras
        var nameMeal = extras.getString("nameMeal")
        var today = extras.getString("today")
        var tx = findViewById<TextView>(R.id.text_view)

        tx.setText(nameMeal + " of day: " + today)
    }

    fun addItem(v: View) {
        val sv = findViewById<RelativeLayout>(R.id.relative)
        val ll = LinearLayout(applicationContext)
        ll.isBaselineAligned
        sv.addView(ll)
        val tv = TextView(this)
        tv.baseline
        tv.text = "Dynamic layouts ftw!"
        ll.addView(tv)

    }
}