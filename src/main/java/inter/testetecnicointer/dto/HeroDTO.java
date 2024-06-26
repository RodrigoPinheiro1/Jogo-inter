package inter.testetecnicointer.dto;

import inter.testetecnicointer.model.CombateResultado;
import inter.testetecnicointer.model.CombateStatus;
import inter.testetecnicointer.model.TipoCombate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class HeroDTO {

    private Long id;
    private String name;
    private Integer health;
    private Integer mana;
    private CombateStatus combateStatus;
    private CombateResultado combateResultado;
    private TipoCombate tipoCombate;

    private PartyDTO party;



}
