package inter.testetecnicointer.service.impl;

import inter.testetecnicointer.dto.HeroDTO;
import inter.testetecnicointer.dto.PartyDTO;
import inter.testetecnicointer.exception.EntityNotFound;
import inter.testetecnicointer.model.CombateStatus;
import inter.testetecnicointer.model.Hero;
import inter.testetecnicointer.model.Party;
import inter.testetecnicointer.repository.HeroiRepository;
import inter.testetecnicointer.repository.PartyRepository;
import inter.testetecnicointer.service.PartyService;
import inter.testetecnicointer.service.utils.LimitadorPontos;
import inter.testetecnicointer.service.utils.ResultadoCombate;
import inter.testetecnicointer.validation.ValidaQuantidadePlayers;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {


    private final ResultadoCombate resultadoCombate;


    private final PartyRepository partyRepository;

    private final ModelMapper modelMapper;


    private final LimitadorPontos limitadorPontos;


    private final HeroiRepository heroiRepository;


    @Override
    public PartyDTO combater(Long heroId, String combatType, String combatResult) {


        Hero hero = heroiRepository.findById(heroId).orElseThrow(EntityNotFound::new);

        partyRepository.findById(hero.getParty().getId()).orElseThrow(EntityNotFound::new);

        hero.setId(heroId);
        hero.setCombateStatus(CombateStatus.COMBATE);
        heroiRepository.save(hero);

        resultadoCombate.combateResultado(hero, combatType, combatResult);

        ValidaQuantidadePlayers.validar(hero.getParty());

        hero.setId(heroId);
        hero.setCombateStatus(CombateStatus.DESCANSO);
        heroiRepository.save(hero);

        HeroDTO heroDTO = modelMapper.map(hero, HeroDTO.class);

        return heroDTO.getParty();

    }

    @Override
    public Page<PartyDTO> situacaoParty(Pageable pageable) {

        return partyRepository.findAll(pageable).map(party -> modelMapper.map(party, PartyDTO.class));
    }


    public void recoverHeroes() {

        List<Hero> heroes = heroiRepository.findAll();

        heroes.forEach(hero -> {

            if (hero.getCombateStatus() == CombateStatus.DESCANSO) {
                limitadorPontos.somaIntervaloHealthMana(hero);
            }


        });
        heroiRepository.saveAll(heroes);
    }


    public void recoverMorale() {

        List<Party> parties = partyRepository.findAll();


        parties.forEach(party -> {

            Integer morale = party.getMorale();

            int newMorale = Math.min(morale + 20, 1000);
            party.setMorale(newMorale);


        });

        partyRepository.saveAll(parties);


    }

}
