package com.programmerjavac.programmer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    public static final int DB_VERSION= 1;
    public static final String DB_NAME="test.db";
    public static final String CREATE_TABLE_USER="CREATE TABLE user (username VARCHAR(20) PRIMARY KEY,password VARCHAR(20));";

    public DBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
    }

    public boolean checkUser(String username,String password)
    {
        boolean success=false;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        if (sqLiteDatabase!=null)
        {
            String sql="SELECT * FROM user WHERE username='" + username + "'AND password='" + password +"';";

            Cursor cursor=sqLiteDatabase.rawQuery(sql,null);

            if (cursor!=null && cursor.getCount()==1)
            {
                success=true;
                cursor.close();
            }
            sqLiteDatabase.close();
        }
        return success;
    }
    public boolean saveUser(String username,String password)
    {
        boolean success=false;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        if (sqLiteDatabase!=null)
        {
            ContentValues contentValues=new ContentValues();
            contentValues.put("username",username);
            contentValues.put("password",password);

            try
            {
                sqLiteDatabase.insertOrThrow(
                        "user",
                null,
                        contentValues);
                success=true;
            }
            catch (Exception e)
            {
                /*ignored*/
            }
            finally
            {
                sqLiteDatabase.close();
            }
        }
        return success;
    }


}
