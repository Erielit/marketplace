package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.product.model.ProductRepository;
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
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("ok", productRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id) {
        if (productRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("ok", productRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El producto no existe", null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Product product) {
        Optional<Product> existsProduct = productRepository.findByName(product.getName());
        if (existsProduct.isPresent()) {
            return new ResponseEntity<>(new Message("El producto ya existe", product), HttpStatus.BAD_REQUEST);
        }
        Product savedProduct = productRepository.saveAndFlush(product);
        return new ResponseEntity<>(new Message("ok", savedProduct), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Product product) {
        if (productRepository.existsById(product.getId())) {
            Product updatedProduct = productRepository.saveAndFlush(product);
            return new ResponseEntity<>(new Message("ok", updatedProduct), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El producto no existe", product), HttpStatus.BAD_REQUEST);
    }
}
