package test.artem.eastwind.view;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.artem.eastwind.R;
import test.artem.eastwind.db.DBCities;
import test.artem.eastwind.db.DBTypeOfCity;
import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.temperature.AverageTemperatureBase;

public class LayoutCity extends ConstraintLayout {

    ConstraintLayout layout;
    TextView textSummer, textAutum, textWinter, textSpring, textNameCity, textTypeOfCity;
    DBCities cities;
    DBTypeOfCity typeOfCity;

    public LayoutCity(final TwoActivity activity, final CityModel model) {
        super(activity.getApplicationContext());
        LayoutInflater mInflater = LayoutInflater.from(activity);
        View view = mInflater.inflate(R.layout.layout_city, this, true);
        cities = new DBCities(this.getContext());
        typeOfCity = new DBTypeOfCity(this.getContext());

        ((ImageView) view.findViewById(R.id.image_delete)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cities.remove(model);
                activity.view(cities.getAllCities());
            }
        });

        layout = (ConstraintLayout)view.findViewById(R.id.layout);

        textSummer = (TextView)view.findViewById(R.id.text_summer_tempe);
        textAutum = (TextView)view.findViewById(R.id.text_autum_tempe);
        textWinter = (TextView)view.findViewById(R.id.text_winter_tempe);
        textSpring = (TextView)view.findViewById(R.id.text_spring_tempe);

        textNameCity = (TextView)view.findViewById(R.id.text_name_city);
        textTypeOfCity = (TextView)view.findViewById(R.id.text_type_of_city);

        model.setAverageTemperature(new AverageTemperatureBase());

        view(model);

        layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog dialog = new CustomAlertDialog(activity, model, typeOfCity.getType(model.getCityName()));
                dialog.show();
            }
        });
    }

    private void view(CityModel model) {
        textSummer.setText(model.getAverageTemperature().getSummer().toString());
        textAutum.setText(model.getAverageTemperature().getAutumn().toString());
        textWinter.setText(model.getAverageTemperature().getWinter().toString());
        textSpring.setText(model.getAverageTemperature().getSpring().toString());

        textNameCity.setText(model.getCityName());
        textTypeOfCity.setText(typeOfCity.getType(model.getCityName()).getType());
    }
}
