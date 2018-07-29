package test.artem.eastwind.temperature;


import test.artem.eastwind.model.Temperature;

public class AverageTemperatureBase {//extends Serializable
    private Temperature temperature;

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Double getSummer(){
        if (temperature==null)
            return null;
        int numb = 0;
        Double summ = new Double(0);
        if (temperature.getJune()!=-10000.0){
            numb++;
            summ+=temperature.getJune();
        }
        if (temperature.getJuly()!=-10000.0){
            numb++;
            summ+=temperature.getJuly();
        }
        if (temperature.getAugust()!=-10000.0){
            numb++;
            summ+=temperature.getAugust();
        }
        return summ/numb;
    }

    public Double getAutumn(){
        if (temperature==null)
            return null;
        int numb = 0;
        Double summ = new Double(0);
        if (temperature.getSeptember()!=-10000.0){
            numb++;
            summ+=temperature.getSeptember();
        }
        if (temperature.getOctober()!=-10000.0){
            numb++;
            summ+=temperature.getOctober();
        }
        if (temperature.getNovember()!=-10000.0){
            numb++;
            summ+=temperature.getNovember();
        }
        return summ/numb;
    }

    public Double getWinter(){
        if (temperature==null)
            return null;
        int numb = 0;
        Double summ = new Double(0);
        if (temperature.getDecember()!=-10000.0){
            numb++;
            summ+=temperature.getDecember();
        }
        if (temperature.getJanuary()!=-10000.0){
            numb++;
            summ+=temperature.getJanuary();
        }
        if (temperature.getFebruary()!=-10000.0){
            numb++;
            summ+=temperature.getFebruary();
        }
        return summ/numb;
    }

    public Double getSpring(){
        if (temperature==null)
            return null;
        int numb = 0;
        Double summ = new Double(0);
        if (temperature.getMarch()!=-10000.0){
            numb++;
            summ+=temperature.getMarch();
        }
        if (temperature.getApril()!=-10000.0){
            numb++;
            summ+=temperature.getApril();
        }
        if (temperature.getMay()!=-10000.0){
            numb++;
            summ+=temperature.getMay();
        }
        return summ/numb;
    }
}
