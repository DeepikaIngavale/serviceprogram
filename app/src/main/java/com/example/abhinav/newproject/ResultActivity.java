package com.example.abhinav.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity
{
    ListView list_view;
    DataBaseHelper db;
    ArrayList<ResultBean>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        db=new DataBaseHelper(ResultActivity.this);
        arrayList=new ArrayList<>();
        list_view=(ListView)findViewById(R.id.list_view);
        arrayList=db.getResultDetails();
        CustomAdapter customAdapter=new CustomAdapter(ResultActivity.this,arrayList);
        list_view.setAdapter(customAdapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(ResultActivity.this, ""+arrayList, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
