package com.example.abhinav.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomeAdapter extends BaseAdapter
{
    Context context;
    String[] counrty_names;
    int[] country_flag;

    public CustomeAdapter(Context context, String[] counrty_names, int[] country_flag) {
        this.context = context;
        this.counrty_names = counrty_names;
        this.country_flag = country_flag;
    }

    @Override
    public int getCount() {
        return counrty_names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row;
        row = inflater.inflate(R.layout.list_item, viewGroup, false);
        TextView txtv_country_name;
        ImageView imgv_flag;


        txtv_country_name = (TextView) row.findViewById(R.id.txtv_country_name);
        imgv_flag = (ImageView) row.findViewById(R.id.imgv_flag);

        txtv_country_name.setText(counrty_names[position]);
        imgv_flag.setImageResource(country_flag[position]);

        return row;
    }

}
