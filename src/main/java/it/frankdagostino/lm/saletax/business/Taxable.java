package it.frankdagostino.lm.saletax.business;

public interface Taxable {
    String getDesc();
    double getTax();
    double getTaxNotRounded();
    double getPrice();
    double getFinalPrice();
}
