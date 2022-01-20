package mx.edu.utez.marketplace.role.controller;

import mx.edu.utez.marketplace.role.model.Role;
import mx.edu.utez.marketplace.role.model.RoleRepository;
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
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("ok", roleRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id) {
        Optional<Role> existsRole = roleRepository.findById(id);
        if (existsRole.isPresent()) {
            return new ResponseEntity<>(new Message("ok", roleRepository.getById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El rol no existe", null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Role role) {
        Optional<Role> foundRole = roleRepository.findByDescription(role.getDescription());
        if (foundRole.isPresent()) {
            return new ResponseEntity<>(new Message("El rol ya existe", null), HttpStatus.BAD_REQUEST);
        }
        Role savedRole = roleRepository.saveAndFlush(role);
        return new ResponseEntity<>(new Message("ok", savedRole), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Role role) {
        if (roleRepository.existsById(role.getId())) {
            Role updatedRole = roleRepository.saveAndFlush(role);
            return new ResponseEntity<>(new Message("ok", updatedRole), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El rol no existe", null), HttpStatus.BAD_REQUEST);
    }

}
