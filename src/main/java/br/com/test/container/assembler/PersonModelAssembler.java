package br.com.test.container.assembler;

import br.com.test.container.domain.Person;
import br.com.test.container.model.PersonModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonModelAssembler {

    private final ModelMapper modelMapper;

    public PersonModel toModel(Person person) {
        return modelMapper.map(person, PersonModel.class);
    }

    public List<PersonModel> toCollectionModel(List<Person> personList) {
        return personList.stream().map(this::toModel).collect(Collectors.toList());
    }
}
