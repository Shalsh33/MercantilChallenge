package Shalsh.ChallengeBackend.Repository;

import Shalsh.ChallengeBackend.Model.PedidoCabecera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<PedidoCabecera,Long> {
}
