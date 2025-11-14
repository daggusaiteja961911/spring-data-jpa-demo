package com.saicoding.JPA;

import com.saicoding.JPA.models.Author;
import com.saicoding.JPA.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository
    ) {
        return args -> {
            var author = Author.builder()
                    .firstName("Sai")
                    .lastName("Coding")
                    .age(26)
                    .email("saiCoding@gmail.com")
                    .createdAt(java.time.LocalDateTime.now())
                    .build();
            repository.save(author);
        };
    }

}
