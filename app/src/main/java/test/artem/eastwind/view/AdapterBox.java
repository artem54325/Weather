package test.artem.eastwind.view;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import test.artem.eastwind.R;
import test.artem.eastwind.model.CityModel;


public class AdapterBox extends BaseAdapter {
    TwoActivity activity;
    LayoutInflater lInflater;
    List<CityModel> list;

    public AdapterBox(TwoActivity activity, List<CityModel> list) {
        this.activity = activity;
        this.list = list;
        lInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = new LayoutCity(this.activity, list.get(position));
        }
        return view;
    }
}
