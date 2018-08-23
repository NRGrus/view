package com.example.ruslan.imagesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    String [] countries = {"Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ListView countriesList = (ListView) findViewById(R.id.countriesList);
//
//        String [] countries2 = getResources().getStringArray(R.array.countries);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries2);
//
//        countriesList.setAdapter(adapter);
//    }

    private TextView selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);

        selection = (TextView) findViewById(R.id.selection);
        final ListView countriesList = (ListView) findViewById(R.id.countriesList);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);

        countriesList.setAdapter(adapter);

        countriesList.setOnItemClickListener(new OnItemClickListener() {
            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = countries[position];
//                selection.setText(selectedItem);
//            }
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sp = countriesList.getCheckedItemPositions();

                String selectedItem = "";
                for (int i = 0; i < countries.length; i++) {
                    if(sp.get(i))
                        selectedItem += countries[i] + ",";
                }
                selection.setText("Выбрано: " + selectedItem);
            }
        });
    }
}
