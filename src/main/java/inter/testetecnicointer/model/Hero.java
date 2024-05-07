package inter.testetecnicointer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer health = 100;
    private Integer mana = 100;
    private CombateStatus combateStatus = CombateStatus.DESCANSO;
    private CombateResultado combateResultado;

    private TipoCombate tipoCombate;
    @ManyToOne
    private Party party;

}