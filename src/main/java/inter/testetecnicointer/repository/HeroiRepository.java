package inter.testetecnicointer.repository;

import inter.testetecnicointer.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiRepository extends JpaRepository<Hero, Long> {
}
