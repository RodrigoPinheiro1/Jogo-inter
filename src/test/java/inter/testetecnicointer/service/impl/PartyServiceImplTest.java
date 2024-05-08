package inter.testetecnicointer.service.impl;

import inter.testetecnicointer.dto.PartyDTO;
import inter.testetecnicointer.repository.HeroiRepository;
import inter.testetecnicointer.repository.PartyRepository;
import inter.testetecnicointer.service.utils.ResultadoCombate;
import inter.testetecnicointer.service.utils.ValidaQuantidadePlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static inter.testetecnicointer.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PartyServiceImplTest {


    @InjectMocks
    private PartyServiceImpl partyService;
    @Mock
    private ResultadoCombate resultadoCombate;

    @Mock
    private ValidaQuantidadePlayers validaQuantidadePlayers;
    @Mock
    private PartyRepository partyRepository;


    @Mock
    private ModelMapper modelMapper;


    @Mock
    private HeroiRepository heroiRepository;


    @BeforeEach
    void setUp() {


    }

//    @Test
//    void combater() {
//
//
//        // Configurando comportamento dos mocks
//        when(heroiRepository.findById(HERO.getId())).thenReturn(Optional.of(HERO));
//        when(partyRepository.findById(PARTY.getId())).thenReturn(Optional.of(PARTY));
//
//        // Chamando o método a ser testado
//        PartyDTO result = partyService.combater(1L, "melee", "win");
//
//        // Verificando resultados e interações
//        when(modelMapper.map(PARTY, PartyDTO.class)).thenReturn(PARTY_DTO);
//        assertNotNull(result);
//        assertEquals(PARTY_DTO, result);
//
//        verify(resultadoCombate).combateResultado(HERO, "melee", "win");
//        verify(validaQuantidadePlayers).validar(HERO.getParty());
//
//    }
//


}