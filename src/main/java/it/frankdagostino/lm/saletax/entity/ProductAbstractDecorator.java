package it.frankdagostino.lm.saletax.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ProductAbstractDecorator implements Taxable{
    protected Taxable decoratedTaxable;

    public ProductAbstractDecorator(Taxable decoratedTaxable){
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

    protected double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
//        return Math.round(bd.doubleValue() * 20.0) / 20.0;
//        return bd.doubleValue();
        return Math.round(value * 20.0) / 20.0;
    }
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName() + " | ");
		builder.append("desc=");
		builder.append(getDesc());
		builder.append(", price=");
		builder.append(getPrice());
		builder.append(", taxNotRounded=");
		builder.append(getTaxNotRounded());
		builder.append(", tax=");
		builder.append(getTax());
		builder.append(", finalPrice=");
		builder.append(getFinalPrice());
		return builder.toString();
	}
}
