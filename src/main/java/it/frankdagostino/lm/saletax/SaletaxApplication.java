package it.frankdagostino.lm.saletax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.frankdagostino.lm.saletax.entity.ProductCategory;
import it.frankdagostino.lm.saletax.entity.Product;
import it.frankdagostino.lm.saletax.entity.TaxableFactory;
import it.frankdagostino.lm.saletax.entity.Taxable;

@SpringBootApplication
public class SaletaxApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SaletaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Product> products = Product.mockProducts1();
		products.addAll(Product.mockProducts2());
		products.addAll(Product.mockProducts3());

		products.forEach(product -> {
			System.out.println(TaxableFactory.getTaxable(product).toString());
		});

		
	}
	

}
