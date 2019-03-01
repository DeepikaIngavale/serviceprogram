package com.example.abhinav.newproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelperAct extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "student_details.db";
    public static final int DATABASE_VERSION = 1;
    private Context context;
    SQLiteDatabase db;

    private static final String TABLE_STUDENT_DETAILS = "stud_details";
    private static final String ROLL_NO = "roll_no";
    private static final String FNAME = "fname";
    private static final String LNAME = "lname";
    private static final String MOBILE = "mobile";
    private static final String AGE = "age";
    private static final String BDAY = "birthday";
    private static final String EMAIL = "email";

    public DataBaseHelperAct(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String create_student_details =
                "create table if not exists "+TABLE_STUDENT_DETAILS
                        +"("+ROLL_NO+" integer primary key autoincrement,"
                        +FNAME+" text, "
                        +LNAME+" text, "
                        +MOBILE+" text, "
                        +AGE+" text, "
                        +BDAY+" text, "
                        +EMAIL+" text);";

        // System.out.println(create_student_details);

        sqLiteDatabase.execSQL(create_student_details);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
    }

    public void open() throws SQLException
    {
        db = getWritableDatabase();
    }

    /*-------------------- Your customized methods ----------------------------------*/

    public void no_purpose()
    {
        open();
        System.out.println("okay");
        db.close();
    }

    public long insertStudentDetails(String fname,String lname,String mobile,
                                     String age,String birthday,String email )
    {
        open();

        ContentValues values = new ContentValues();
        values.put(FNAME, fname);
        values.put(LNAME, lname);
        values.put(MOBILE, mobile);
        values.put(AGE, age);
        values.put(BDAY, birthday);
        values.put(EMAIL, email);

        long insertid = db.insert(TABLE_STUDENT_DETAILS, MOBILE, values);

        db.close();

        return insertid;
    }

    public void getAllStudentDetails()
    {
        open();

        String[] columns = new String[]{ROLL_NO, FNAME};

        Cursor c = db.query(TABLE_STUDENT_DETAILS, null, null,
                null, null, null, null);

        int returned_rows = c.getCount();

        if(returned_rows>0) {
            c.moveToFirst();

            do {
                int roll_no_index = c.getColumnIndex(ROLL_NO);
                String roll_no = c.getString(roll_no_index);

                int name_index = c.getColumnIndex(FNAME);
                String name = c.getString(name_index);

                String age = c.getString(c.getColumnIndex(AGE));
                String email = c.getString(c.getColumnIndex(EMAIL));

                System.out.println("Roll_no => " + roll_no + " Name => " + name);
                System.out.println("AGE => " + age + " Email => " + email);
                System.out.println("-----------------------------------");

            } while (c.moveToNext());

        }

        db.close();
    }
}
