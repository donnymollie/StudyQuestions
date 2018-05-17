package com.example.mollie.bookofmormonstudyquestions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.mollie.bookofmormonstudyquestions.R.id.firstNephi1Link;

/**
 * Created by Mollie on 5/15/2018.
 */

public class firstNephi1  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_nephi1);
        // Find the View that shows the 1Nephich1 Link button
        Button firstNephich1Link = (Button) findViewById(firstNephi1Link);
        // Set a click listener on that View
        firstNephich1Link.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when 1Nephi1Link button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FirstNephiActivity}
                Uri firstNephi1webpage = Uri.parse("https://www.lds.org/scriptures/bofm/1-ne/1.2");
                Intent firstNephi1webIntent = new Intent(Intent.ACTION_VIEW, firstNephi1webpage);
                startActivity(firstNephi1webIntent);
                           }
        });
    }
}
