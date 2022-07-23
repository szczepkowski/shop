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
//
//    @Transactional
//    public boolean delete(Long id) {
//
//    }

    public Product get(Long id) {
        return this.entityManager.find(Product.class, id);
    }

}
