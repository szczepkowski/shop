package pl.great.shop.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.great.shop.model.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ProductRepositoryTest {

    public static final String TEST_TITLE = "TEST_TITLE";
    public static final String TEST_DESC = "TEST_DESC";
    public static final BigDecimal TEST_PRICE = BigDecimal.TEN;

    @Autowired
    private ProductRepository repository;

    private Product product;

    @BeforeEach
    public void setup() {
        product = this.repository.create(new Product(TEST_TITLE, TEST_DESC, TEST_PRICE));
    }

    @AfterEach
    public void tearDown() {
        this.repository.deleteAll();
    }

    @Test
    void create() {
        assertNotNull(product.getId());
    }

    @Test
    void get() {
        Product saved = this.repository.get(product.getId());

        assertNotNull(saved.getId());
    }

    @Test
    void delete() {
        this.repository.delete(product.getId());

        Product removed = this.repository.get(product.getId());

        assertNull(removed);
    }

    @Test
    void update() {
        Product update = new Product("TEST", "TEST", product.getPrice());
        update.setId(product.getId());

        this.repository.update(update);
    }
}