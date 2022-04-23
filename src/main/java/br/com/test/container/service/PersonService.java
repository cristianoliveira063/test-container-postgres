package br.com.test.container.service;

import br.com.test.container.domain.Person;
import br.com.test.container.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Set<String> getPersonNameALL() {
        return personRepository.findAllNames();
    }
}
