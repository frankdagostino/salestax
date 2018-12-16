package it.frankdagostino.lm.saletax.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class TaxableAbstractDecorator implements Taxable{
    protected Taxable decoratedTaxable;

    public TaxableAbstractDecorator(Taxable decoratedTaxable){
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
        return Math.round((this.decoratedTaxable.getPrice() + this.getTax()) * 100.0) / 100.0;
    }

    public double round(double input){
        BigDecimal value = new BigDecimal(input);
        BigDecimal increment = new BigDecimal(0.05);
        BigDecimal divided = value.divide(increment, 0, RoundingMode.UP);
        return divided.multiply(increment).doubleValue();
    }
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName());
		builder.append(" | ");
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
