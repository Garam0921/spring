package dw.wholesale_company.service;

import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. 제품의 재고가 50개 미만인 제품 정보 얻기
    public List<Product> getProductByInventoryUnder(int num) {
        List<Product> productList = productRepository.findAll();
        return productList.stream().filter(p -> p.getInventory() < num)
                .collect(Collectors.toList());
    }

    // 제품 중에서 제품명에 '주스'가 포함된 제품에 대한 모든 정보를 검색하시요
    public List<Product> getProductsContainJuice() {
        return getAllProducts().stream().filter(product -> product.getProductName()
                .contains("주스"))
                .collect(Collectors.toList());
    }
}
