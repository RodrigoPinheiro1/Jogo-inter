package inter.testetecnicointer.validations;

import inter.testetecnicointer.exception.AtributosZeradosExcetion;
import inter.testetecnicointer.exception.NumeroPlayersInvalidoException;
import inter.testetecnicointer.model.Hero;
import inter.testetecnicointer.model.Party;
import org.springframework.stereotype.Component;

@Component
public class ValidaPlayers {

    public void validarNumeroMaximoJogadores(Party partyDTO) {

        if (partyDTO.getHeroes().size() != 5) {
            throw new NumeroPlayersInvalidoException();
        }

    }

    public void validarManaHealthZerados(Hero hero) {
        if (hero.getMana() == 0 || hero.getHealth() == 0) {

            throw new AtributosZeradosExcetion();

        }

    }
}
