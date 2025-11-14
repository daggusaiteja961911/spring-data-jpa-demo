package com.saicoding.JPA;

import com.github.javafaker.Faker;
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
            VideoRepository videoRepository
    ) {
        return args -> {
//            for(int i=0;i<50;i++) {
//                Faker faker = new Faker();
//                var author = Author.builder()
//                        .firstName(faker.name().firstName())
//                        .lastName(faker.name().lastName())
//                        .age(faker.number().numberBetween(18, 60))
//                        .email(faker.internet().emailAddress())
//                        .build();
//                repository.save(author);
//            }
            // update author with ID = 1
            var authorOpt = repository.findById(1);
            if(authorOpt.isPresent()) {
                var author = authorOpt.get();
                author.setFirstName("UpdatedName");
                author.setLastName("UpdatedLastName");
                author.setEmail("update@gmail.com");
                repository.save(author);
            }

            // update Author a set a.age = 22 where a.id =2
            //repository.updateAuthorAgeById(22, 2);

            //update all authors
            repository.updateAllAuthorsAges(99);



            // find by named query
//            repository.findByNamedQuery(99)
//                    .forEach(System.out::println);

//            var video = Video.builder()
//                    .name("abc")
//                    .length(5)
//                    .build();
//            videoRepository.save(video);
        };

    }

}
