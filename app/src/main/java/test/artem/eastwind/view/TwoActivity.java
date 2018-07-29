package test.artem.eastwind.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import test.artem.eastwind.R;
import test.artem.eastwind.db.DBCities;
import test.artem.eastwind.model.CityModel;
import test.artem.eastwind.present.TwoPresent;
import test.artem.eastwind.typeOfCity.BigOfCity;

public class TwoActivity extends AppCompatActivity {
    ListView listView;
    TwoPresent present;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        listView = (ListView)findViewById(R.id.list_view);
        button = (Button)findViewById(R.id.button_create);

        present = new TwoPresent(this);
        final TwoActivity activity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog dialog = new CustomAlertDialog(activity, null, new BigOfCity());
                dialog.show();
            }
        });
    }

    public void view(List<CityModel> modelList){
        if (modelList!=null) listView.setAdapter(new AdapterBox(this, modelList));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
