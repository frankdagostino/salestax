package it.frankdagostino.lm.saletax.business;

import it.frankdagostino.lm.saletax.entity.Product;
import it.frankdagostino.lm.saletax.entity.ProductCategory;

import java.util.Arrays;

public class TaxableFactory {

    private final static ProductCategory[] esenTax = {ProductCategory.BOOK, ProductCategory.FOOD, ProductCategory.MEDICAL};

    public static Taxable getTaxable(Product product){

        Taxable taxable;

        if(Arrays.asList(esenTax).contains(product.getCategory()))
            taxable = product;
        else taxable = new TaxableProductDecorator(product);

        if( product.isImported() )
            taxable = new TaxableImportedDecorator(taxable);

        return taxable;
    }
}
