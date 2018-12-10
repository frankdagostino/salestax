package it.frankdagostino.lm.saletax.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cart {
	private Integer id;
	private List<Taxable> taxableList;

	public Cart() {
		this.taxableList = new ArrayList<>();
	}

	public void addTaxable(Taxable taxable) {
		this.taxableList.add(taxable);
	}

	public void removeTaxable(Taxable taxable) {
		this.taxableList.remove(taxable);
	}

	public double getTotalPrice() {
		return round(this.taxableList.stream().mapToDouble(Taxable::getFinalPrice).sum());
	}

	public double getTotalTax() {
		return round(this.taxableList.stream().mapToDouble(Taxable::getTax).sum());
	}

	protected double round(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
