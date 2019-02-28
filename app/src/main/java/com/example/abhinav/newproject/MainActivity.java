package com.example.abhinav.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_recyclerview,btn_recyclerviewdemo,btn_lifecycle,btn_sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_recyclerview=(Button)findViewById(R.id.btn_recyclerview);
        btn_recyclerviewdemo=(Button)findViewById(R.id.btn_recyclerviewdemo);
        btn_lifecycle=(Button)findViewById(R.id.btn_lifecycle);
        btn_sharedPref=(Button)findViewById(R.id.btn_sharedPref);

        btn_recyclerview.setOnClickListener(this);
        btn_recyclerviewdemo.setOnClickListener(this);
        btn_lifecycle.setOnClickListener(this);
        btn_sharedPref.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.btn_recyclerview)
        {
            Intent intent = new Intent(this, NewActivity.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.btn_recyclerviewdemo)
        {
            Intent intent = new Intent(this, Main_RActivity.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.btn_lifecycle)
        {
            Intent intent = new Intent(this, LifeCycleDemo.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.btn_sharedPref)
        {
            Intent intent = new Intent(this, SharedPrefActivity.class);
            startActivity(intent);
        }
    }
}
