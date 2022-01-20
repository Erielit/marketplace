package mx.edu.utez.marketplace.role.controller;

import mx.edu.utez.marketplace.role.model.Role;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = {"*"})
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<Message> getAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable long id) {
        return roleService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Message> save(@RequestBody RoleDTO role) {
        return roleService.save(new Role(role.getDescription(), role.getStatus()));
    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody RoleDTO role) {
        Role role1 = new Role(role.getDescription(), role.getStatus());
        role1.setId(role.getId());
        return roleService.update(role1);
    }

}
