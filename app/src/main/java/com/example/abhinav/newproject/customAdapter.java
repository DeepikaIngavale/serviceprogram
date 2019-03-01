package com.example.abhinav.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class customAdapter extends BaseAdapter
{
    Context context;
    String[] Name,Class;
    int[] Age;

    public customAdapter(Context context, String[] Name, String[] Class ,int[] Age)
    {
        this.context = context;
        this.Name = Name;
        this.Class = Class;
        this.Age=Age;
    }

    @Override
    public int getCount()
    {
        return Name.length;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int positn, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflatr=LayoutInflater.from(context);
        View details;
        details=inflatr.inflate(R.layout.item_show, viewGroup,false);
        TextView txtv_name,txtv_class,txtv_age;

        txtv_name=(TextView)details.findViewById(R.id.txtv_name);
        txtv_class=(TextView)details.findViewById(R.id.txtv_class);
        txtv_age=(TextView)details.findViewById(R.id.txtv_age);

        txtv_name.setText(Name[positn]);
        txtv_class.setText(Class[positn]);
        txtv_age.setText(""+Age[positn]);

        return details;
    }
}
