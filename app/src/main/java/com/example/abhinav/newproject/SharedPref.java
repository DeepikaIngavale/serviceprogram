package com.example.abhinav.newproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPref extends AppCompatActivity implements View.OnClickListener {
    EditText etxt_u_name,etxt_u_pass;
    Button btn_save;

    SharedPreferences SAVEPREF;
    String MY_PYERF="cntent_saved";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref2);

        etxt_u_name=(EditText)findViewById(R.id.etxt_u_name);
        etxt_u_pass=(EditText)findViewById(R.id.etxt_u_pass);
        btn_save=(Button)findViewById(R.id.btn_save);

        btn_save.setOnClickListener(this);

        SAVEPREF = getSharedPreferences(MY_PYERF, Context.MODE_PRIVATE);
        String name = SAVEPREF.getString("USER_NAME", "NA");
        //etxt_u_name.setText(name);
        //SAVEPREF = getSharedPreferences(MY_PYERF, Context.MODE_PRIVATE);
        String name1 = SAVEPREF.getString("USER_PASSWRD", "NA");
        //etxt_u_pass.setText(name1);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.btn_save)
        {
            String name2 = etxt_u_name.getText().toString();
            String name3 = etxt_u_pass.getText().toString();
            SharedPreferences.Editor editor = SAVEPREF.edit();
            editor.putString("USER_NAME", name2);
            editor.putString("USER_PASSWRD", name3);
            editor.apply();
        }
    }
}
