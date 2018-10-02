package com.chuck.android.meetupfoodiedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class OrderStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_start);

        //Button Add Food

        //Start Activity with Result

        //List of Added Foods
        //On recyclerview list have a Modify Food button or link

        //Total Button
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.order_start_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clear_table:
//           Do Something
               return true;
            case R.id.choose_region:
//           Do Something
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
