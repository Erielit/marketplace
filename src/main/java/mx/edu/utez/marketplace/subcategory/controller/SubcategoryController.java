package mx.edu.utez.marketplace.subcategory.controller;

import mx.edu.utez.marketplace.subcategory.model.Subcategory;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return subcategoryService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
        return subcategoryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody SubcategoryDTO subcategoryDTO) {
        return subcategoryService.save(new Subcategory(subcategoryDTO.getDescription(), subcategoryDTO.getCategory()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody SubcategoryDTO subcategoryDTO) {
        Subcategory saveSubcategory = new Subcategory(subcategoryDTO.getDescription(), subcategoryDTO.getCategory());
        saveSubcategory.setId(subcategoryDTO.getId());
        return subcategoryService.update(saveSubcategory);
    }
}
