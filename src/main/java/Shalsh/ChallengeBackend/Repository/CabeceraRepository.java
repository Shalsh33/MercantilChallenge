package Shalsh.ChallengeBackend.Repository;

import Shalsh.ChallengeBackend.Model.PedidoCabecera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabeceraRepository extends JpaRepository<PedidoCabecera,Long> {
    @Query(value = "SELECT * FROM pedidos_cabecera WHERE fecha_alta = :fecha",nativeQuery = true)
    List<PedidoCabecera> getAllByFecha(String fecha);
}
