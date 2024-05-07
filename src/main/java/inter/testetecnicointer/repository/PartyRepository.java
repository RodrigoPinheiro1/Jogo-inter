package inter.testetecnicointer.repository;

import inter.testetecnicointer.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party,Long>{

}
