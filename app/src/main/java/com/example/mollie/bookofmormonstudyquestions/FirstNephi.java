package com.example.mollie.bookofmormonstudyquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirstNephi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_nephi);
        // Find the View that shows the 1Nephi button
    Button firstNephich1 = (Button) findViewById(R.id.firstNephich1);
    // Set a click listener on that View
        firstNephich1.setOnClickListener(new View.OnClickListener() {
        // The code in this method will be executed when 1Nephi button is clicked on.
        @Override
        public void onClick(View view) {
            // Create a new intent to open the {@link FirstNephi1Activity}
            Intent firstNephi1Intent = new Intent(FirstNephi.this, firstNephi1.class);
            // Start the new activity
            startActivity(firstNephi1Intent);
        }
    });
}

}
