package test.artem.eastwind.temperature;


import java.util.logging.Level;
import java.util.logging.Logger;

public class AverageTemperatureLogg extends AverageTemperatureBase {
    Logger log = Logger.getLogger(AverageTemperatureLogg.class.getName());

    @Override
    public Double getSummer() {
        Double d = super.getSummer();
        log.log(Level.INFO, d.toString());
        return d;
    }

    @Override
    public Double getAutumn() {
        Double d = super.getAutumn();
        log.log(Level.INFO, d.toString());
        return d;
    }

    @Override
    public Double getWinter() {
        Double d = super.getWinter();
        log.log(Level.INFO, d.toString());
        return d;
    }

    @Override
    public Double getSpring() {
        Double d = super.getSpring();
        log.log(Level.INFO, d.toString());
        return d;
    }
}
