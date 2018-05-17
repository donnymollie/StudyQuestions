package com.example.mollie.bookofmormonstudyquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the View that shows the 1Nephi button
        Button firstNephi = (Button) findViewById(R.id.firstNephi);
        // Set a click listener on that View
        firstNephi.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when 1Nephi button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FirstNephiActivity}
                Intent firstNephiIntent = new Intent(MainActivity.this, FirstNephi.class);
                // Start the new activity
                startActivity(firstNephiIntent);
            }
        });
    }
}
