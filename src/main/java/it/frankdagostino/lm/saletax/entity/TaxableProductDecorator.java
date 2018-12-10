package it.frankdagostino.lm.saletax.entity;

public class TaxableProductDecorator extends AbstractProductDecorator{

    public TaxableProductDecorator(Taxable taxable){
        super(taxable);
    }

    @Override
    public double getTax() {
        return this.decoratedTaxable.getTax() + round(this.decoratedTaxable.getPrice()/10);
    }

}
