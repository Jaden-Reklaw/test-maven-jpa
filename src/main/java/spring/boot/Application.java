package spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

//JPA - Java Persistance API
@SpringBootApplication
public class Application {

    //Create Logger using Log4j
    private static final Logger Log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return (args) -> {
            Log.info("--------- IT'S WORKING ---------");
            personRepository.save(new Person("Jordan", "S", "Walker"));
            personRepository.save(new Person("Kelsey", "M", "Walker"));
            personRepository.save(new Person("Kyle", "T", "Sherwood"));

            Person person = new Person();
            person.setFirstName("Java");
            person.setMiddleName("Persistence");
            person.setLastName("API");
            person.setSSN("XXX-XX-XXXX");

            personRepository.save(person);

            for (int i = 0; i < 10; i++) {
                Person obj = new Person();
                obj.setFirstName("FirstName" + i);
                obj.setMiddleName("MiddleName" + i);
                obj.setLastName("LastName" + i);
                obj.setSSN("" + i + i + i);

                //individual save
                personRepository.save(obj);
            }

            List<Person> personListToSave = new ArrayList<Person>();

            for (int i = 0; i < 10; i++) {
                Person obj = new Person();
                obj.setFirstName("FirstNameL" + i);
                obj.setMiddleName("MiddleNameL" + i);
                obj.setLastName("LastNameL" + i);
                obj.setSSN("L" + i + i + i);

                personListToSave.add(obj);
            }

            //group save
            personRepository.save(personListToSave);

            //find an object by ID
            Person obj = personRepository.findOne(2);
            Log.info("Person Found " + obj.getFirstName() + " " + obj.getLastName());

            //get back all the people from the person table
            for (Person p : personRepository.findAll()) {
                Log.info("Person Found: " + p.getId() + " " + p.getFirstName() + " " + p.getLastName());
            }

            //Check if person exists in the database
            Log.info("Person with ID 2 Exists: " + personRepository.exists(2));

            //Get total number of records in the database
            Log.info("Total Person Records: " + personRepository.count());

            //Delete a record from the database
            if(personRepository.exists(24)) {
                personRepository.delete(24);
                Log.info("Person ID of 24 Exists: " + personRepository.exists(24));
            } else {
                Log.info("No Person with that ID Exists");
            }

            //personRepository.deleteAll();
        }; //end of return
    }
}
