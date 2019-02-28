package com.example.abhinav.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity
{
    ListView listv_names;

    String[] country_names = new String[]{"India", "America", "Japan","Australia", "Africa"};
    int [] country_flags = new int[]{R.drawable.india_flag,R.drawable.america_flag,R.drawable.flag_japan,
            R.drawable.australia_icon,R.drawable.south_africa};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listv_names = (ListView) findViewById(R.id.listv_names);

        CustomeAdapter customeAdapter = new CustomeAdapter(ListViewActivity.this,country_names,country_flags);
        listv_names.setAdapter(customeAdapter);
    }
}
