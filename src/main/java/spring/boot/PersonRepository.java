package spring.boot;

import org.springframework.data.repository.CrudRepository;

//CrudRepository takes the <object, primary key datatype>
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
