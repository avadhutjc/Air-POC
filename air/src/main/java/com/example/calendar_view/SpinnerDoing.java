package com.example.calendar_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerDoing extends AppCompatActivity {

    String[] names = {"item1", "item2"};
    String[] des = {"item1 from one", "item2 from two"};
    ArrayAdapter<String> adapter;
    Spinner sp;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_doing);

        sp = (Spinner) findViewById(R.id.spinners_show_doing);
        description = (TextView) findViewById(R.id.tv1);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);

        sp.setAdapter(adapter);

//        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                final Intent intent;
//                switch (position) {
//                    case 1:
//                        intent = new Intent(Main2Activity.this, MainhomeActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 2:
//                        intent = new Intent(Main2Activity.this, DateActivity.class);
//                        startActivity(intent);
//                        break;
//                }
//
//            }

    }
}