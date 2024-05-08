package inter.testetecnicointer;

import inter.testetecnicointer.dto.HeroDTO;
import inter.testetecnicointer.dto.PartyDTO;
import inter.testetecnicointer.model.*;

import java.util.Date;

public class ConstantTest {


    public static final Party PARTY =
            Party.builder()
                    .id(1L)
                    .morale(80)
                    .timestamp(new Date())
                    .build();

    public static final PartyDTO PARTY_DTO =
            PartyDTO.builder()
                    .id(1L)
                    .morale(80)
                    .timestamp(new Date())
                    .build();


    public static final Hero HERO =
            Hero.builder()
                    .id(1L)
                    .mana(100)
                    .name("HERO")
                    .party(PARTY)
                    .health(100)
                    .build();


    public static final HeroDTO HERO_DTO =
            HeroDTO.builder()
                    .id(1L)
                    .mana(100)
                    .name("HERO")
                    .party(PARTY_DTO)
                    .combateStatus(CombateStatus.DESCANSO)
                    .combateResultado(CombateResultado.win)
                    .tipoCombate(TipoCombate.melee)
                    .health(100)
                    .build();

}
