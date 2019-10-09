package entities.personagem.impl;

import entities.auxiliars.Posicao;
import entities.auxiliars.SetTimeout;
import entities.estrategias.impl.AtaqueForte;
import entities.estrategias.impl.AtaqueFraco;
import entities.estrategias.impl.PuloBaixo;
import entities.estrategias.impl.VelocidadeDevagar;
import entities.personagem.Personagem;

import java.util.Observable;
import java.util.Observer;

public class Inimigo extends Personagem implements Observer {

    private boolean podeAtacar = true;
    private int delayAtaque = 1000;

    public Inimigo(int x, int y) {
        super(new PuloBaixo(), new VelocidadeDevagar(), new AtaqueForte());
        setPosicao(new Posicao(x, y, this));
        setAtaque(getDefaultAtaque());
        setVelocidade(getDefaultVelocidade());
    }

    public Inimigo(int x, int y, int l, int a) {
        super(l, a, new PuloBaixo(), new VelocidadeDevagar(), new AtaqueForte());
        setPosicao(new Posicao(x, y, this));
        setAtaque(getDefaultAtaque());
        setVelocidade(getDefaultVelocidade());
    }

    public void atacar(Personagem p) throws InterruptedException {
        if (podeAtacar) {
            System.out.println("\nInimigo " + this + " atacou personagem " + p);
            p.receberDano(getAtaque().forca());
            podeAtacar = false;
            SetTimeout.setTimeout(() -> podeAtacar = true, delayAtaque);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Personagem) {
            Personagem p = (Personagem) o;

            int dx = getPosicao().getX() - p.getPosicao().getX();
            int dy = getPosicao().getY() - p.getPosicao().getY();

            if ((dx > -getLargura() && dx < getLargura()) && (dy > -getAltura() && dy < getAltura())) {
                try {
                    atacar(p);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (p.getPosicao().getX() > getPosicao().getX()) getPosicao().movLeste();
                else getPosicao().movOeste();

                if (p.getPosicao().getY() > getPosicao().getY()) getPosicao().movSul();
                else getPosicao().movNorte();
            }
        }
    }
}