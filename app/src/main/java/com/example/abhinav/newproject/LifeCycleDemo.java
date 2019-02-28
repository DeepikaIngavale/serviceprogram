package com.example.abhinav.newproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LifeCycleDemo extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_demo);

        Context context=getApplicationContext();
        CharSequence text="Create Method";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context,text,duration);
        toast.show();
    }
    protected void onStart()
    {
        super.onStart();

        //setContentView(R.layout.activity_main);


        Context context=getApplicationContext();
        CharSequence text="Start Method";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context,text,duration);
        toast.show();


    }
    protected void onPause()
    {
        super.onPause();

        //setContentView(R.layout.activity_main);


        Context context=getApplicationContext();
        CharSequence text="Pause Method";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context,text,duration);
        toast.show();


    }
    @Override
    protected void onResume()
    {

        super.onResume();

        Context context=getApplicationContext();
        CharSequence text="Resume Method";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context,text,duration);
        toast.show();


    }
    protected void onStop()
    {

        super.onStop();

        setContentView(R.layout.activity_main);


        Context context=getApplicationContext();
        CharSequence text="Stop Mehtod";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context,text,duration);
        toast.show();

    }
    protected void onDestroy()
    {
        super.onDestroy();
        setContentView(R.layout.activity_main);
        Context context=getApplicationContext();
        CharSequence text="Destroy Method";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(context,text,duration);
        toast.show();

    }
}
