package it.frankdagostino.lm.saletax.business;

public class TaxableProductDecorator extends TaxableAbstractDecorator {

    public TaxableProductDecorator(Taxable taxable){
        super(taxable);
    }

    @Override
    public double getTax() {
        return round(this.getTaxNotRounded());
    }

	@Override
	public double getTaxNotRounded() {
		return this.decoratedTaxable.getTaxNotRounded() + this.decoratedTaxable.getPrice()/10;
	}

}
