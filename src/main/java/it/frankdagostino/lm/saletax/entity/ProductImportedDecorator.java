package it.frankdagostino.lm.saletax.entity;

public class ProductImportedDecorator extends ProductAbstractDecorator {

    public ProductImportedDecorator(Taxable taxable){
        super(taxable);
    }

    @Override
    public double getTax() {
        return round(this.getTaxNotRounded());
    }

	@Override
	public double getTaxNotRounded() {
		return this.decoratedTaxable.getTaxNotRounded() + this.decoratedTaxable.getPrice()/20;
	}

}
