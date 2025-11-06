package ma.formations.rest.tpREST.services;

import ma.formations.rest.tpREST.entities.Product;
import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product save(Product product);
    Product update(Long id, Product product);
    void delete(Long id);
}
