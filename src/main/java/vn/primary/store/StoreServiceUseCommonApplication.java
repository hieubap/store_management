package vn.primary.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "vn.primary")
public class StoreServiceUseCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreServiceUseCommonApplication.class, args);
	}

}
