package com.lroxima.body_health.bodyhealth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Database dbHandler;
    //private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new Database(this);

        String[] items = {"Car","Bike","Van","Truck"};
        //ListAdapter itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        ListAdapter itemAdapter = new ItemAdapter(this,items);
        ListView itemListView = (ListView) findViewById(R.id.MainListView);
        itemListView.setAdapter(itemAdapter);

        itemListView.setOnItemClickListener(
               new AdapterView.OnItemClickListener(){
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       String item = String.valueOf(parent.getItemAtPosition(position));
                       Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                   }
               }
        );

        Toast.makeText(MainActivity.this, dbHandler.dbToString(), Toast.LENGTH_LONG).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, EntryActivity.class));
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
