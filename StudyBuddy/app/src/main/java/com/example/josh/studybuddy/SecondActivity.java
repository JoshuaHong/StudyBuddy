package com.example.josh.studybuddy;

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

public class SecondActivity extends AppCompatActivity {

    private Button firebaseButton;
    private DatabaseReference database,userCount;
    private String message, name;
    private int number,counter, id;
    private EditText messageInput, nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        id = 0;

        userCount = FirebaseDatabase.getInstance().getReference("events/"+id+"/cur_ppl");
        firebaseButton = (Button) findViewById(R.id.button2);
        database = FirebaseDatabase.getInstance().getReference("events/"+id+"/users");
        messageInput = (EditText) findViewById(R.id.message);
        nameInput = (EditText) findViewById(R.id.name);

        firebaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                message = messageInput.getText().toString();
                name = nameInput.getText().toString();

                userCount.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        counter = dataSnapshot.getValue(int.class);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                String count = Integer.toString(counter);
                counter++;
                userCount.setValue(counter);
                DatabaseReference datalist = database.child(count);
                // private DatabaseReference databasex = database.child();
                datalist.child("message").setValue(message);
                datalist.child("name").setValue(name);
            }

        });

    }
}
