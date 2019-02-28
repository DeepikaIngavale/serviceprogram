package com.example.abhinav.newproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main_R2Activity extends AppCompatActivity
{
    ArrayList<ResultBean> arrayList;
    Custom_R_Adapter customAdapter;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__r2);
        arrayList = new ArrayList<>();

        db = new DataBaseHelper(Main_R2Activity.this);
        arrayList=db.getResultDetails();

        if(arrayList.size()>0)
        {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

        /*StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);*/

            customAdapter =new Custom_R_Adapter(Main_R2Activity.this,arrayList);
            recyclerView.setAdapter(customAdapter);
        }
    }
}
