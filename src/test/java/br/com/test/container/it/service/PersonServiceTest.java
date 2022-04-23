package br.com.test.container.it.service;

import br.com.test.container.domain.Person;
import br.com.test.container.repository.PersonRepository;
import br.com.test.container.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers")
class PersonServiceTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @BeforeEach
    void init() {
        personRepository.deleteAll();
    }

    @Test
    void should_create_one_person() {
        final var person = Person.builder()
                .name("João")
                .build();
        personService.create(person);
        assertNotNull(person);
    }

    @Test
    void should_return_names() {
        personRepository.saveAndFlush(Person.builder()
                .name("John")
                .build());
        personRepository.saveAndFlush(Person.builder()
                .name("Kile")
                .build());
        personRepository.saveAndFlush(Person.builder()
                .name("Paul")
                .build());
        assertEquals(Set.of("John", "Kile", "Paul"), personService.getPersonNameALL());
    }


}