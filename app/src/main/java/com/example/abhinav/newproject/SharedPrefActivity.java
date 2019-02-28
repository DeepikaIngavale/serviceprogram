package com.example.abhinav.newproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etxt_login,etxt_passwrd;
    Button btn_signin,btn_fpass,btn_savecnt,btn_list;

    SharedPreferences SAVEPREF;
    String MY_PYERF="cntent_saved";
    String user_name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        System.out.println("******************** on Create called");

        etxt_login=(EditText)findViewById(R.id.etxt_login);
        etxt_passwrd=(EditText)findViewById(R.id.etxt_passwrd);
        btn_signin=(Button) findViewById(R.id.btn_signin);
        btn_fpass=(Button) findViewById(R.id.btn_fpass);
        btn_savecnt=(Button) findViewById(R.id.btn_savecnt);
        btn_list = (Button) findViewById(R.id.btn_list);

        SAVEPREF = getSharedPreferences(MY_PYERF, Context.MODE_PRIVATE);

        btn_savecnt.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
        btn_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId()==R.id.btn_savecnt)
        {
            Intent intent=new Intent(SharedPrefActivity.this,SharedPref.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.btn_signin)
        {
            String entered_username = etxt_login.getText().toString();
            String entered_password = etxt_passwrd.getText().toString();

            if(entered_username.equals(user_name))
            {
                Toast.makeText(this,""+getResources().getString(R.string.u_true),Toast.LENGTH_SHORT).show();
            }
            if(entered_password.equals(password))
            {
                Toast.makeText(this,""+getResources().getString(R.string.u_true_pass),Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        System.out.println("********************First activity in onPause");
    }

    @Override
    protected void onResume()
    {
        System.out.println("********************On Resume called");
        super.onResume();
        user_name = SAVEPREF.getString("USER_NAME", "NA");
        password = SAVEPREF.getString("USER_PASSWRD", "NA");
    }
}
