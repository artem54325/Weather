package test.artem.eastwind.present;


import test.artem.eastwind.db.DBCities;
import test.artem.eastwind.view.TwoActivity;

public class TwoPresent {
    private TwoActivity activity;
    private DBCities cities;

    public TwoPresent(TwoActivity activity) {
        this.activity = activity;

        cities = new DBCities(activity);
        view();
    }

    private void view() {
        activity.view(cities.getAllCities());
    }
}
