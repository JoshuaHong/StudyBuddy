package com.example.josh.studybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add extends AppCompatActivity {

    private Button firebaseButton;
    private DatabaseReference database;
    private String description, from, to, location, name;
    private int number;
    private EditText descriptionInput, fromInput, toInput, locationInput, nameInput, numberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        firebaseButton = (Button) findViewById(R.id.submit);
        database = FirebaseDatabase.getInstance().getReference("Users");
        descriptionInput = (EditText) findViewById(R.id.description);
        fromInput = (EditText) findViewById(R.id.from);
        toInput = (EditText) findViewById(R.id.to);
        locationInput = (EditText) findViewById(R.id.location);
        nameInput = (EditText) findViewById(R.id.name);
        numberInput = (EditText) findViewById(R.id.number);

        firebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

                description = descriptionInput.getText().toString();
                from = fromInput.getText().toString();
                to = toInput.getText().toString();
                location = locationInput.getText().toString();
                name = nameInput.getText().toString();
                number = Integer.valueOf(numberInput.getText().toString());

                database.child("Description").setValue(description);
                database.child("from").setValue(from);
                database.child("to").setValue(to);
                database.child("location").setValue(location);
                database.child("name").setValue(name);
                database.child("number").setValue(number);
            }
        });
    }
}
