package br.com.erudio._0aaws.services;

import br.com.erudio._0aaws.exceptions.ResourceNotFoundException;
import br.com.erudio._0aaws.model.Person;
import br.com.erudio._0aaws.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;
    public List<Person> findAll(){
        logger.info("Finding all people");
        return personRepository.findAll();
    }

    public Person findById(Long id){

        logger.info("Finding one person!");

        //retornando um mock
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person!");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }
}
