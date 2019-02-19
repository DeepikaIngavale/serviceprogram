package com.example.abhinav.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_recyclerview=(Button)findViewById(R.id.btn_recyclerview);
        btn_recyclerview.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.btn_recyclerview)
        {
            Intent intent = new Intent(this, NewActivity.class);
            startActivity(intent);
        }
    }

}
