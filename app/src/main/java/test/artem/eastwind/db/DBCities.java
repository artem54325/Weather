package test.artem.eastwind.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.model.Temperature;


public class DBCities {
    DBCities.DBHelper dbHelper;

    public DBCities(Context context) {
        dbHelper = new DBCities.DBHelper(context);
    }

    public void addCityModel(CityModel model){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id", model.getCityName());

        cv.put("january", model.getTemperature().getJanuary());
        cv.put("february", model.getTemperature().getFebruary());
        cv.put("march", model.getTemperature().getMarch());
        cv.put("april", model.getTemperature().getApril());
        cv.put("may", model.getTemperature().getMay());
        cv.put("june", model.getTemperature().getJune());
        cv.put("july", model.getTemperature().getJuly());
        cv.put("august", model.getTemperature().getAugust());
        cv.put("september", model.getTemperature().getSeptember());
        cv.put("october", model.getTemperature().getOctober());
        cv.put("november", model.getTemperature().getNovember());
        cv.put("december", model.getTemperature().getDecember());
        if (getCity(model.getCityName())==null) {
            db.insert("mytable", null, cv);
        }else {
            db.update("mytable", cv, "id = ?",
                    new String[] { model.getCityName() });
        }
    }

    public CityModel getCity(String cityName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("mytable", null, null, null, null, null,null);
        CityModel model = new CityModel();
        try {
            if (cursor.moveToFirst()) {
                do {
                    if (cursor.getString(0).equals(cityName)){
                        model.setCityName(cursor.getString(0));

                        model.getTemperature().setJanuary(cursor.getDouble(1));
                        model.getTemperature().setFebruary(cursor.getDouble(2));
                        model.getTemperature().setMarch(cursor.getDouble(3));
                        model.getTemperature().setApril(cursor.getDouble(4));
                        model.getTemperature().setMay(cursor.getDouble(5));
                        model.getTemperature().setJune(cursor.getDouble(6));
                        model.getTemperature().setJuly(cursor.getDouble(7));
                        model.getTemperature().setAugust(cursor.getDouble(8));
                        model.getTemperature().setSeptember(cursor.getDouble(9));
                        model.getTemperature().setOctober(cursor.getDouble(10));
                        model.getTemperature().setNovember(cursor.getDouble(11));
                        model.getTemperature().setDecember(cursor.getDouble(12));

                        break;
                    }
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        if (model.getCityName()==null)return null;
        return model;
    }

    public List<CityModel> getAllCities(){
        List<CityModel> list = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("mytable", null, null, null, null, null,null);
        CityModel model = new CityModel();
        try {
            if (cursor.moveToFirst()) {
                do {
                    model.setCityName(cursor.getString(0));

                    model.getTemperature().setJanuary(cursor.getDouble(1));
                    model.getTemperature().setFebruary(cursor.getDouble(2));
                    model.getTemperature().setMarch(cursor.getDouble(3));
                    model.getTemperature().setApril(cursor.getDouble(4));
                    model.getTemperature().setMay(cursor.getDouble(5));
                    model.getTemperature().setJune(cursor.getDouble(6));
                    model.getTemperature().setJuly(cursor.getDouble(7));
                    model.getTemperature().setAugust(cursor.getDouble(8));
                    model.getTemperature().setSeptember(cursor.getDouble(9));
                    model.getTemperature().setOctober(cursor.getDouble(10));
                    model.getTemperature().setNovember(cursor.getDouble(11));
                    model.getTemperature().setDecember(cursor.getDouble(12));

                    /*model.getTemperature().setJanuary(Double.valueOf(cursor.getString(1)));
                    model.getTemperature().setFebruary(Double.valueOf(cursor.getString(2)));
                    model.getTemperature().setMarch(Double.valueOf(cursor.getString(3)));
                    model.getTemperature().setApril(Double.valueOf(cursor.getString(4)));
                    model.getTemperature().setMay(Double.valueOf(cursor.getString(5)));
                    model.getTemperature().setJune(Double.valueOf(cursor.getString(6)));
                    model.getTemperature().setJuly(Double.valueOf(cursor.getString(7)));
                    model.getTemperature().setAugust(Double.valueOf(cursor.getString(8)));
                    model.getTemperature().setSeptember(Double.valueOf(cursor.getString(9)));
                    model.getTemperature().setOctober(Double.valueOf(cursor.getString(10)));
                    model.getTemperature().setNovember(Double.valueOf(cursor.getString(11)));
                    model.getTemperature().setDecember(Double.valueOf(cursor.getString(12)));*/

                    list.add(model);

                    model = new CityModel();
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return list;
    }

    public void close(){
        dbHelper.close();
    }

    public void remove(CityModel model) {
        remove(model.getCityName());
    }

    private void remove(String nameCity){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("mytable", "id = '"+nameCity+"'", null);
    }

    public void change(String nameCity, CityModel model){
        remove(nameCity);
        addCityModel(model);
    }

    private class DBHelper extends SQLiteOpenHelper {//101-Список транинг объектов
        public DBHelper(Context context) {
            super(context, "DBCities", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table mytable ("
                    + "id text primary key,"
                    + "january REAL,"
                    + "february REAL,"
                    + "march REAL,"
                    + "april REAL,"
                    + "may REAL,"
                    + "june REAL,"
                    + "july REAL,"
                    + "august REAL,"
                    + "september REAL,"
                    + "october REAL,"
                    + "november REAL,"
                    + "december REAL" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
