package com.example.devchallenge.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student("Mariam", "mariam.losr@gmail.com",
                    LocalDate.of(1998, Month.DECEMBER, 20));

            Student alex = new Student("Alex", "alex@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 2));

            repository.saveAll(
                    Arrays.asList(mariam, alex)
            );
        };
    }
}
