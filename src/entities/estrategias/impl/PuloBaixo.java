package entities.estrategias.impl;

import entities.estrategias.Pulo;

public class PuloBaixo implements Pulo {

    @Override
    public void pular() {
        System.out.println("Pulo Baixo");
    }
}