package com.example.abhinav.newproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "test_service2.db";
    public static final int DATABASE_VERSION = 2;

    Context context;
    SQLiteDatabase db;

    private static final String TABLE_REULT_DETAILS = "ResultsDetails";
    private static final String id = "id";
    private static final String date = "date";
    private static final String paidamt = "paidamt";
    private static final String billno = "billno";
    private static final String exphead = "mobno";
    private static final String subexpheadrate = "subexpheadrate";
    private static final String approved = "approved";
    private static final String billphoto = "billphoto";
    private static final String rate = "rate";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_result_details =
                " create table if not exists " + TABLE_REULT_DETAILS + "(" + id + " integer primary key autoincrement, "
                        + date + " text,"
                        + paidamt + " text,"
                        + billno + " text,"
                        + exphead + " text,"
                        + subexpheadrate + " text,"
                        + approved + " text,"
                        + rate + " text,"
                        + billphoto + " text);";

        sqLiteDatabase.execSQL(create_result_details);
        Log.i("Table Created","ResultsDetails");
    }

    public void createTable() {
        open();
        Toast.makeText(context, "" + db.getPath(), Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void open() throws SQLException {
        db = getWritableDatabase();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertResultData(ArrayList<ResultBean> arrayList)
    {
        open();
       long l=0;
        for (int i = 0; i < arrayList.size(); i++)
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put(date,arrayList.get(i).getDate());
            contentValues.put(paidamt,arrayList.get(i).getPaidamt());
            contentValues.put(billno,arrayList.get(i).getBillno());
            contentValues.put(exphead,arrayList.get(i).getExphead());
            contentValues.put(subexpheadrate,arrayList.get(i).getSubexprate());
            contentValues.put(approved,arrayList.get(i).getApproved());
            contentValues.put(rate,arrayList.get(i).getRate());
            contentValues.put(billphoto,arrayList.get(i).getBillphoto());


            //if (l>0)
            {
                l = db.insert(TABLE_REULT_DETAILS, null, contentValues);
            }
        }
        db.close();
        return l;
    }
    public ArrayList<ResultBean>getResultDetails()
    {
        open();
        ArrayList<ResultBean>arrayList=new ArrayList<>();
        arrayList.clear();
        Cursor cursor=db.query(TABLE_REULT_DETAILS,null,null,null,
                null,null,null);
        if (cursor!=null)
        {
            if (cursor.getCount()>0)
            {
                cursor.moveToFirst();
            }
            do {
                    try
                    {
                        ResultBean resultBean=new ResultBean();
                        resultBean.setDate(cursor.getString(cursor.getColumnIndex(date)));
                        resultBean.setPaidamt(cursor.getString(cursor.getColumnIndex(paidamt)));
                        resultBean.setBillno(cursor.getString(cursor.getColumnIndex(billno)));
                        resultBean.setExphead(cursor.getString(cursor.getColumnIndex(exphead)));
                        resultBean.setSubexprate(cursor.getString(cursor.getColumnIndex(subexpheadrate)));
                        resultBean.setApproved(cursor.getString(cursor.getColumnIndex(approved)));
                        resultBean.setRate(cursor.getString(cursor.getColumnIndex(rate)));
                        resultBean.setBillphoto(cursor.getString(cursor.getColumnIndex(billphoto)));

                        arrayList.add(resultBean);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
            }while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}

