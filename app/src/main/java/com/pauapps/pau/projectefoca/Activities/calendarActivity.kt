package com.pauapps.pau.projectefoca.Activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import android.transition.Slide
import android.transition.TransitionManager
import android.view.*
import kotlinx.android.synthetic.main.calendar.*
import android.widget.TextView
import android.widget.LinearLayout
import com.pauapps.pau.projectefoca.R


//Develop a calendar view
class calendarActivity : AppCompatActivity() {
    var daySelect: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar)

        val calendarView = findViewById<CalendarView>(R.id.calendar)
        calendarView?.setOnDateChangeListener { _, year, month, day ->
            daySelect = day.toString() + "/" + (month + 1) + "/" + year
            openDay(daySelect)
            //val msg = "Selected date is " + day + "/" + (month + 1) + "/" + year
            //Toast.makeText(this@calendarActivity, msg, Toast.LENGTH_SHORT).show()
        }

    }

    @SuppressLint("InflateParams", "ObsoleteSdkInt")
    private fun openDay(daySelect: String) {
        // Initialize a new layout inflater instance
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // Inflate a custom view using layout inflater
        val view = inflater.inflate(R.layout.day, null)
        // Initialize a new instance of popup window
        val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
        )
        popupWindow.isOutsideTouchable = true
        popupWindow.isFocusable = true
        // Set an elevation for the popup window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.elevation = 10.0F
        }
        // If API level 23 or higher then execute the code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Create a new slide animation for popup window enter transition
            val slideIn = Slide()
            slideIn.slideEdge = Gravity.TOP
            popupWindow.enterTransition = slideIn

            // Slide animation for popup window exit transition
            val slideOut = Slide()
            slideOut.slideEdge = Gravity.RIGHT
            popupWindow.exitTransition = slideOut

        }
        // Get the widgets reference from custom view
        val tv = view.findViewById<TextView>(R.id.text_view)
        tv.setText("Day: " + daySelect)
        // Finally, show the popup window on app
        TransitionManager.beginDelayedTransition(calendar_layout)
        popupWindow.showAtLocation(
                calendar_layout, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
        )
    }

    fun openMeal(view: View) {
        val intent = Intent(this, mealActivity::class.java)
        val men = findViewById<TextView>(R.id.menjada1)
        //men.setText(R.string.menjada1)
        //val nameMeal = men.text.toString()
        intent.putExtra("nameMeal", "Berenar")
        intent.putExtra("today", daySelect)
        startActivity(intent)

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