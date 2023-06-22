package com.example.hifztracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditStudent extends AppCompatActivity {

    EditText etRoll, etName, etAge, etClas, etSabaq, etSabqi, etManzil;
    Button btnEdit;
    DbHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        etRoll = findViewById(R.id.et_student_roll);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etClas = findViewById(R.id.et_clas);
        etSabaq = findViewById(R.id.et_sabaq);
        etSabqi = findViewById(R.id.et_sabqi);
        etManzil = findViewById(R.id.et_manzil);

        btnEdit = findViewById(R.id.btn_edit);

        db = new DbHelper(this);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = etRoll.getText().toString();
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String clas = etClas.getText().toString();
                String sabaq = etSabaq.getText().toString();
                String sabqi = etSabqi.getText().toString();
                String manzil = etManzil.getText().toString();

                if (roll.isEmpty() || name.isEmpty() || age.isEmpty() || clas.isEmpty() || sabaq.isEmpty() || sabqi.isEmpty() || manzil.isEmpty()) {
                    // Handle empty fields or show a message to the user
                    return;
                }

                Student student = new Student(name, age, clas, sabaq, sabqi, manzil,roll);
                db.updateStudent(student);

                // Optionally, you can show a success message or perform any other desired actions
                // Toast.makeText(EditStudent.this, "Student updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
