package br.com.cuidapet.cuidapet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CuidapetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuidapetApplication.class, args);
	}

}
