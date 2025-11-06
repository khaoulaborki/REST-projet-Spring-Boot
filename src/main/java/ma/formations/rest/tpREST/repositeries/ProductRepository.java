package ma.formations.rest.tpREST.repositeries;

import ma.formations.rest.tpREST.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
