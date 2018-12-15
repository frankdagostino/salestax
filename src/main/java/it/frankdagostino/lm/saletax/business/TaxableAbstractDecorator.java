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
        return this.decoratedTaxable.getPrice() + this.getTax();
    }

//    protected double round(double value) {
//        BigDecimal bd = new BigDecimal(value);
//        bd = bd.setScale(1, RoundingMode.UP);
//        return Math.round(bd.doubleValue() * 20.0) / 20.0;
////        return bd.doubleValue();
////        return Math.round(value * 20.0) / 20.0;
//    }

    public double round(double value){
        return round(new BigDecimal(value), new BigDecimal(0.05), RoundingMode.UP).doubleValue();
    }

    public static BigDecimal round(BigDecimal value, BigDecimal increment,
                                   RoundingMode roundingMode) {
        if (increment.signum() == 0) { // 0 increment does not make much sense, but prevent division by 0
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            return divided.multiply(increment);
        }
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
