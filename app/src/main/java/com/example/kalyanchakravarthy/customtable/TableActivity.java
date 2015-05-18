package com.example.kalyanchakravarthy.customtable;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TableActivity extends Activity implements OnItemClickListener {

    //variables declaration
    ArrayList<cars> arrayCars;
    ListView listViewCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        arrayCars=new ArrayList<cars>();

        cars audi=new cars(R.drawable.audi, "Audi A4", "Gray", 18000);
        cars opel=new cars(R.drawable.opel, "Opel Insigna", "Black", 14000);
        cars mercedes=new cars(R.drawable.mercedes, "mercedes CLS 320","Black", 16000);
        cars ferrari=new cars(R.drawable.ferrari_enzo, "Ferrari Enzo","White", 93000);
        cars fiesta=new cars(R.drawable.ford_fiesta, "Ford Fiesta","Green", 18000);
        cars porshe=new cars(R.drawable.porshe_cayenne,"porshe_cayenne","Dark Gray", 101000);
        cars lambo=new cars(R.drawable.lamborghini_gallardo, "Lamborghini gallardo","orange", 100000);
        cars hyundai=new cars(R.drawable.hyundai_i30, "Hyundai i30","blue", 20000);
        cars honda=new cars(R.drawable.honda_accord, "Honda accord","red", 19000);


        arrayCars.add(audi);
        arrayCars.add(opel);
        arrayCars.add(mercedes);
        arrayCars.add(ferrari);
        arrayCars.add(fiesta);
        arrayCars.add(porshe);
        arrayCars.add(lambo);
        arrayCars.add(hyundai);
        arrayCars.add(honda);




        listViewCars = (ListView) findViewById(R.id.list_cars);
        ListCarsAdapter adapter = new ListCarsAdapter(this, arrayCars);
        listViewCars.setAdapter(adapter);
        listViewCars.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cars selectedCar = arrayCars.get(position);
        Toast.makeText(this, "You've selected " + selectedCar.getModel() +
                " " + selectedCar.getColor()
                , Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table, menu);
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
