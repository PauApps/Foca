package com.pauapps.pau.projectefoca

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast

//Develop a calendar view
class Calendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)

        val calendarView = findViewById<CalendarView>(R.id.calendar)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(this@Calendar, msg, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        val txt = findViewById<TextView>(R.id.text)


        when (id) {
            R.id.action_inici -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.action_menu -> {
                val intent = Intent(this, Calendar::class.java)
                startActivity(intent)
                //txt.setText("MENU");
            }
            R.id.action_compra ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }
}