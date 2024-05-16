package inter.testetecnicointer.service.impl;

import inter.testetecnicointer.dto.HeroDTO;
import inter.testetecnicointer.dto.PartyDTO;
import inter.testetecnicointer.exception.HeroNotFoundException;
import inter.testetecnicointer.exception.PartyNotFoundException;
import inter.testetecnicointer.model.Hero;
import inter.testetecnicointer.model.Party;
import inter.testetecnicointer.repository.HeroiRepository;
import inter.testetecnicointer.repository.PartyRepository;
import inter.testetecnicointer.service.utils.LimitadorPontos;
import inter.testetecnicointer.service.utils.ResultadoCombate;
import inter.testetecnicointer.validations.ValidaPlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static inter.testetecnicointer.ConstantTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PartyServiceImplTest {


    @InjectMocks
    private PartyServiceImpl partyService;
    @Mock
    private ResultadoCombate resultadoCombate;

    @Mock
    private ValidaPlayers validaPlayers;
    @Mock
    private PartyRepository partyRepository;

    @Mock
    private LimitadorPontos limitadorPontos;

    @Mock
    private ModelMapper modelMapper;


    @Mock
    private HeroiRepository heroiRepository;


    @BeforeEach
    void setUp() {


    }

    @Test
    void deveCombaterComSucessoComInformacoesCorretas() {


        // Configurando comportamento dos mocks
        when(heroiRepository.findById(1L)).thenReturn(Optional.of(HERO));
        when(partyRepository.findById(1L)).thenReturn(Optional.of(PARTY));

        when(modelMapper.map(PARTY, PartyDTO.class)).thenReturn(PARTY_DTO);
        when(modelMapper.map(HERO, HeroDTO.class)).thenReturn(HERO_DTO);

        // Chamando o método a ser testado
        PartyDTO result = partyService.combater(1L, "melee", "win");

        // Verificando resultados e interações
        assertNotNull(result);
        assertEquals(PARTY_DTO, result);

        verify(resultadoCombate).combateResultado(HERO, "melee", "win");
        // verify(validaQuantidadePlayers).validar(HERO.getParty());

    }


    @Test
    void situacaoParty() {

        List<Party> parties = new ArrayList<>();
        parties.add(PARTY);
        parties.add(PARTY);

        when(partyRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(parties));
        when(modelMapper.map(any(), eq(PartyDTO.class)))
                .thenReturn(new PartyDTO());

        Page<PartyDTO> result = partyService.situacaoParty(Pageable.unpaged());


        assertEquals(parties.size(), result.getContent().size());
        verify(partyRepository, times(1)).findAll(any(Pageable.class));
        verify(modelMapper, times(parties.size())).map(any(), eq(PartyDTO.class));

    }


    @Test
    void naoDeveRealizarCombateIdNaoExisteHeroi() {


        when(heroiRepository.findById(12L)).thenReturn(Optional.empty());

        assertThrows(HeroNotFoundException.class, ()
                -> partyService.combater(1L, "melee", "win"));
    }

    @Test
    void naoDeveRealizarCombateIdNaoExisteParty() {


        when(heroiRepository.findById(1L)).thenReturn(Optional.of(HERO));

        when(partyRepository.findById(12L)).thenReturn(Optional.empty());

        assertThrows(PartyNotFoundException.class, ()
                -> partyService.combater(1L, "melee", "win"));
    }

    @Test
    void recoverHeroes() {


        List<Hero> heroes = new ArrayList<>();

        heroes.add(HERO);
        heroes.add(HERO_DESCANSO);

        when(heroiRepository.findAll()).thenReturn(heroes);


        partyService.recoverHeroes();

        verify(limitadorPontos, times(1)).somaIntervaloHealthMana(HERO_DESCANSO);
        verify(limitadorPontos, never()).somaIntervaloHealthMana(HERO);
        verify(heroiRepository, times(1)).saveAll(heroes);

        partyService.recoverMorale();

    }

    @Test
    void recoverMorale() {


        List<Party> parties = new ArrayList<>();

        parties.add(PARTY);
        parties.add(PARTY);


        partyService.recoverMorale();

        verify(limitadorPontos, times(1)).somaIntervaloMorale(PARTY);
        verify(limitadorPontos, times(1)).somaIntervaloMorale(PARTY);

        verify(partyRepository, times(1)).saveAll(parties);


    }


}