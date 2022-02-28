package mx.edu.utez.marketplace.user.controller;

import mx.edu.utez.marketplace.person.model.Person;
import mx.edu.utez.marketplace.person.model.PersonRepository;
import mx.edu.utez.marketplace.user.model.User;
import mx.edu.utez.marketplace.user.model.UserRepository;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("ok", false, userRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id) {
        if (userRepository.existsById(id))
            return new ResponseEntity<>(new Message("ok", false, userRepository.findById(id)), HttpStatus.OK);
        return new ResponseEntity<>(new Message("El usuario no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return new ResponseEntity<>(new Message("El usuario ya existe", true, null), HttpStatus.BAD_REQUEST);
        if (userRepository.existsByPersonCurp(user.getPerson().getCurp()))
            return new ResponseEntity<>(new Message("La persona ya cuenta con un usuario", true, null), HttpStatus.BAD_REQUEST);

        Person tempPerson = user.getPerson();
        tempPerson = personRepository.saveAndFlush(tempPerson);
        user.setPerson(tempPerson);
        return new ResponseEntity<>(new Message("ok", false, userRepository.saveAndFlush(user)), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(User user) {
        if (!userRepository.existsByUsername(user.getUsername()))
            return new ResponseEntity<>(new Message("El usuario ya existe", true, null), HttpStatus.BAD_REQUEST);
        if (!userRepository.existsByPersonCurp(user.getPerson().getCurp()))
            return new ResponseEntity<>(new Message("La persona ya cuenta con un usuario", true, null), HttpStatus.BAD_REQUEST);
        if (userRepository.existsById(user.getId()))
            return new ResponseEntity<>(new Message("ok", false, userRepository.saveAndFlush(user)), HttpStatus.OK);
        return new ResponseEntity<>(new Message("El usuario no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
