package com.example.abhinav.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewCutmAct extends AppCompatActivity
{
    ListView lv_view;

    String[] Name=new String[]{"Deepika Ingavale",
            "Priyanka Latambe","Priyanka Suryawanshi",
            "Manoje Gangurde","Yash Patel"};
    String[] Class=new String[]{"M.Sc.ComputerScience","M.Sc.ComputerScience",
            "M.Sc.ComputerScience","M.Sc.ComputerScience","M.Sc.ComputerScience"};

    int[] Age=new int[]{23,25,22,23,23};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_cutm);

        lv_view=(ListView)findViewById(R.id.lv_view);

        customAdapter customAdapter=new customAdapter(ListViewCutmAct.this,Name,Class,Age);
        lv_view.setAdapter(customAdapter);
    }
}
