package com.erfanatic.datastorageexperiment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by erfan on 16-Aug-16.
 */
public class DbAdapter  {

        DbHelper myDbHelper;

    public DbAdapter(Context context){

        myDbHelper = new DbHelper(context);
    }
    public long insertData(String name, String password){

        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,name);
        contentValues.put(myDbHelper.PASSWORD,password);

        long rowId =db.insert(myDbHelper.TABLE_NAME,null,contentValues);
        return rowId;
    }

    public String getAllData(){

        String[] colums= {myDbHelper.UID,myDbHelper.NAME,myDbHelper.PASSWORD};

        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        Cursor cursor = db.query(myDbHelper.TABLE_NAME,colums,null,null,null,null,null);

        StringBuffer buffer = new StringBuffer();

        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(myDbHelper.UID);
            int id = cursor.getInt(index1);

            int index2 = cursor.getColumnIndex(myDbHelper.NAME);
            String name = cursor.getString(index2);

            int index3 = cursor.getColumnIndex(myDbHelper.PASSWORD);
            String password = cursor.getString(index3);

            buffer.append(id+" "+name+" "+password+"\n");
        }

            return buffer.toString();
    }


   static class DbHelper extends SQLiteOpenHelper{

       private static final String DATABASE_NAME = "myDatabase";
       private static final int DATABASE_VERSION= 15;
       private static final String TABLE_NAME = "myTable";

       private static final String UID = "_id";
       private static final String NAME = "Name";
       private static final String PASSWORD = "Password";

       private static final  String CREATE_TABLE= "CREATE TABLE " +TABLE_NAME+ "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR(255)," + PASSWORD + " VARCHAR(255)"+")";
       private static final String DROP_TABLE = "DROP TABLE IF EXISTS '"+ TABLE_NAME+"'";


       private Context context;

       public DbHelper(Context context){
           super(context,DATABASE_NAME,null,DATABASE_VERSION);
           this.context= context;
           Toast.makeText(context,"Constructor Called",Toast.LENGTH_SHORT).show();
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           try {
               Toast.makeText(context,"on create Called",Toast.LENGTH_SHORT).show();

               db.execSQL(CREATE_TABLE);
               Toast.makeText(context,"Table was Created",Toast.LENGTH_LONG).show();

           }catch (SQLException e){
               Toast.makeText(context,"Table was not Created",Toast.LENGTH_LONG).show();        }
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           Toast.makeText(context,"On Upgrade called",Toast.LENGTH_SHORT).show();

           try{

               db.execSQL(DROP_TABLE);
               Toast.makeText(context,"Table was deleted",Toast.LENGTH_SHORT).show();
               onCreate(db);

           }catch (SQLException e ){
               e.printStackTrace();
           }
       }


   }

}
