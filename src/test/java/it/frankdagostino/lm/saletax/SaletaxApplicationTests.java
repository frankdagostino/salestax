package it.frankdagostino.lm.saletax;

import it.frankdagostino.lm.saletax.business.TaxableFactory;
import it.frankdagostino.lm.saletax.entity.Cart;
import it.frankdagostino.lm.saletax.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaletaxApplicationTests {

    @Test
    public void cart1() {
        Cart cart = new Cart();

        Product.mockProducts1().forEach(product -> cart.addTaxable(TaxableFactory.getTaxable(product)));

        cart.print();

        assertTrue(cart.getTotalTax() == 1.50);
        assertTrue(cart.getTotalPrice() == 29.83);
    }

    @Test
    public void cart2() {
        Cart cart = new Cart();

        Product.mockProducts2().forEach(product -> cart.addTaxable(TaxableFactory.getTaxable(product)));

        cart.print();

        assertTrue(cart.getTotalTax() == 7.65);
        assertTrue(cart.getTotalPrice() == 65.15);
    }

    @Test
    public void cart3() {
        Cart cart = new Cart();

        Product.mockProducts3().forEach(product -> cart.addTaxable(TaxableFactory.getTaxable(product)));

        cart.print();

        assertTrue(cart.getTotalTax() == 6.70);
        assertTrue(cart.getTotalPrice() == 74.68);
    }

}
