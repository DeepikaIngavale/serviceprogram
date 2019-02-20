package com.example.abhinav.newproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main_RActivity extends AppCompatActivity
{
    DataBaseHelper db;
    ArrayList<ResultBean> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainr);
        db = new DataBaseHelper(Main_RActivity.this);
        arrayList = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId()==R.id.menu_download)
        {
            downloadResult();
        }
        if(item.getItemId()==R.id.menu_display)
        {
            Intent intent=new Intent(this,Main_R2Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void downloadResult()
    {
        String url = "http://json.ezeetest.in//EZEETestService.svc/DownloadExpencePara?LogIn_No=9527787842";
        arrayList = new ArrayList<>();

        final ProgressDialog progressDialog=new ProgressDialog(Main_RActivity.this);
        progressDialog.setMessage("Download Result");
        progressDialog.setTitle("Result");
        progressDialog.setCancelable(true);
        progressDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(Main_RActivity.this);

        StringRequest jsonObjectRequest;
        jsonObjectRequest = new StringRequest(Request.Method.GET,url,new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                progressDialog.dismiss();
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("DownloadExpenceParaResult");

                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject object = jsonArray.getJSONObject(i);

                        String date = object.getString("Date");
                        String paid_amount = object.getString("paid_Amount");
                        String bill_no = object.getString("Bill_no");
                        String expence_head = object.getString("Expence_Head");
                        String subExpence_head = object.getString("SubExpence_Head");
                        String approved = object.getString("Approved");
                        String bill_photo = object.getString("Bill_Photo");


                        ResultBean resultBean = new ResultBean();
                        resultBean.setDate(date);
                        resultBean.setPaidamt(paid_amount);
                        resultBean.setBillno(bill_no);
                        resultBean.setExphead(expence_head);
                        resultBean.setSubexprate(subExpence_head);
                        resultBean.setApproved(approved);
                        resultBean.setBillphoto(bill_photo);

                        arrayList.add(resultBean);
                    }
                    db.insertResultData(arrayList);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Main_RActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
