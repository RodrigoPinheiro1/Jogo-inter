package inter.testetecnicointer.service.utils;

import inter.testetecnicointer.model.Hero;
import inter.testetecnicointer.model.Party;
import org.springframework.stereotype.Component;

@Component
public class LimitadorPontos {



    public void somaIntervaloMorale(Party party) {
        Integer morale = party.getMorale();

        int newMorale = Math.min(morale + 20, 1000);
        party.setMorale(newMorale);
    }

    public void somaIntervaloHealthMana(Hero hero) {

        int maxHealth = 100;
        int maxMana = 100;

        int currentHealth = hero.getHealth();
        int currentMana = hero.getMana();

        int newHealth = Math.min(currentHealth + 2, maxHealth);
        int newMana = Math.min(currentMana + 2, maxMana);


        hero.setHealth(newHealth);
        hero.setMana(newMana);

    }

    public void limitaPontosSomaHealth(Hero hero) {

        int maxHealth = 100;

        int currentHealth = hero.getHealth();

        int newHealth = Math.min(currentHealth + 1, maxHealth);

        hero.setHealth(newHealth);
    }

    public void limitaPontosSomaMana(Hero hero) {

        int maxMana = 100;

        int currentMana = hero.getMana();

        int newMana = Math.min(currentMana + 1, maxMana);
        hero.setMana(newMana);

    }


    public void limitaPontosSubtracaoMorale(Hero hero) {

        Integer morale = hero.getParty().getMorale();

        int newMorale = Math.max(morale - 10, 0);

        hero.getParty().setMorale(newMorale);
    }

    public void limitaPontosSubtracaoHealth(Hero hero) {

        Integer morale = hero.getParty().getMorale();

        int currentHealth = hero.getHealth();

        int newHealth = Math.max(currentHealth - 10, 0);

        int newMorale = Math.max(morale - 10, 0);

        hero.setHealth(newHealth);
        hero.setHealth(newHealth);

        limitaPontosSubtracaoMorale(hero);

        hero.getParty().setMorale(newMorale);
    }

    public void limitaPontosSubtracaoMana(Hero hero) {

        int currentMana = hero.getMana();
        int newMana = Math.max(currentMana - 10, 0);

        hero.setMana(newMana);

        limitaPontosSubtracaoMorale(hero);

    }

}
