package com.example.ruslan.imagesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


import java.util.ArrayList;

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

//    private TextView selection;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.listview_layout);
//
//        selection = (TextView) findViewById(R.id.selection);
//        final ListView countriesList = (ListView) findViewById(R.id.countriesList);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);
//
//        countriesList.setAdapter(adapter);
//
//        countriesList.setOnItemClickListener(new OnItemClickListener() {
//            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                String selectedItem = countries[position];
////                selection.setText(selectedItem);
////            }
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SparseBooleanArray sp = countriesList.getCheckedItemPositions();
//
//                String selectedItem = "";
//                for (int i = 0; i < countries.length; i++) {
//                    if(sp.get(i))
//                        selectedItem += countries[i] + ",";
//                }
//                selection.setText("Выбрано: " + selectedItem);
//            }
//        });
//    }


    ArrayList<String> phones = new ArrayList();
    ArrayAdapter<String> adapter;

    ArrayList<String> selectedPhones = new ArrayList();
    ListView phonesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview2_layout);

        phones.add("iPhone 7");
        phones.add("Samsung Galaxy S7");
        phones.add("Google Pixel");
        phones.add("Huawei P10");
        phones.add("HP Elite z3");

        phonesList = (ListView) findViewById(R.id.phonesList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, phones);
        phonesList.setAdapter(adapter);

        // обработка установки и снятия отметки в списке
        phonesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем нажатый элемент
                String phone = adapter.getItem(position);
                if(phonesList.isItemChecked(position)==true){
                    selectedPhones.add(phone);
                }
                else{

                    selectedPhones.remove(phone);
                }
            }
        });
    }

    public void add(View view){

        EditText phoneEditText = (EditText) findViewById(R.id.phone);
        String phone = phoneEditText.getText().toString();
        if(!phone.isEmpty() && phones.contains(phone)==false){
            adapter.add(phone);
            phoneEditText.setText("");
            adapter.notifyDataSetChanged();
        }
    }
    public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int i=0; i< selectedPhones.size();i++){
            adapter.remove(selectedPhones.get(i));
        }
        // снимаем все ранее установленные отметки
        phonesList.clearChoices();
        // очищаем массив выбраных объектов
        selectedPhones.clear();

        adapter.notifyDataSetChanged();
    }
}
