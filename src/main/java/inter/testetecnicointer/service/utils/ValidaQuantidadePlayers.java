package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.exception.NumeroPlayersInvalidoException;
import inter.testetecnicointer.model.Party;
import org.springframework.stereotype.Component;

@Component
public class ValidaQuantidadePlayers {

    public  void validar(Party partyDTO) {

        if (partyDTO.getHeroes().size() != 5) {
            throw new NumeroPlayersInvalidoException();
        }

    }
}
