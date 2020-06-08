package br.maua.models;

import br.maua.enums.Cargos;

public class HeavyLifters extends Membros{
    public HeavyLifters(String usuario) {
        super(usuario, Cargos.HEAVY_LIFTERS);
    }
}
