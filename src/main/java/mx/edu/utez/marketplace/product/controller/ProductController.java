package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"*"})
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Message> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@RequestParam long id) {
        return productService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Message> save(@RequestBody ProductDTO productDTO) {
        byte[] img = Base64.getDecoder().decode(productDTO.getFile().replace(" ", "+"));
        return productService.save(new Product(productDTO.getName(), productDTO.getDescription(), img, productDTO.getCuantity(), productDTO.getPrice(),
                productDTO.getStatus(), productDTO.getSubcategory()));
    }

    @PostMapping("/update")
    public ResponseEntity<Message> update(@RequestBody ProductDTO productDTO) {
        byte[] img = Base64.getDecoder().decode(productDTO.getFile().replace(" ", "+"));
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), img, productDTO.getCuantity(), productDTO.getPrice(),
                productDTO.getStatus(), productDTO.getSubcategory());
        product.setId(productDTO.getId());
        return productService.update(product);
    }
}
