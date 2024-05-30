package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.model.Product;
import dw.wholesale_company.repository.ProductRepository;
import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
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

    // 제품 중에서 제품명에 '주스'가 포함된 제품에 대한 모든 정보를 검색하시오
    public List<Product> getProductsContainJuice() {
        return getAllProducts().stream().filter(p -> p.getProductName()
                        .contains("주스"))
                .collect(Collectors.toList());
    }

    // 제품명을 매개변수로 받아서 처리하는 것도 구현
    public List<Product> getProductsContainProductName(String productName) {
        return getAllProducts().stream()
                .filter(p -> p.getProductName().contains(productName))
                .collect(Collectors.toList());
    }

    // 제품 단가가 5,000원 이상 10,000원 이하인 제품에는 무엇이 있는지 검색하시오
    public List<Product> getProductsSerchLimitPrice() {
        return getAllProducts().stream()
                .filter(product -> product.getUnitPrice() >= 5000 && product
                        .getUnitPrice() <= 10000)
                .collect(Collectors.toList());
    }

    // lowLimit과 highLimit으로 매개변수 처리하는 것도 구현
    public List<Product> getProductsSearchByPriceRange(long lowLimit, long highLimit) {
        return getAllProducts().stream()
                .filter(product -> product.getUnitPrice() >= lowLimit && product.getUnitPrice() <= highLimit)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByIds(List<Long> productIds) {
        return productRepository.findAllById(productIds);
    }

    //제품 제품번호가 1, 2, 4, 7, 11, 20인 제품의 모든 정보를 보이시오.
    public List<Product> getProductByIdWithList(List<Long> idList) {
        List<Product> productList = productRepository.findAll();
/*        List<Product> newProducts = new ArrayList<>();
        for(int i=0; i<productList.size(); i++) {
            for(int j=0; j< idList.size(); j++) {
                if (productList.get(i).getProductId() == idList.get(j)) {
                    newProducts.add(productList.get(i));
                }
            }
        }
        return newProducts;*/
        return productList.stream().filter(product -> idList.contains(product.getProductId()))
                .collect(Collectors.toList());

    }

    //제품 재고금액이 높은 상위 10개 제품
    public List<Product> getProductByInventoryPrice(int limit) {
        List<Product> productList = productRepository.findAll();
        return productList.stream().sorted(Comparator.comparingInt(
                        (Product p) -> p.getUnitPrice() * p.getInventory()).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
