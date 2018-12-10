package it.frankdagostino.lm.saletax.entity;

public interface Taxable {
    String getDesc();
    double getTax();
    double getPrice();
    double getFinalPrice();
}
