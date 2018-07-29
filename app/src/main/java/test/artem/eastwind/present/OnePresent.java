package test.artem.eastwind.present;


import test.artem.eastwind.db.DBCities;
import test.artem.eastwind.db.DBTypeOfCity;
import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.typeOfCity.BigOfCity;
import test.artem.eastwind.typeOfCity.MiddleOfCity;
import test.artem.eastwind.typeOfCity.SmallOfCity;
import test.artem.eastwind.view.OneActivity;

public class OnePresent {
    private OneActivity activity;
    private DBTypeOfCity db;
    private DBCities cities;

    public OnePresent(OneActivity activity) {
        this.activity = activity;

        db = new DBTypeOfCity(activity.getApplicationContext());
        cities = new DBCities(activity.getApplicationContext());

//        CityModel model = new CityModel();
//        model.setCityName("Анапа");
//        model.getTemperature().setApril(15.2);
//        model.getTemperature().setJuly(12.2);
//        model.getTemperature().setOctober(10.0);
//        model.getTemperature().setFebruary(-50.0);
//        cities.addCityModel(model);
//
//        model = new CityModel();
//        model.setCityName("Москва");
//        model.getTemperature().setApril(15.2);
//        model.getTemperature().setJuly(120.2);
//        model.getTemperature().setOctober(-49.1);
//        model.getTemperature().setFebruary(-32.15);
//        cities.addCityModel(model);
//
//        model = new CityModel();
//        model.setCityName("Сочи");
//        model.getTemperature().setApril(15.2);
//        model.getTemperature().setJuly(10.2);
//        model.getTemperature().setOctober(32.2);
//        model.getTemperature().setFebruary(-15.0);
//        cities.addCityModel(model);
//
//        db.addTypeOfCity("Анапа", new MiddleOfCity());
//        db.addTypeOfCity("Москва", new BigOfCity());
//        db.addTypeOfCity("Сочи", new SmallOfCity());


        view();
    }

    public void view(){
        activity.view(cities.getAllCities());
    }

    public void setOnItem(String cityName) {
        activity.viewTypeOfCity(db.getType(cityName));
    }

    public void close(){
        db.close();
        cities.close();
    }
}
