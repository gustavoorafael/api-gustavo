package gustavo.elin.api.repository;

import gustavo.elin.api.model.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Integrante, Long> {
}
