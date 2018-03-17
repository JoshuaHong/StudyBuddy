package com.example.josh.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

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

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        for (int x = 0; x < 3; x ++) {
            Button button = new Button(this);
            button.setText("This is the description sdfsdfsfd." + "\n" +
                    "00:00 - " + "00:00" + "\n" + "2/3" + String.valueOf(x));
            button.setId(x);
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Dynamic button" + v.getId() + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(button);
        }



        scrollView.addView(linearLayout);
    }
}

