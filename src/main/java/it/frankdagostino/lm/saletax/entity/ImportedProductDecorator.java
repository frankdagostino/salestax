package it.frankdagostino.lm.saletax.entity;

public class ImportedProductDecorator extends AbstractProductDecorator {

    public ImportedProductDecorator(Taxable taxable){
        super(taxable);
    }

    @Override
    public double getTax() {
        return this.decoratedTaxable.getTax() + round(this.decoratedTaxable.getPrice()/20);
    }

}
