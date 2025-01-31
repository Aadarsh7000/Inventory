package com.yash.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.yash.Inventory.model.Product;
import com.yash.Inventory.service.ProductService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    	 Product product = productService.getProductById(id);
         return ResponseEntity.ok(product);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return ResponseEntity.ok(updatedProduct);
       
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body("Product Deleted Successfully");
    }
    @GetMapping("/userlist")
    public String getUserList1() {
		return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"age\": 30,\n" +
                "        \"email\": \"john.doe@example.com\",\n" +
                "        \"phone\": \"123-456-7890\",\n" +
                "        \"address\": {\n" +
                "            \"street\": \"123 Main St\",\n" +
                "            \"city\": \"New York\",\n" +
                "            \"state\": \"NY\",\n" +
                "            \"zip\": \"10001\"\n" +
                "        },\n" +
                "        \"isActive\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane Smith\",\n" +
                "        \"age\": 28,\n" +
                "        \"email\": \"jane.smith@example.com\",\n" +
                "        \"phone\": \"987-654-3210\",\n" +
                "        \"address\": {\n" +
                "            \"street\": \"456 Elm St\",\n" +
                "            \"city\": \"Los Angeles\",\n" +
                "            \"state\": \"CA\",\n" +
                "            \"zip\": \"90001\"\n" +
                "        },\n" +
                "        \"isActive\": false\n" +
                "    }\n" +
                "]";

    }
    @GetMapping("/userlist1")
    public String getUserList2() {
		return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Ashu\",\n" +
                "        \"age\": 30,\n" +
                "        \"email\": \"john.doe@yash.com\",\n" +
                "        \"phone\": \"123-456-7899\",\n" +
                "        \"address\": {\n" +
                "            \"street\": \"124 Main St\",\n" +
                "            \"city\": \"New York\",\n" +
                "            \"state\": \"Ind\",\n" +
                "            \"zip\": \"10001\"\n" +
                "        },\n" +
                "        \"isActive\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane Smith\",\n" +
                "        \"age\": 38,\n" +
                "        \"email\": \"ashu.smith@example.com\",\n" +
                "        \"phone\": \"987-654-3210\",\n" +
                "        \"addres\": {\n" +
                "            \"street\": \"456 Elm St\",\n" +
                "            \"city\": \"Los Angeles\",\n" +
                "            \"state\": \"CA\",\n" +
                "            \"zip\": \"90081\"\n" +
                "        },\n" +
                "        \"isActive\": true\n" +
                "    }\n" +
                "]";
    }
}