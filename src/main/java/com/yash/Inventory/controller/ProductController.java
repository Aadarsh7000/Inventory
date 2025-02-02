package com.yash.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.yash.Inventory.model.Product;
//import com.yash.Inventory.service.ProductService;
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


    @PostMapping("/OnPremProducts")
    public ResponseEntity<List<Product>> getOnPremProducts(@Valid @RequestBody List<Product> products){
        List<Product> createdProducts = productService.getOnPremProducts(products);
        return ResponseEntity.status(HttpStatus.OK).body(createdProducts);
    }
    @PostMapping("/AWSProducts")
    public ResponseEntity<List<Product>> getAWSProducts(@Valid @RequestBody List<Product> products) {
        List<Product> createdProducts = productService.getAWSProducts(products);
        return ResponseEntity.status(HttpStatus.OK).body(createdProducts);
    }
    
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
    @GetMapping("/user1")
    public String getUser1() {
		return"{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"phone\": \"123-456-7890\",\n" +
                "    \"email\": \"john.doe@example.com\"\n" +
                "}\n";

    }
    @GetMapping("/user2")
    public String getUser2() {
		return"{\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Ashu\",\n" +
                "    \"phone\": \"123-456-7890\",\n" +
                "    \"email\": \"ashu.doe@yash.com\"\n" +
                "}\n";
    }

    @GetMapping("/user3")
    public String getUser3() {
        return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"phone\": \"123-456-7890\",\n" +
                "        \"email\": \"john.doe@example.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane Smith\",\n" +
                "        \"phone\": \"987-654-3210\",\n" +
                "        \"email\": \"jane.smith@example.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Alice Johnson\",\n" +
                "        \"phone\": \"555-123-4567\",\n" +
                "        \"email\": \"alice.johnson@example.com\"\n" +
                "    }\n" +
                "]\n";
    }

    @GetMapping("/user4")
    public String getUser4() {
        return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"phone\": \"123-456-7890\",\n" +
                "        \"email\": \"ashu.doe@example.com\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane Smith KK\",\n" +
                "        \"phone\": \"987-654-3211\",\n" +
                "        \"email\": \"jane.smith@example.comm\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Johnson\",\n" +
                "        \"phone\": \"555-123-4567\",\n" +
                "        \"email\": \"alice.johnson@example.com\"\n" +
                "    }\n" +
                "]\n";
    }

    @GetMapping("/user5")
    public String getUser5() {
        return"{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"address\": {\n" +
                "        \"city\": \"New York\",\n" +
                "        \"state\": \"NY\"\n" +
                "    }\n" +
                "}\n";
    }

    @GetMapping("/user6")
    public String getUser6() {
        return"{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Ashutosh\",\n" +
                "    \"address\": {\n" +
                "        \"city\": \"INDIA\",\n" +
                "        \"state\": \"IND\"\n" +
                "    }\n" +
                "}\n";
    }

    @GetMapping("/user7")
    public String getUser7() {
        return"{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"address\": [\n" +
                "        {\n" +
                "            \"city\": \"New York\",\n" +
                "            \"state\": \"NY\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"city\": \"Los Angeles\",\n" +
                "            \"state\": \"CA\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
    }

    @GetMapping("/user8")
    public String getUser8() {
        return"{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"John De\",\n" +
                "    \"address\": [\n" +
                "        {\n" +
                "            \"city\": \"New ork\",\n" +
                "            \"state\": \"NY\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"city\": \"Los Angeles\",\n" +
                "            \"state\": \"CA\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
    }

    @GetMapping("/user9")
    public String getUser9() {
        return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"New York\",\n" +
                "            \"state\": \"NY\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane Smith\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"Los Angeles\",\n" +
                "            \"state\": \"CA\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Alice Johnson\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"Chicago\",\n" +
                "            \"state\": \"IL\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Bob Brown\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"Houston\",\n" +
                "            \"state\": \"TX\"\n" +
                "        }\n" +
                "    }\n" +
                "]\n";
    }

    @GetMapping("/user10")
    public String getUser10() {
        return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John DoSe\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"New Yk\",\n" +
                "            \"state\": \"NY\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane S\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"Los Angeles\",\n" +
                "            \"state\": \"CA\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Alice JohSnson\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"Chicago\",\n" +
                "            \"state\": \"IL\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Bob S\",\n" +
                "        \"address\": {\n" +
                "            \"city\": \"Houston\",\n" +
                "            \"state\": \"TX\"\n" +
                "        }\n" +
                "    }\n" +
                "]\n";
    }

    @GetMapping("/user11")
    public String getUser11() {
        return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"John Doe\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"New York\",\n" +
                "                \"state\": \"NY\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"Los Angeles\",\n" +
                "                \"state\": \"CA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jane Smith\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"Chicago\",\n" +
                "                \"state\": \"IL\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"Houston\",\n" +
                "                \"state\": \"TX\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Alice Johnson\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"Phoenix\",\n" +
                "                \"state\": \"AZ\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"Philadelphia\",\n" +
                "                \"state\": \"PA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Bob Brown\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"San Antonio\",\n" +
                "                \"state\": \"TX\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"San Diego\",\n" +
                "                \"state\": \"CA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]\n";
    }

    @GetMapping("/user12")
    public String getUser12() {
        return"[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Aditya Doe\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"Indore\",\n" +
                "                \"state\": \"indo\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"Ujjain\",\n" +
                "                \"state\": \"uJj\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Jth\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"dsad\",\n" +
                "                \"state\": \"IL\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"Houston\",\n" +
                "                \"state\": \"TX\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Alice Johson\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"Phoeni\",\n" +
                "                \"state\": \"AZ\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"Philadelphia\",\n" +
                "                \"state\": \"P\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Bb Brown\",\n" +
                "        \"address\": [\n" +
                "            {\n" +
                "                \"city\": \"San Antonio\",\n" +
                "                \"state\": \"TX\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"city\": \"San Diego\",\n" +
                "                \"state\": \"TA\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]\n";
    }
}