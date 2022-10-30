package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){

        //return cities.size();
        return 0;
    }

    public void addCity(City city){
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns a boolean if the cityList contains that passed in city object
     * @param city the city that we want to check if its in the cityList
     * @return returns true if city in the list and false if not in the list
     */
    public Boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * If the city is contained in the cities list then it removes the city (otherwise it throws an exception)
     * @param city the city that we are deleting from the cityList
     */
    public void delete(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        } else {
            //throw an exception that the element does not exist in the arraylist
            throw new NoSuchElementException();
        }
    }

}
