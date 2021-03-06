package com.example.josh.studybuddy;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Add extends AppCompatActivity {

    private Button firebaseButton;
    private DatabaseReference database, dataCounter;
    private String description, from, to, location, name;
    private int number, counter;
    private EditText descriptionInput, fromInput, toInput, locationInput, nameInput, numberInput;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dataCounter = FirebaseDatabase.getInstance().getReference("Counter");
        firebaseButton = (Button) findViewById(R.id.submit);
        database = FirebaseDatabase.getInstance().getReference("events");
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

                if (numberInput.getText().toString().matches("")) {
                    number = 2;
                } else {
                    number = Integer.valueOf(numberInput.getText().toString());
                }

                if (description == null) {
                    description = " ";
                }
                if (from == null) {
                    from = " ";
                }
                if (to == null) {
                    to = " ";
                }
                if (location == null) {
                    location = " ";
                }
                if (name == null) {
                    name = " ";
                }
                if (number < 2) {
                    number = 2;
                }

                dataCounter.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (flag) {
                            counter = dataSnapshot.getValue(int.class);
                            String count = Integer.toString(counter);
                            counter++;
                            flag = false;
                            dataCounter.setValue(counter);
                            DatabaseReference datalist = database.child(count);
                            // private DatabaseReference databasex = database.child();
                            datalist.child("desc").setValue(description);
                            datalist.child("begin_time").setValue(from);
                            datalist.child("end_time").setValue(to);
                            datalist.child("location").setValue(location);
                            datalist.child("Name").setValue(name);
                            datalist.child("max_ppl").setValue(number);
                            datalist.child("cur_ppl").setValue(1);

                            Intent intent = new Intent(Add.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
