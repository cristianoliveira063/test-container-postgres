package br.com.test.container.repository;

import br.com.test.container.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "select distinct p.name from person p")
    Set<String> findAllNames();
}
