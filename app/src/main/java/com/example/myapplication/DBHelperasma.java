package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperasma extends SQLiteOpenHelper
{
    public static final String DATABASENAME = "AsmaDb";
    public static final String TABLENAME = "SportItem";
    public static final String COLL_1 = "PRODUCTT";
    public static final String COLL_2 = "PRODUCT";
    public static final String COLL_3 = "TOTAL";
    public static final String COLL_4 = "COST";

    public DBHelperasma(Context context) {

        super(context, DATABASENAME, null, 1);
    }

    public void onCreate(SQLiteDatabase dbb) {
        String stg = "create table " + TABLENAME + "(" + COLL_1 + "text," + COLL_2 + "text," + COLL_3 + "INTEGER," + COLL_4 + "INTEGER)";
        dbb.execSQL(stg);
    }

    public void onUpgrade(SQLiteDatabase dbb, int oldVersion, int newVersion) {
        dbb.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
    }

    public boolean insertData(String PRODUCTT, String PRODUCT, String TOTAL)
    {
        SQLiteDatabase dbe=this.getWritableDatabase();
        ContentValues cvvv=new ContentValues();
        cvvv.put(COLL_1,PRODUCTT);
        cvvv.put(COLL_2,PRODUCT);
        cvvv.put(COLL_3,TOTAL);

        long result=dbe.insert(TABLENAME,null,cvvv);
        if(result==1)
            return false;
        else
            return true;
    }
    public Integer deleteData(String PRODUCTT,String PRODUCT)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLENAME,"prodct1=? prodct2=?",new String[]{PRODUCTT,PRODUCT});
    }

    public boolean updateData(String PRODUCTT,String PRODUCT,String TOTAL)
    {
        SQLiteDatabase dbbe=this.getWritableDatabase();
        ContentValues cvt=new ContentValues();
        cvt.put(COLL_1,PRODUCTT);
        cvt.put(COLL_2,PRODUCT);
        cvt.put(COLL_3,TOTAL);


        dbbe.update(TABLENAME,cvt,"prodct1=? prodct2=?",new String[] {PRODUCTT,PRODUCT});
        return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase dbbe=this.getWritableDatabase();
        Cursor rre=dbbe.rawQuery("select * from " +TABLENAME,null);
        return rre;

    }


}
