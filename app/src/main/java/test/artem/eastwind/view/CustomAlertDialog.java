package test.artem.eastwind.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import test.artem.eastwind.R;
import test.artem.eastwind.db.DBCities;
import test.artem.eastwind.db.DBTypeOfCity;
import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.typeOfCity.BigOfCity;
import test.artem.eastwind.typeOfCity.MiddleOfCity;
import test.artem.eastwind.typeOfCity.SmallOfCity;
import test.artem.eastwind.typeOfCity.Type;


public class CustomAlertDialog extends Dialog implements View.OnClickListener {

    DBTypeOfCity typeOfCity;
    DBCities cities;
    String[] typeOfCityString = new String[]{"Большой","Средний","Маленький"};
    Spinner spinnerType;
    EditText textNameCity, textJanuary, textFebruaty, textMarch, textApril, textMay, textJune, textJuly, textAugust, textSeptember, textOctober, textNovember, textDecember;
    private String nameCity="";
    private TwoActivity activity;

    public CustomAlertDialog(TwoActivity activity, CityModel model, Type type) {
        super(activity);
        this.activity=activity;

        setContentView(R.layout.alert_city_layout);

        typeOfCity = new DBTypeOfCity(this.getContext());
        cities = new DBCities(this.getContext());

        if (model!=null) nameCity = model.getCityName();

        spinnerType = (Spinner)findViewById(R.id.spinner_type_of_city);

        textNameCity = (EditText) findViewById(R.id.edit_name_city);

        textJanuary = (EditText) findViewById(R.id.edit_january);
        textFebruaty = (EditText) findViewById(R.id.edit_february);
        textMarch = (EditText) findViewById(R.id.edit_march);
        textApril = (EditText) findViewById(R.id.edit_april);
        textMay = (EditText) findViewById(R.id.edit_may);
        textJune = (EditText) findViewById(R.id.edit_june);
        textJuly = (EditText) findViewById(R.id.edit_jule);
        textAugust = (EditText) findViewById(R.id.edit_august);
        textOctober = (EditText) findViewById(R.id.edit_october);
        textSeptember = (EditText) findViewById(R.id.edit_september);
        textNovember = (EditText) findViewById(R.id.edit_november);
        textDecember = (EditText) findViewById(R.id.edit_december);

        ((Button)findViewById(R.id.button_save)).setOnClickListener(this);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, typeOfCityString);
        spinnerType.setAdapter(spinnerAdapter);
        switch (type.getTypeSave()){
            case "big":
                spinnerType.setSelection(0);
                break;
            case "middle":
                spinnerType.setSelection(1);
                break;
            case "small":
                spinnerType.setSelection(2);
                break;
        }

        if (model==null||model.getCityName()==null) return;

        textNameCity.setText(model.getCityName());

        writeEditText(textJanuary, model.getTemperature().getJanuary());
        writeEditText(textFebruaty, model.getTemperature().getFebruary());
        writeEditText(textMarch, model.getTemperature().getMarch());
        writeEditText(textApril, model.getTemperature().getApril());
        writeEditText(textMay, model.getTemperature().getMay());
        writeEditText(textJune, model.getTemperature().getJune());
        writeEditText(textJuly, model.getTemperature().getJuly());
        writeEditText(textAugust, model.getTemperature().getAugust());
        writeEditText(textOctober, model.getTemperature().getOctober());
        writeEditText(textSeptember, model.getTemperature().getSeptember());
        writeEditText(textNovember, model.getTemperature().getNovember());
        writeEditText(textDecember, model.getTemperature().getDecember());


    }

    private void writeEditText(EditText editText,  Double temperature){
        if (temperature!=-10000.0)
            editText.setText(temperature.toString());
        else
            editText.setText("");
    }


    @Override
    public void onClick(View v) {
        typeOfCity.remove(nameCity);
        Type type =null;

        switch (spinnerType.getSelectedItemPosition()){
            case 0:
                type=new BigOfCity();
                break;
            case 1:
                type=new MiddleOfCity();
                break;
            case 2:
                type=new SmallOfCity();
                break;
        }

        CityModel model = new CityModel();
        model.setCityName(textNameCity.getText().toString());

        if (model.getCityName().equals("")){
            Toast.makeText(this.getContext(), "Введите название города", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!model.getCityName().equals(nameCity)){
            if (cities.getCity(model.getCityName())!=null){
                Toast.makeText(this.getContext(), "Город с таким название уже есть", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        typeOfCity.remove(nameCity);
        typeOfCity.addTypeOfCity(model.getCityName(), type);

        model.getTemperature().setJanuary(writeEdit(textJanuary));
        model.getTemperature().setFebruary(writeEdit(textFebruaty));
        model.getTemperature().setMarch(writeEdit(textMarch));
        model.getTemperature().setApril(writeEdit(textApril));
        model.getTemperature().setMay(writeEdit(textMay));
        model.getTemperature().setJune(writeEdit(textJune));
        model.getTemperature().setJuly(writeEdit(textJuly));
        model.getTemperature().setAugust(writeEdit(textAugust));
        model.getTemperature().setOctober(writeEdit(textOctober));
        model.getTemperature().setSeptember(writeEdit(textSeptember));
        model.getTemperature().setNovember(writeEdit(textNovember));
        model.getTemperature().setDecember(writeEdit(textDecember));

        cities.change(nameCity, model);

        activity.view(cities.getAllCities());
        this.dismiss();
    }
    private Double writeEdit(EditText editText){
        if (editText.getText().toString().equals("")) return -10000.0;
        else return Double.parseDouble(editText.getText().toString());
    }
}
