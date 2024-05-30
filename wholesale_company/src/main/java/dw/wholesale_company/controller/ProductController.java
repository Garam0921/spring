package dw.wholesale_company.controller;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 제품명을 매개변수로 받아서 처리하는 것도 구현
    @GetMapping("/products/{productName}")
    public ResponseEntity<List<Product>> getProductsContainProductName(@PathVariable String productName) {
        List<Product> products = productService.getProductsContainProductName(productName);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/search/limit/price")
    private ResponseEntity<List<Product>> getProductsSearchLimitPrice() {
        List<Product> products = productService.getProductsSerchLimitPrice();
        if (products.isEmpty()) {
            return new ResponseEntity<>(products,
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(products,
                    HttpStatus.OK);
        }
    }

    @GetMapping("/products/idlist")
    public ResponseEntity<List<Product>> getProductByIdWithList(@RequestBody List<Long> idList) {
        return new ResponseEntity<>(productService.getProductByIdWithList(idList),
                HttpStatus.OK);
    }

    @GetMapping("/products/inventoryprice/{limit}")
    public ResponseEntity<List<Product>> getProductByInventoryPrice(@PathVariable int limit) {
        return new ResponseEntity<>(productService.getProductByInventoryPrice(limit),
                HttpStatus.OK);
    }


}
