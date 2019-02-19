package com.example.abhinav.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {


    Context context;
    ArrayList<ResultBean>arrayList;
    public CustomAdapter(Context context ,ArrayList<ResultBean> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row;
        row = inflater.inflate(R.layout.result_data, viewGroup, false);


        TextView  txt_date,txt_paidamt,txt_billno,txt_expensehead,
                txt_subexphead,txt_approved,txt_billphoto;

        txt_date=(TextView)row.findViewById(R.id.txt_date);
        txt_paidamt=(TextView)row.findViewById(R.id.txt_paidamt);
        txt_billno=(TextView)row.findViewById(R.id.txt_billno);
        txt_expensehead=(TextView)row.findViewById(R.id.txt_expensehead);
        txt_subexphead=(TextView)row.findViewById(R.id.txt_subexphead);
        txt_approved=(TextView)row.findViewById(R.id.txt_approved);
        txt_billphoto=(TextView)row.findViewById(R.id.txt_billphoto);

        txt_date.setText(arrayList.get(i).getDate());
        txt_paidamt.setText(arrayList.get(i).getPaidamt());
        txt_billno.setText(arrayList.get(i).getBillno());
        txt_expensehead.setText(arrayList.get(i).getExphead());
        txt_subexphead.setText(arrayList.get(i).getSubexprate());
        txt_approved.setText(arrayList.get(i).getApproved());
        txt_billphoto.setText(arrayList.get(i).getBillphoto());

        return row;

    }
}
