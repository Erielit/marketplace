package mx.edu.utez.marketplace.category.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{category}")
    public ResponseEntity<Message> getById(@PathVariable("category") long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody CategoryDTO category) {
        Category saveCategory = new Category(category.getDescription(), category.getStatus());
        return categoryService.save(saveCategory);
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody CategoryDTO categoryDTO) {
        Category saveCategory = new Category(categoryDTO.getDescription(), categoryDTO.getStatus());
        saveCategory.setId(categoryDTO.getId());
        return categoryService.update(saveCategory);
    }

}
