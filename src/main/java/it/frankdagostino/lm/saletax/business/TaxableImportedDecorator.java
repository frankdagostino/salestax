package it.frankdagostino.lm.saletax.business;

public class TaxableImportedDecorator extends TaxableAbstractDecorator {

    public TaxableImportedDecorator(Taxable taxable){
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
