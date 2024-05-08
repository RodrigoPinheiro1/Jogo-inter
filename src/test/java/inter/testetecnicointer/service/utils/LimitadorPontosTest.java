package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.model.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static inter.testetecnicointer.ConstantTest.HERO;
import static inter.testetecnicointer.ConstantTest.PARTY;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LimitadorPontosTest {


    @InjectMocks
    private LimitadorPontos limitadorPontos;

    @BeforeEach
    void setUp() {
    }


    @Test
    public void testSomaIntervaloMorale() {
        PARTY.setMorale(980);

        // Chame o método a ser testado
        limitadorPontos.somaIntervaloMorale(PARTY);

        // Verifique se o morale foi atualizado corretamente
        assertEquals(1000, PARTY.getMorale()); // Morale deve ser 1000 após a soma
    }

    @Test
    public void testSomaIntervaloMoraleNaoDevePassarDeMil() {
        PARTY.setMorale(1000);


        limitadorPontos.somaIntervaloMorale(PARTY);


        assertEquals(1000, PARTY.getMorale());
    }


    @Test
    public void testSomaIntervaloHealthMana() {

        HERO.setHealth(95);
        HERO.setMana(98); // Mana inicial de 98


        limitadorPontos.somaIntervaloHealthMana(HERO);


        assertEquals(97, HERO.getHealth()); // Health deve ser 97 após a soma
        assertEquals(100, HERO.getMana()); // Mana deve ser 100 após a soma
    }


    @Test
    public void testLimitaPontosSomaMana() {

        HERO.setMana(99);


        limitadorPontos.limitaPontosSomaMana(HERO);

        // Verifique se a mana foi limitada corretamente
        assertEquals(100, HERO.getMana()); // Mana deve ser 100 (máximo) após a soma
    }

    @Test
    public void testLimitaPontosSubtracaoMorale() {

        PARTY.setMorale(50); // Morale inicial

        HERO.setParty(PARTY);


        limitadorPontos.limitaPontosSubtracaoMorale(HERO);

        // Verifique se a morale foi subtraída corretamente
        assertEquals(40, HERO.getParty().getMorale()); // Morale deve ser 40 após a subtração
    }

    @Test
    public void testLimitaPontosSubtracaoHealth() {

        PARTY.setMorale(50); // Morale inicial

        HERO.setHealth(50); // Health inicial

        HERO.setParty(PARTY);

        limitadorPontos.limitaPontosSubtracaoHealth(HERO);

        // Verifique se o health e a morale foram subtraídos corretamente
        assertEquals(40, HERO.getHealth()); // Health deve ser 40 após a subtração
        assertEquals(40, HERO.getParty().getMorale()); // Morale também deve ser 40 após a subtração
    }

    @Test
    public void testLimitaPontosSubtracaoMana() {

        PARTY.setMorale(50); // Morale inicial

        HERO.setMana(50); // Mana inicial

        HERO.setParty(PARTY);

        limitadorPontos.limitaPontosSubtracaoMana(HERO);

        // Verifique se a mana e a morale foram subtraídas corretamente
        assertEquals(40, HERO.getMana());
        assertEquals(40, HERO.getParty().getMorale());
    }

}