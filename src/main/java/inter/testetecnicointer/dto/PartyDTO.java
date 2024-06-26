package inter.testetecnicointer.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PartyDTO {


    private Long id;

    private List<HeroDTOResponse> heroes = new ArrayList<>();

    private Date timestamp = new Date();

    @Min(0)
    @Max(100)
    private Integer morale;
}
