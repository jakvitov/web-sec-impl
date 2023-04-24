package cz.jakvitov.websecimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class WebSecImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSecImplApplication.class, args);
	}

}
