package inter.testetecnicointer.dto;

import inter.testetecnicointer.model.CombateResultado;
import inter.testetecnicointer.model.CombateStatus;
import inter.testetecnicointer.model.TipoCombate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDTOResponse {

    private Long id;
    private String name;
    private Integer health;
    private Integer mana;
    private CombateStatus combateStatus;
    private CombateResultado combateResultado;
    private TipoCombate tipoCombate;




}
