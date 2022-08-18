package pl.great.shop.repository;

import org.springframework.stereotype.Repository;
import pl.great.shop.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product create(Product product) {
        this.entityManager.persist(product);
        this.entityManager.flush();
        return product;
    }

    @Transactional
    public boolean delete(Long id) {
        Product product = this.get(id);
        this.entityManager.remove(product);
        return true;
    }

    @Transactional
    public Product get(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    @Transactional
    public Product update(Product product) {

        if (product.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Product saved = this.entityManager.merge(product);
        this.entityManager.flush();

        return saved;
    }

    @Transactional
    public void deleteAll() {
        this.entityManager.createQuery("delete from Product").executeUpdate();
        this.entityManager.flush();
    }

}
