package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.model.CombateResultado;
import inter.testetecnicointer.model.Hero;
import inter.testetecnicointer.model.TipoCombate;
import inter.testetecnicointer.validations.ValidaPlayers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResultadoCombate {

    private final LimitadorPontos limitadorPontos;


    private final ValidaPlayers validaPlayers;

    public void combateResultado(Hero hero, String combatType, String combatResult) {


        if (combatType.equals("melee")) {
            hero.setTipoCombate(TipoCombate.melee);
            if (combatResult.equals("win")) {
                hero.setCombateResultado(CombateResultado.win);
                limitadorPontos.limitaPontosSomaHealth(hero);

            } else if (combatResult.equals("lose")) {
                hero.setCombateResultado(CombateResultado.lose);
                limitadorPontos.limitaPontosSubtracaoHealth(hero);
            }

        } else if (combatType.equals("spell")) {
            hero.setTipoCombate(TipoCombate.spell);
            if (combatResult.equals("win")) {
                hero.setCombateResultado(CombateResultado.win);
                limitadorPontos.limitaPontosSomaMana(hero);
            } else {
                hero.setCombateResultado(CombateResultado.lose);
                limitadorPontos.limitaPontosSubtracaoMana(hero);

            }


        }
        validaPlayers.validarNumeroMaximoJogadores(hero.getParty());
        validaPlayers.validarManaHealthZerados(hero);
    }
}

