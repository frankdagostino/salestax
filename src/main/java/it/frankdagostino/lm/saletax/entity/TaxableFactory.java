package it.frankdagostino.lm.saletax.entity;

import java.util.Arrays;

public class TaxableFactory {

    public final static ProductCategory[] esenTax = {ProductCategory.BOOK, ProductCategory.FOOD, ProductCategory.MEDICAL};

    public static Taxable getTaxable(Product product){


        Taxable taxable;

        if(Arrays.asList(esenTax).contains(product.getCategory()))
            taxable = product;
        else taxable = new ProductTaxableDecorator(product);

        if( product.isImported() )
            taxable = new ProductImportedDecorator(taxable);

        return taxable;
    }
}
