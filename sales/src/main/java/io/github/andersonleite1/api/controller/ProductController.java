package io.github.andersonleite1.api.controller;

import io.github.andersonleite1.domain.entity.Product;
import io.github.andersonleite1.domain.repository.Products;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private Products products;

    public ProductController (Products products) { this.products = products; }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Integer id) {
        return products.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @GetMapping
    public List<Product> find(Product productFilter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(productFilter, matcher);
        return products.findAll(example);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) { return products.save(product); }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Product product) {
        products.findById(id).map(productCurrent -> {
            product.setId(productCurrent.getId());
            products.save(product);
            return productCurrent;
        }).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        products.findById(id).map(product -> {
            products.delete(product);
            return product;
        }).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product not found"));
    }
}
