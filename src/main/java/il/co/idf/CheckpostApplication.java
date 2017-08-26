package il.co.idf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"il.co.idf.spring.repo"})
public class CheckpostApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckpostApplication.class, args);
	}

}
