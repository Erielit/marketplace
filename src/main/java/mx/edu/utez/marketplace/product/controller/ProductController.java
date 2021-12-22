package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@RequestParam long id) {
        return productService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Message> save(@RequestBody ProductDTO productDTO) {
        return productService.save(new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getFile(), productDTO.getCuantity(), productDTO.getPrice(),
                productDTO.getStatus(), productDTO.getSubcategory()));
    }

    @PostMapping("/update")
    public ResponseEntity<Message> update(@RequestBody ProductDTO productDTO) {
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getFile(), productDTO.getCuantity(),
                productDTO.getPrice(), productDTO.getStatus(), productDTO.getSubcategory());
        product.setId(productDTO.getId());
        return productService.update(product);
    }
}
