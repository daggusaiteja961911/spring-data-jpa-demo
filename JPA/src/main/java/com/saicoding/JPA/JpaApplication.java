package com.saicoding.JPA;

import com.saicoding.JPA.models.Author;
import com.saicoding.JPA.models.Video;
import com.saicoding.JPA.repositories.AuthorRepository;
import com.saicoding.JPA.repositories.VideoRepository;
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
            AuthorRepository repository,
            VideoRepository videoReository
    ) {
        return args -> {
            /*var author = Author.builder()
                    .firstName("Sai1")
                    .lastName("Coding1")
                    .age(26)
                    .email("saiCoding1@gmail.com")
                    .createdAt(java.time.LocalDateTime.now())
                    .build();
            repository.save(author);*/
            var video = Video.builder()
                    .name("abc")
                    .length(5)
                    .build();
            videoReository.save(video);
        };
    }

}
