package test.artem.eastwind.degree;



public class Degres {
    private Double degressCelsius = null;
    private IDegres degres;

    public Double getDegressCelsius() {
        return degressCelsius;
    }

    public void setDegressCelsius(Double degressCelsius) {
        this.degressCelsius = degressCelsius;
        this.degres.setDerges(degressCelsius);
    }

    public IDegres getDegres() {
        return degres;
    }

    public void setDegres(IDegres degres) {
        this.degres = degres;
        this.degres.setDerges(degressCelsius);
    }
}
