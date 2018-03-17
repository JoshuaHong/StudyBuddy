package com.example.josh.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                startActivity(intent);
            }
        });
        ArrayList<studyEvent> studyEvents = new ArrayList<studyEvent>();

        studyEvents.add(new studyEvent(5,5,"gr",3,3,"fefe"));
        studyEventAdapter eventAdapters = new studyEventAdapter(this,studyEvents);
        ListView liste = (ListView) findViewById(R.id.List);
        liste.setAdapter(eventAdapters);
    }
}
