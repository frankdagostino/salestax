package it.frankdagostino.lm.saletax.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Data
public class Product implements Taxable{
    Integer id;
    Category category;
    double price;
    String desc;
    boolean imported;

    public double getTax() {
        return new Float(0);
    }

    public double getFinalPrice() {
        return getPrice() + getTax();
    }
}
