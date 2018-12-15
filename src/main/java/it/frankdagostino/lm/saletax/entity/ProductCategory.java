package it.frankdagostino.lm.saletax.entity;

public enum ProductCategory {
    FOOD("FOOD"),
    BOOK("BOOK"),
    MEDICAL("MEDICAL"),
    OTHER("OTHER");

    private final String category;

    ProductCategory(final String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
