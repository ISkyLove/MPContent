package lc.mpcontent.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lin on 16-5-23.
 */
public  class DataBaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "mpcontent";

    private String TABLE_NAME;

    private int VERSION =1;

    private String [] mColumns;

    public DataBaseHelper(Context context, String tablename,String [] columns,int version) {
        super(context, DATABASE_NAME, null, version);
        this.TABLE_NAME = tablename;
        this.VERSION = version;
        this.mColumns = columns;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
