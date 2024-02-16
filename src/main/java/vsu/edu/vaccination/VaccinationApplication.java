package vsu.edu.vaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "vsu.edu.vaccination")
public class VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationApplication.class, args);
	}
}
