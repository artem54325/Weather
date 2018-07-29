package test.artem.eastwind.model;


import java.io.Serializable;

public class Temperature implements Serializable{//-10000.0 место null
    private Double january=-10000.0;
    private Double february=-10000.0;
    private Double march=-10000.0;
    private Double april=-10000.0;
    private Double may=-10000.0;
    private Double june=-10000.0;
    private Double july=-10000.0;
    private Double august=-10000.0;
    private Double september=-10000.0;
    private Double october=-10000.0;
    private Double november=-10000.0;
    private Double december=-10000.0;

    public Double getJanuary() {
        return january;
    }

    public void setJanuary(Double january) {
        this.january = january;
    }

    public Double getFebruary() {
        return february;
    }

    public void setFebruary(Double february) {
        this.february = february;
    }

    public Double getMarch() {
        return march;
    }

    public void setMarch(Double march) {
        this.march = march;
    }

    public Double getApril() {
        return april;
    }

    public void setApril(Double april) {
        this.april = april;
    }

    public Double getMay() {
        return may;
    }

    public void setMay(Double may) {
        this.may = may;
    }

    public Double getJune() {
        return june;
    }

    public void setJune(Double june) {
        this.june = june;
    }

    public Double getJuly() {
        return july;
    }

    public void setJuly(Double july) {
        this.july = july;
    }

    public Double getAugust() {
        return august;
    }

    public void setAugust(Double august) {
        this.august = august;
    }

    public Double getSeptember() {
        return september;
    }

    public void setSeptember(Double september) {
        this.september = september;
    }

    public Double getOctober() {
        return october;
    }

    public void setOctober(Double october) {
        this.october = october;
    }

    public Double getNovember() {
        return november;
    }

    public void setNovember(Double november) {
        this.november = november;
    }

    public Double getDecember() {
        return december;
    }

    public void setDecember(Double december) {
        this.december = december;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "january=" + january +
                ", february=" + february +
                ", march=" + march +
                ", april=" + april +
                ", may=" + may +
                ", june=" + june +
                ", july=" + july +
                ", august=" + august +
                ", september=" + september +
                ", october=" + october +
                ", november=" + november +
                ", december=" + december +
                '}';
    }
}
