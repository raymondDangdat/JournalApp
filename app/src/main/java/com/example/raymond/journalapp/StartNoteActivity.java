package com.example.raymond.journalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartNoteActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_note);
        db = new DatabaseHelper(this);
        e2 = (EditText) findViewById(R.id.title);
        e1 = (EditText) findViewById(R.id.edit);

        b1 = (Button) findViewById(R.id.buttonSave);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean chketitle = db.checktitle(s1);
                    if (chketitle ==true){
                        Boolean insert = db.insert(s1,s2);
                        if (insert == true){
                            Toast.makeText(getApplicationContext(), "Note Saved Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Note with same title exist please change the title", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
