package mx.edu.utez.marketplace.person.controller;

import mx.edu.utez.marketplace.person.model.Person;
import mx.edu.utez.marketplace.person.model.PersonRepository;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("ok", personRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id) {
        ResponseEntity<Message> response = null;
        if (personRepository.existsById(id)) {
            response = new ResponseEntity<>(new Message("ok", personRepository.findById(id)), HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(new Message("Persona no encontrada", null), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Person person) {
        Optional<Person> personOptional = personRepository.findByCurp(person.getCurp());
        if (personOptional.isPresent()) {
            return new ResponseEntity<>(new Message("La persona ya existe", null), HttpStatus.BAD_REQUEST);
        }
        Person personFound = personRepository.saveAndFlush(person);
        return new ResponseEntity<>(new Message("ok", personFound), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Person person) {
        if (personRepository.existsById(person.getId())) {
            Person personFound = personRepository.saveAndFlush(person);
            return new ResponseEntity<>(new Message("ok", personFound), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La persona ya existe", null), HttpStatus.BAD_REQUEST);
    }

}
