package com.example.mollie.bookofmormonstudyquestions.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mollie.bookofmormonstudyquestions.model.QuestionAnswer;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "bookofmormonquestions.db";
    public static final String DBLOCATION = "/data/data/com.example.mollie.bookofmormonstudyquestions/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase() {
        if (mDatabase!=null) {
            mDatabase.close();
        }
    }
    //get all data entries from database as a list
    public List<QuestionAnswer> getListFirstNephi1() {
        QuestionAnswer questionAnswer = null;
        List<QuestionAnswer> questionAnswerList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM FIRSTNEPHI1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            questionAnswer = new QuestionAnswer(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            questionAnswerList.add(questionAnswer);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        for(int i = 0; i<100; i++) {
            questionAnswer.setAnswer(String.valueOf(i));
            questionAnswerList.add(questionAnswer);
        }
        return questionAnswerList;
    }
}

