package it.frankdagostino.lm.saletax.entity;

public interface Taxable {
    String getDesc();
    double getTax();
    double getTaxNotRounded();
    double getPrice();
    double getFinalPrice();
}
