package mx.edu.utez.ExamenOrdinario.model.user;

import mx.edu.utez.ExamenOrdinario.model.products.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNombre(String nombre);
}
