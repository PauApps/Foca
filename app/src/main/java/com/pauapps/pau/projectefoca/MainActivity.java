package com.pauapps.pau.projectefoca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SimpleDateFormat currentTime = new SimpleDateFormat("dd/MM/YYYY");
        TextView today = findViewById(R.id.today);

        today.setText("Today is " + currentTime.format(new Date()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        TextView txt = findViewById(R.id.text);
        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.action_inici:
                //txt.setText("INICI");
                return true;
            case R.id.action_menu:
                //txt.setText("MENU");
                return true;
            case R.id.action_compra:
                //txt.setText("LLISTA DE LA COMPRA");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
