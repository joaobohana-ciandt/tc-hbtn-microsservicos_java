package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/welcome")
    @ApiOperation("Responsável por retornar uma mensagem de boas vindas.")
    public String mensagemBoasVindas(){
        return "Bem vindo";
    }

    @GetMapping("/allProducts")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    @ApiOperation("Responsável por retornar uma lista de produtos.")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productRepository.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    @GetMapping("/findProductById/{id}")
    @ApiOperation("Responsável por retornar um produto pelo id.")
    public ResponseEntity<Product> findProductById(@PathVariable int id){
        Product product = productRepository.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @ApiResponse(code = 10, message = "Required fields not informed.")
    @PostMapping("/addProduct")
    @ApiOperation("Responsável por adicionar um produto")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        productRepository.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    @DeleteMapping("/removeProduct")
    @ApiOperation("Responsável por remover um produto.")
    public ResponseEntity<Product> removeProduct(@RequestBody Product product){
        productRepository.removeProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    @ApiOperation("Responsável por atualizar um produto")
    public void updateProduct(@RequestBody Product product) {
        productRepository.updateProduct(product);
    }
}
