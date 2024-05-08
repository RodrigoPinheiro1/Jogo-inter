package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.model.CombateResultado;
import inter.testetecnicointer.model.TipoCombate;
import inter.testetecnicointer.validations.ValidaPlayers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static inter.testetecnicointer.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ResultadoCombateTest {


    @Mock
    private LimitadorPontos limitadorPontos;

    @Mock
    private ValidaPlayers validaPlayers;


    @InjectMocks
    private ResultadoCombate resultadoCombate;


    @Test
    public void testCombateResultadoMeleeWin() {

        HERO.setCombateResultado(CombateResultado.win);
        HERO.setTipoCombate(TipoCombate.melee);

        String combatType = "melee";
        String combatResult = "win";

        resultadoCombate.combateResultado(HERO, combatType, combatResult);


        verify(validaPlayers).validarNumeroMaximoJogadores(PARTY);
        verify(limitadorPontos).limitaPontosSomaHealth(HERO);
        assertEquals(TipoCombate.melee, HERO.getTipoCombate());
        assertEquals(CombateResultado.win, HERO.getCombateResultado());
    }

    @Test
    public void testCombateResultadoMeleeLose() {

        HERO.setCombateResultado(CombateResultado.lose);
        HERO.setTipoCombate(TipoCombate.melee);

        String combatType = "melee";
        String combatResult = "lose";

        resultadoCombate.combateResultado(HERO, combatType, combatResult);

        verify(validaPlayers).validarNumeroMaximoJogadores(PARTY);
        verify(limitadorPontos).limitaPontosSubtracaoHealth(HERO);
        assertEquals(TipoCombate.melee, HERO.getTipoCombate());
        assertEquals(CombateResultado.lose, HERO.getCombateResultado());

    }

    @Test
    public void testCombateResultadoSpellWin() {

        String combatType = "spell";
        String combatResult = "win";

        resultadoCombate.combateResultado(HERO, combatType, combatResult);

        verify(validaPlayers).validarNumeroMaximoJogadores(PARTY);
        verify(limitadorPontos).limitaPontosSomaMana(HERO);
        assertEquals(TipoCombate.spell, HERO.getTipoCombate());
        assertEquals(CombateResultado.win, HERO.getCombateResultado());

    }

    @Test
    public void testCombateResultadoSpellLose() {


        String combatType = "spell";
        String combatResult = "lose";

        resultadoCombate.combateResultado(HERO, combatType, combatResult);

        verify(validaPlayers).validarNumeroMaximoJogadores(PARTY);
        verify(limitadorPontos).limitaPontosSubtracaoMana(HERO);
        assertEquals(TipoCombate.spell, HERO.getTipoCombate());
        assertEquals(CombateResultado.lose, HERO.getCombateResultado());
    }

}