package it.frankdagostino.lm.saletax;

import it.frankdagostino.lm.saletax.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SaletaxApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SaletaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Product> products = mockCart1();
		List<Taxable> taxables = new ArrayList<>();

		products.forEach(product -> taxables.add(ProductFactory.getTaxable(product)));

		taxables.forEach(taxable -> {
			System.out.println(taxable.getClass() + " | " + taxable.getDesc()+ " price=" + taxable.getPrice() + " tax=" + taxable.getTax() + " final price=" + taxable.getFinalPrice());
		});
	}

	private List<Product> mockCart1(){
		List<Product> products = new ArrayList<>();
		products.add(Product.builder().desc("book").category(Category.BOOK).price(12.49).build());
		products.add(Product.builder().desc("music CD").category(Category.OTHER).price(14.99).build());
		products.add(Product.builder().desc("chocolate bar").category(Category.FOOD).price(0.85).build());
		products.add(Product.builder().desc("importaed box of chocolates").category(Category.FOOD).imported(true).price(10).build());
		products.add(Product.builder().desc("imported bottle of perfume").category(Category.OTHER).imported(true).price(new Float(47.5)).build());
		return products;
	}

	private List<Product> mockCart2(){
		List<Product> products = new ArrayList<>();
		products.add(Product.builder().desc("importaed box of chocolates").category(Category.FOOD).imported(true).price(10).build());
		products.add(Product.builder().desc("imported bottle of perfume").category(Category.OTHER).imported(true).price(new Float(47.5)).build());
		return products;
	}

	private List<Product> mockCart3(){
		List<Product> products = new ArrayList<>();
		products.add(Product.builder().desc("importaed box of chocolates").category(Category.FOOD).imported(true).price(10).build());
		products.add(Product.builder().desc("imported bottle of perfume").category(Category.OTHER).imported(true).price(new Float(47.5)).build());
		return products;
	}
}
