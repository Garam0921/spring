package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity< >(productService.getAllProducts(),
                HttpStatus.OK);
    }

    @GetMapping("/products/inventory/under/{num}")
    public ResponseEntity<List<Product>> getProductByInventoryUnder(@PathVariable int num) {
        return new ResponseEntity<>(productService.getProductByInventoryUnder(num),
                HttpStatus.OK);
    }

    @GetMapping("/products/contain/juice")
    public ResponseEntity<List<Product>> getProductsContainJuice() {
        List<Product> products = productService.getProductsContainJuice();
        if (products.isEmpty()) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(products,
                HttpStatus.OK);
    }
}
