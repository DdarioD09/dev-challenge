package com.example.devchallenge.model;

import com.example.devchallenge.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            Person mariam = new Person("Mariam Hernandez",
                    LocalDate.of(1998, Month.DECEMBER, 20));

            Person alex = new Person("Alex Rojas",
                    LocalDate.of(2000, Month.JANUARY, 2));

            Person mendi = new Person("Mindi Glasd",
                    LocalDate.of(2010, Month.FEBRUARY, 26));

            repository.saveAll(
                    Arrays.asList(mariam, alex, mendi)
            );
        };
    }
}
