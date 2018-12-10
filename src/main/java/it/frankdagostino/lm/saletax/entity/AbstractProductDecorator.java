package it.frankdagostino.lm.saletax.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractProductDecorator implements Taxable{
    protected Taxable decoratedTaxable;

    public AbstractProductDecorator(Taxable decoratedTaxable){
        super();
        this.decoratedTaxable = decoratedTaxable;
    }

    @Override
    public String getDesc() {
        return this.decoratedTaxable.getDesc();
    }

    @Override
    public double getPrice() {
        return this.decoratedTaxable.getPrice();
    }

    @Override
    public double getFinalPrice() {
        return this.decoratedTaxable.getPrice() + this.getTax();
    }

//    protected double round(double x){
//        return (double) Math.round(x * 100.0)/100.0;
//    }

    protected double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return Math.round(bd.doubleValue() * 20) / 20.0;
    }
}
