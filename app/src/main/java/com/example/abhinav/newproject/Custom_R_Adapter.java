package com.example.abhinav.newproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Custom_R_Adapter extends RecyclerView.Adapter<Custom_R_Adapter.MyViewHolder>
{
    ArrayList<ResultBean> arrayList;
    Context context;

    public Custom_R_Adapter( Context context,ArrayList<ResultBean> arrayList)
    {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        if(position%2==0)
        {
            holder.layout_parent.setBackgroundColor(Color.GRAY);
        }
        else
        {
            holder.layout_parent.setBackgroundColor(Color.WHITE);
        }
        holder.txtv_date.setText(arrayList.get(position).getDate());
        holder.txtv_paidamt.setText(arrayList.get(position).getPaidamt());
        holder.txtv_billno.setText(arrayList.get(position).getBillno());
        holder.txtv_expencehead.setText(arrayList.get(position).getExphead());
        holder.txtv_subexpencehead.setText(arrayList.get(position).getSubexprate());
        holder.txtv_rate.setText(arrayList.get(position).getRate());
        holder.txtv_approved.setText(arrayList.get(position).getApproved());
        if(arrayList.get(position).getApproved().equals("0"))
        {
            holder.txtv_approved.setText("pendding");
        }
        else
        {
            holder.txtv_approved.setText("approved");
        }
        Bitmap image = StringToBitMap(arrayList.get(position).getBillphoto());

        holder.imgv_download.setImageBitmap(image);

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // display a toast with person name on item click
                Toast.makeText(context, ""+arrayList.get(position), Toast.LENGTH_SHORT).show();
                //Toast.makeText(context, ""+personImages.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static Bitmap StringToBitMap(String encodedString)
    {
        try {
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e)
        {
            e.getMessage();
            return null;
        }
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtv_date,txtv_paidamt,txtv_billno,txtv_expencehead,txtv_subexpencehead,txtv_rate,txtv_approved;
        ImageView imgv_download;
        LinearLayout layout_parent;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            // get the reference of item view's
            layout_parent=(LinearLayout)itemView.findViewById(R.id.layout_parent);
            txtv_date = (TextView) itemView.findViewById(R.id.txtv_date);
            txtv_paidamt = (TextView) itemView.findViewById(R.id.txtv_paidamt);
            txtv_billno = (TextView) itemView.findViewById(R.id.txtv_billno);
            txtv_expencehead = (TextView) itemView.findViewById(R.id.txtv_expencehead);
            txtv_subexpencehead = (TextView) itemView.findViewById(R.id.txtv_subexpencehead);
            txtv_rate = (TextView) itemView.findViewById(R.id.txtv_rate);
            txtv_approved = (TextView) itemView.findViewById(R.id.txtv_approved);
            imgv_download=(ImageView)itemView.findViewById(R.id.imgv_download);
        }
    }
}
