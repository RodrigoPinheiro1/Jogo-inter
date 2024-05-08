package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.model.CombateResultado;
import inter.testetecnicointer.model.Hero;
import inter.testetecnicointer.model.TipoCombate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class ResultadoCombate {

    private final LimitadorPontos limitadorPontos;

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

    }
}

