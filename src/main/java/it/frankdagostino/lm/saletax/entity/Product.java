package it.frankdagostino.lm.saletax.entity;

import java.util.ArrayList;
import java.util.List;

import it.frankdagostino.lm.saletax.business.Taxable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Data
public class Product implements Taxable {
    
	private Integer id;
    private ProductCategory category;
    private double price;
    private String desc;
    private boolean imported;

    public double getTax() {
        return 0;
    }
    
    public double getTaxNotRounded() {
        return 0;
    }

    public double getFinalPrice() {
        return getPrice() + getTax();
    }
    
    
    
	public static List<Product> mockProducts1(){
		List<Product> products = new ArrayList<>();
		products.add(Product.builder().desc("book").category(ProductCategory.BOOK).price(12.49).build());
		products.add(Product.builder().desc("music CD").category(ProductCategory.OTHER).price(14.99).build());
		products.add(Product.builder().desc("chocolate bar").category(ProductCategory.FOOD).price(0.85).build());
		return products;
	}
	
	public static List<Product> mockProducts2(){
		List<Product> products = new ArrayList<>();
		products.add(Product.builder().desc("imported box of chocolates").category(ProductCategory.FOOD).imported(true).price(10).build());
		products.add(Product.builder().desc("imported bottle of perfume").category(ProductCategory.OTHER).imported(true).price(47.5).build());
		return products;
	}
	
	public static List<Product> mockProducts3(){
		List<Product> products = new ArrayList<>();
		products.add(Product.builder().desc("imported bottle of perfume").category(ProductCategory.OTHER).imported(true).price(27.99).build());
		products.add(Product.builder().desc("bottle of perfume").category(ProductCategory.OTHER).price(18.99).build());
		products.add(Product.builder().desc("packet of headache pills").category(ProductCategory.MEDICAL).price(9.75).build());
		products.add(Product.builder().desc("box of imported chocolates").category(ProductCategory.FOOD).imported(true).price(11.25).build());
		return products;
	}

	public static List<Product> mockProducts(){
		List<Product> products = Product.mockProducts1();
		products.addAll(Product.mockProducts2());
		products.addAll(Product.mockProducts3());
		return products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName() + " | ");
		builder.append("desc=");
		builder.append(getDesc());
		builder.append(", price=");
		builder.append(getPrice());
		builder.append(", taxNotRounded=");
		builder.append(getTaxNotRounded());
		builder.append(", tax=");
		builder.append(getTax());
		builder.append(", finalPrice=");
		builder.append(getFinalPrice());
		return builder.toString();
	}
}
