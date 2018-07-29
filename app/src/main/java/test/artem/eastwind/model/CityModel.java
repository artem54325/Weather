package test.artem.eastwind.model;


import java.io.Serializable;

import test.artem.eastwind.temperature.AverageTemperatureBase;

public class CityModel implements Serializable{
    public CityModel() {
        temperature = new Temperature();
    }

    private String cityName;
    private Temperature temperature;
    private AverageTemperatureBase averageTemperature;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public AverageTemperatureBase getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(AverageTemperatureBase averageTemperature) {
        this.averageTemperature = averageTemperature;
        this.averageTemperature.setTemperature(temperature);
    }

    @Override
    public String toString() {
        return "CityModel{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", averageTemperature=" + averageTemperature +
                '}';
    }
}
