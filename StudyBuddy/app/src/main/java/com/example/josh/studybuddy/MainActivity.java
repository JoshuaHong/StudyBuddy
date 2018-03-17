package com.example.josh.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private boolean flag = true;
    private DatabaseReference dataCounter = FirebaseDatabase.getInstance().getReference("Counter");
    private int counter;
    private int one, two;

    private LinearLayout linearLayout;
    private ScrollView scrollView;

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

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        dataCounter.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (flag) {
                    counter = dataSnapshot.getValue(int.class);
                    flag = false;
                    dataCounter.setValue(counter);

                    for (int x = 0; x < counter; x++) {

                        final Button button = new Button(MainActivity.this);

                        DatabaseReference val = FirebaseDatabase.getInstance().getReference("events/" + x + "/desc");
                        val.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        DatabaseReference valx = FirebaseDatabase.getInstance().getReference("events/" + x + "/begin_time");
                        valx.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(button.getText() + "\n From: " + dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        DatabaseReference valk = FirebaseDatabase.getInstance().getReference("events/" + x + "/end_time");
                        valk.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(button.getText() + "\n" + "To: " + dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        DatabaseReference vald = FirebaseDatabase.getInstance().getReference("events/" + x + "/location");
                        vald.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(button.getText() + "\n" + dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        DatabaseReference valn = FirebaseDatabase.getInstance().getReference("events/" + x + "/Name");
                        valn.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(button.getText() + "\n Name: " + dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        DatabaseReference vala = FirebaseDatabase.getInstance().getReference("events/" + x + "/cur_ppl");
                        vala.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(button.getText() + "\n Current # of people: " + dataSnapshot.getValue().toString());
                                two = Integer.valueOf(dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        DatabaseReference valq = FirebaseDatabase.getInstance().getReference("events/" + x + "/max_ppl");
                        valq.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                button.setText(button.getText() + "\n Max people: " + dataSnapshot.getValue().toString());
                                two = Integer.valueOf(dataSnapshot.getValue().toString());
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        linearLayout.addView(button);
                    }
                    scrollView.addView(linearLayout);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
