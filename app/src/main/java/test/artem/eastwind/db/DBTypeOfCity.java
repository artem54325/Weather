package test.artem.eastwind.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.typeOfCity.BigOfCity;
import test.artem.eastwind.typeOfCity.MiddleOfCity;
import test.artem.eastwind.typeOfCity.SmallOfCity;
import test.artem.eastwind.typeOfCity.Type;

public class DBTypeOfCity {
    DBHelper dbHelper;

    public DBTypeOfCity(Context context) {
        dbHelper = new DBHelper(context);
    }

    public Type getType(String cityName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("mytable", null, null, null, null, null,null);
        Type type = null;
        try {
            if (cursor.moveToFirst()) {
                do {
                    if (cursor.getString(0).equals(cityName)){
                        if (cursor.getString(1).equals(new BigOfCity().getTypeSave())){
                            return new BigOfCity();
                        }else if (cursor.getString(1).equals(new MiddleOfCity().getTypeSave())){
                            return new MiddleOfCity();
                        }else{
                            return new SmallOfCity();
                        }
                    }
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void addTypeOfCity(String cityName, Type type){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id", cityName);
        cv.put("type", type.getTypeSave());

        if (getType(cityName)==null) {
            db.insert("mytable", null, cv);
        }else {
            db.update("mytable", cv, "id = ?",
                    new String[] { cityName });
        }

        db.close();
    }

    public void close(){
        dbHelper.close();
    }

    public void remove(String nameCity) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("mytable", "id = '"+nameCity+"'", null);
    }


    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "DBTypeOfCity", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table mytable ("
                    + "id text primary key,"
                    + "type text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
