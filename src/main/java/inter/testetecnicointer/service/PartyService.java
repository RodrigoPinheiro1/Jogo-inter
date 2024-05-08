package inter.testetecnicointer.service;

import inter.testetecnicointer.dto.PartyDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartyService {
    PartyDTO combater(Long id, String combatType, String combatResult);

    Page<PartyDTO> situacaoParty(Pageable pageable);

}
