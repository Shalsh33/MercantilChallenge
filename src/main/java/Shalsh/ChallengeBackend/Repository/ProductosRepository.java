package Shalsh.ChallengeBackend.Repository;

import Shalsh.ChallengeBackend.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, String> {

    @Query(value = "SELECT * FROM productos WHERE id_producto = :id", nativeQuery = true)
    Producto getOne(@Param("id") String id);

}
