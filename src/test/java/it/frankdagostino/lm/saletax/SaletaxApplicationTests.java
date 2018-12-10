package it.frankdagostino.lm.saletax;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.frankdagostino.lm.saletax.entity.Cart;
import it.frankdagostino.lm.saletax.entity.ProductCategory;
import it.frankdagostino.lm.saletax.entity.Product;
import it.frankdagostino.lm.saletax.entity.TaxableFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaletaxApplicationTests {

	@Test
	public void cart1() {
		Cart cart = new Cart();
		
		List<Product> products = Product.mockProducts1();
		
		products.forEach(product -> cart.addTaxable(TaxableFactory.getTaxable(product)));

		printCart(cart);
		
		assertTrue(cart.getTotalTax() == 1.50);
		assertTrue(cart.getTotalPrice() == 29.83);
	}
	
	@Test
	public void cart2() {
		Cart cart = new Cart();
		
		List<Product> products = Product.mockProducts2();

		products.forEach(product -> cart.addTaxable(TaxableFactory.getTaxable(product)));

		printCart(cart);
		
		assertTrue(cart.getTotalTax() == 7.65);
		assertTrue(cart.getTotalPrice() == 65.15);
	}
	
	@Test
	public void cart3() {
		Cart cart = new Cart();
		
		List<Product> products = Product.mockProducts3();

		products.forEach(product -> cart.addTaxable(TaxableFactory.getTaxable(product)));

		printCart(cart);
		
		assertTrue(cart.getTotalTax() == 6.70);
		assertTrue(cart.getTotalPrice() == 74.68);
	}
	
	private void printCart(Cart cart) {
		System.out.println();
		cart.getTaxableList().forEach(taxable -> System.out.println("1 " + taxable.getDesc() + " : " + taxable.getFinalPrice()));
		System.out.println("Sales Taxes : " + cart.getTotalTax());
		System.out.println("Total : " + cart.getTotalPrice());
	}

}
