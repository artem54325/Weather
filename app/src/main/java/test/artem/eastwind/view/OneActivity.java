package test.artem.eastwind.view;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.EventListener;
import java.util.List;

import test.artem.eastwind.R;
import test.artem.eastwind.degree.Degres;
import test.artem.eastwind.degree.DegresCelsius;
import test.artem.eastwind.event.Event;
import test.artem.eastwind.event.ManagerEvent;
import test.artem.eastwind.event.SnackbarView;
import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.present.OnePresent;
import test.artem.eastwind.temperature.AverageTemperatureLogg;
import test.artem.eastwind.typeOfCity.Type;

public class OneActivity extends AppCompatActivity implements View.OnClickListener, Event{
    private CoordinatorLayout layout;
    private List<CityModel> modelList = null;
    private Spinner spinnerCity, spinnerSeasonOfYear;
    private TextView typeOfCity,temperature;
    private OnePresent present;
    private Degres degres;

    private ManagerEvent event = new ManagerEvent();

    @Override
    protected void onStart() {
        super.onStart();
        present.view();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        spinnerCity = (Spinner) findViewById(R.id.spinner_city);
        spinnerSeasonOfYear = (Spinner) findViewById(R.id.spinner_season_of_year);
        layout = (CoordinatorLayout)findViewById(R.id.layout);

        ((Button)findViewById(R.id.but_start_two_activity)).setOnClickListener(this);
        present = new OnePresent(this);

        typeOfCity = (TextView) findViewById(R.id.text_type_of_city);
        temperature = (TextView)findViewById(R.id.text_temperature);

        degres = new Degres();
        degres.setDegres(new DegresCelsius());

        event.addEvent(new SnackbarView(layout));
        event.addEvent(this);
    }

    public void view(final List<CityModel> models){
        modelList=models;

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item, getStrings(models));
        spinnerCity.setAdapter(spinnerAdapter);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getSeasonString(models.get(position));
                present.setOnItem(models.get(position).getCityName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }

    private String[] getStrings(List<CityModel> models){
        String[] mass = new String[models.size()];

        for (int i=0;i<models.size();i++) mass[i] = models.get(i).getCityName();

        return mass;
    }

    public void viewTypeOfCity(Type type){
        if (type!=null) typeOfCity.setText(type.getType());
        else typeOfCity.setText("");
    }

    private void getSeasonString(final CityModel model){
        model.setAverageTemperature(new AverageTemperatureLogg());

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item, new String[]{"Зима", "Весна", "Лето","Осень"});
        spinnerSeasonOfYear.setAdapter(spinnerAdapter);
        spinnerSeasonOfYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        event.viewListening(model.getAverageTemperature().getWinter().toString());
                        break;
                    case 1:
                        event.viewListening(model.getAverageTemperature().getSpring().toString());
                        break;
                    case 2:
                        event.viewListening(model.getAverageTemperature().getSummer().toString());
                        break;
                    case 3:
                        event.viewListening(model.getAverageTemperature().getAutumn().toString());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void view(String text) {
        temperature.setText(text);
    }
}
