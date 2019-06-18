package com.pauapps.pau.projectefoca.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.pauapps.pau.projectefoca.Utils.DB
import com.pauapps.pau.projectefoca.R

import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val currentTime = SimpleDateFormat("dd/MM/YYYY")
        val today = findViewById<TextView>(R.id.today)

        today.text = "Today is " + currentTime.format(Date())

        val db = DB(this)

        db.select()

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


        when (id) {
            R.id.action_inici -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.action_menu -> {
                val intent = Intent(this, calendarActivity::class.java)
                startActivity(intent)
                //txt.setText("MENU");
            }
            R.id.action_compra -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

}
