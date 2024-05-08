package inter.testetecnicointer.controller;

import inter.testetecnicointer.dto.PartyDTO;
import inter.testetecnicointer.service.PartyService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class CombateController {


    private final PartyService partyService;


    @GetMapping("/combat")
    public ResponseEntity<PartyDTO> registraResultadosCombate(@RequestParam @NotNull Long heroId,
                                                              @Pattern(regexp = "melee|spell") @RequestParam String combatType,
                                                              @Pattern(regexp = "win|lose") @RequestParam String combatResult) throws ChangeSetPersister.NotFoundException {

        PartyDTO partyDTO = partyService.combater(heroId, combatType, combatResult);

        return ResponseEntity.accepted().body(partyDTO);
    }

    @GetMapping("/party")
    public Page<PartyDTO> situacaoParty(Pageable pageable) {


        return partyService.situacaoParty(pageable);
    }


}
