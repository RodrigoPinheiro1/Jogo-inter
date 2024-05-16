package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.exception.AtributosZeradosExcetion;
import inter.testetecnicointer.exception.NumeroPlayersInvalidoException;
import inter.testetecnicointer.model.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static inter.testetecnicointer.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidaPlayersTest {

    @InjectMocks
    private ValidaPlayers validaPlayers;

    @BeforeEach
    void setUp() {
    }

    @Test
    void validarNumeroMaximoJogadores() {

        List<Hero> heroes = new ArrayList<>();

        heroes.add(HERO);
        heroes.add(HERO);
        heroes.add(HERO);
        heroes.add(HERO);
        heroes.add(HERO);

        PARTY_5_Heroes.setHeroes(heroes);

        validaPlayers.validarNumeroMaximoJogadores(PARTY_5_Heroes);

        assertDoesNotThrow(NumeroPlayersInvalidoException::new);

    }

    @Test
    void DevevalidarNumeroMaximoJogadoresFaltando() {

        List<Hero> heroes = new ArrayList<>();

        heroes.add(HERO);
        heroes.add(HERO);

        PARTY.setHeroes(heroes);

        assertThrows(NumeroPlayersInvalidoException.class,
                () -> validaPlayers.validarNumeroMaximoJogadores(PARTY));


    }

    @Test
    void DeveLancarExceptionAoValidarManaHealthZerados() {


        HERO.setHealth(0);
        HERO.setMana(0);

        assertThrows(AtributosZeradosExcetion.class,
                () -> validaPlayers.validarManaHealthZerados(HERO));


    }

    @Test
    void validarManaHealthZerados() {

        validaPlayers.validarManaHealthZerados(HERO);

        assertDoesNotThrow(AtributosZeradosExcetion::new);

    }


}