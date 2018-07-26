package com.example.mollie.bookofmormonstudyquestions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mollie.bookofmormonstudyquestions.adapter.FirstNephi1Adapter;
import com.example.mollie.bookofmormonstudyquestions.adapter.IsaveQuestionAnswer;
import com.example.mollie.bookofmormonstudyquestions.database.DatabaseHelper;
import com.example.mollie.bookofmormonstudyquestions.model.QuestionAnswer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class firstNephi1 extends AppCompatActivity implements IsaveQuestionAnswer {

    private ListView lvFirstNephi1;
    private FirstNephi1Adapter adapter;
    private List<QuestionAnswer> mQuestionAnswerList;
    private DatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_nephi1);

        lvFirstNephi1 = findViewById(R.id.listview_firstNephi1);
        mDbHelper = new DatabaseHelper(this);

        checkIfDatabaseExists();
//         Get the qa list in db when db exists(t 
        mQuestionAnswerList = mDbHelper.getListFirstNephi1();
//         Set up an Adapter to create a listitem for each row of questions +answers in the cursor 
        adapter = new FirstNephi1Adapter(this, mQuestionAnswerList, this);
        lvFirstNephi1.setAdapter(adapter);


        // Find the View that shows the 1Nephich1 Link button
        Button firstNephich1Link = (Button) findViewById(R.id.webLink);
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

    private void loadSavedAnswersToMap(){
        //load questions and answers into map when the activity starts up
    }

    @Override
    public void saveData(String enteredText) {
        //save data to a map data structure so you know which item to add when the text watcher sends text
        //for this to work you will need to do a few things.
        // - Load the past answers from the database into your map when the activity loads
        // - Find the right map entry by key. Your key in the map will be your question or database id for your question or something unique
        // - Update the map value with whatever text is sent to this method
        // - Do some research on java maps and that will help you understand them

    }

    private void checkIfDatabaseExists() {
//check if database exists 
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if (!database.exists()) {
            mDbHelper.getWritableDatabase();
//         copy database 
            if (copyDatabase(this)) {
                Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.v("FirstNephi1", "DB copied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
