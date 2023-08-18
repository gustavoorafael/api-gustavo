package gustavo.elin.api.repository;

import gustavo.elin.api.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
