package com.example.db1;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase myDB;
    EditText txtFname, txtLname, txtCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);
        myDB = helper.getWritableDatabase();
        txtFname = findViewById(R.id.editText);
        txtLname = findViewById(R.id.editText2);
        txtCourse = findViewById(R.id.editText3);
    }

    public void addRecord(View v) {
        String fname = txtFname.getText().toString();
        String lname = txtLname.getText().toString();
        String course = txtCourse.getText().toString();
        long isInserted = helper.insertData(fname, lname, course);
        if(isInserted == -1) {
            Toast.makeText(this, "data not saved", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "data successfully saved", Toast.LENGTH_LONG).show();
        }
        //myDB.close();
    }
}
