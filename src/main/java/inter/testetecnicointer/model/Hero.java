package inter.testetecnicointer.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
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