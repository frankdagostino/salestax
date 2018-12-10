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

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.category;
    }
}
