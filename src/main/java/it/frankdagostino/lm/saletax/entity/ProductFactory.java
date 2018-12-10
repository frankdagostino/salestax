package it.frankdagostino.lm.saletax.entity;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class ProductFactory {

    public final static Category[] esenTax = {Category.BOOK, Category.FOOD, Category.MEDICAL};

    public static Taxable getTaxable(@NotNull Product product){


        Taxable taxable;

        if(Arrays.asList(esenTax).contains(product.getCategory()))
            taxable = product;
        else taxable = new  TaxableProductDecorator(product);

        if( product.isImported() )
            taxable = new ImportedProductDecorator(taxable);

        return taxable;
    }
}
