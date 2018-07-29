package test.artem.eastwind.degree;



public abstract class IDegres {
    Double derges=null;

    public Double getDerges() {
        return derges;
    }

    public void setDerges(Double derges) {
        this.derges = derges;
    }

    abstract Double getTemperature();
}
