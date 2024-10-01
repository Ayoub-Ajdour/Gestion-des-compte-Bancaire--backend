package ma.fpl.tp2ex11.repository;

import ma.fpl.tp2ex11.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}