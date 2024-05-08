package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.service.impl.PartyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class RecoveryServiceImpl {


    private final PartyServiceImpl partyService;

    @Scheduled(fixedRate = 10000) // Executa a cada 10 segundos
    public void recover() {
        partyService.recoverHeroes();
        partyService.recoverMorale();
    }


}
