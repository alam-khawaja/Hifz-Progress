package com.example.hifztracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class EntryForm extends AppCompatActivity {
    EditText etStudentID, etName, etAge, etClas, etSabaq, etSabqi, etManzil;
    Button btnSave;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        etStudentID = findViewById(R.id.et_student_roll);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etClas = findViewById(R.id.et_clas);
        etSabaq = findViewById(R.id.et_sabaq);
        etSabqi = findViewById(R.id.et_sabqi);
        etManzil = findViewById(R.id.et_manzil);
        btnSave = findViewById(R.id.btn_save);

        db = new DbHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = etStudentID.getText().toString();
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String clas = etClas.getText().toString();
                String sabaq = etSabaq.getText().toString();
                String sabqi = etSabqi.getText().toString();
                String manzil = etManzil.getText().toString();

                if (name.isEmpty()) {
                    // Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    // return;
                }

                Student student = new Student(name, age, clas, sabaq, sabqi, manzil,roll);
                db.insertStudent(student);
            }
        });
    }
}
