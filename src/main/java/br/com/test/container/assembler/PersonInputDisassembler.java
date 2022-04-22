package br.com.test.container.assembler;

import br.com.test.container.domain.Person;
import br.com.test.container.model.input.PersonInput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonInputDisassembler {

    private final ModelMapper modelMapper;

    public Person toDomainObject(PersonInput personInput) {
        return modelMapper.map(personInput, Person.class);
    }

    public void copyToDomainObject(PersonInput personInput, Person person) {
        modelMapper.map(personInput, person);
    }

}
