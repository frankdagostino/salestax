package it.frankdagostino.lm.saletax;

import it.frankdagostino.lm.saletax.business.TaxableFactory;
import it.frankdagostino.lm.saletax.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SaletaxApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SaletaxApplication.class, args);
	}

	@Override
	public void run(String... args){
		Product.mockProducts().forEach(product -> {
			log.info(TaxableFactory.getTaxable(product).toString());
		});
	}

}
