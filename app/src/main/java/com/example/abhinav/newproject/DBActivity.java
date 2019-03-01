package com.example.abhinav.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText etxt_fname, etxt_lname, etxt_mono, etxt_age, etxt_bdate, etxt_email;
    Button btn_save;

    DataBaseHelperAct db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        db = new DataBaseHelperAct(DBActivity.this);

        etxt_fname = (EditText) findViewById(R.id.etxt_fname);
        etxt_lname = (EditText) findViewById(R.id.etxt_lname);
        etxt_mono = (EditText) findViewById(R.id.etxt_mono);
        etxt_age = (EditText) findViewById(R.id.etxt_age);
        etxt_bdate = (EditText) findViewById(R.id.etxt_bdate);
        etxt_email = (EditText) findViewById(R.id.etxt_email);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        db.getAllStudentDetails();
    }
    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.btn_save)
        {
            String fname = etxt_fname.getText().toString().trim();
            String lname = etxt_lname.getText().toString().trim();
            String mobile = etxt_mono.getText().toString().trim();
            String age = etxt_age.getText().toString().trim();
            String bday = etxt_bdate.getText().toString().trim();
            String email = etxt_email.getText().toString().trim();


            long insert_id = db.insertStudentDetails(fname, lname, mobile, age, bday, email);

            if(insert_id>0)
            {
                Toast.makeText(this, "insert_success", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
