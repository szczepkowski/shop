package pl.great.shop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.shop.model.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void create() {
        Product product = this.repository.create(new Product("1", "2", BigDecimal.ONE));
        assertNotNull(product.getId());
    }

    @Test
    void get() {
        Product product = this.repository.create(new Product("1", "2", BigDecimal.ONE));
        Product saved = this.repository.get(product.getId());

        assertNotNull(saved.getId());
    }
}