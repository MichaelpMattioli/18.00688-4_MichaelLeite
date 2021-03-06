package br.maua.model;

import br.maua.enumerates.AnimalClasses;
import br.maua.interfaces.Eat;
import br.maua.interfaces.Walk;

/**
 * Representação da abstração dos animais. Ela assina a implementação das interfaces Walk e Eat.
 * @author Murilo Zanini de Carvalho - murilo.carvalho@maua.br
 * @since 01/06/2020
 * @version 1.0
 */
public abstract class Animal implements Walk, Eat {
    private AnimalClasses animalClass;
    private String name;

    /**
     *
     * @param animalClass Enumeração
     * @param name
     */

    public Animal(AnimalClasses animalClass, String name) {
        this.animalClass = animalClass;
        this.name = name;
    }

    /**
     *
     * @return
     */

    public AnimalClasses getAnimalClass() {
        return animalClass;
    }

    public String getName() {
        return name;
    }
}
