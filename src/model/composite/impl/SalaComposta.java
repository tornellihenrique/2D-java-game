package model.composite.impl;

import model.composite.Sala;
import model.observer.Inimigo;
import model.observer.impl.NPC;

public class SalaComposta extends Sala {
    public Sala sala1;
    public Sala sala2;
    public Inimigo inimigo;

    public void setSalas(Sala sala1, Sala sala2){
        this.sala1 = sala1;
        this.sala2 = sala2;
        //this.inimigo = new Inimigo(0, 0);
        //inimigo.setDefaultAtaque(new AtaqueFraco());
        //double r = Math.random() * 2;
        //if(r < 1) this.inimigo.receberDano(40);
        //else this.inimigo.receberDano(20);
    }

    public SalaComposta(Sala sala1, Sala sala2, Inimigo inimigo){
        this.sala1 = sala1;
        this.sala2 = sala2;
        //this.inimigo = inimigo;
        //inimigo.setDefaultAtaque(new AtaqueFraco());
        //double r = Math.random() * 2;
        //if(r < 1) this.inimigo.receberDano(40);
        //else this.inimigo.receberDano(20);
    }

    @Override
    public Sala entrar(NPC npc) {
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
        }

        System.out.println("NPC "+npc.getNome()+" entrou na sala. A sala tem um inimigo, e mais duas entradas para salas!\n");

        double r = Math.random() * 2;

        if (r < 0.2) {
            System.out.println("NPC"+ npc.getNome() + " morreu para o inimigo!\n");
        }
        else if(r < 0.8){
            System.out.println("NPC"+ npc.getNome() + " teve que fugir do inimigo!\n");
        }
        else {
            System.out.println("NPC "+npc.getNome()+" Matou o inimigo! ");
        }




        r = Math.random() * 2;


        if (r < 1) {
            System.out.println("E ele entrou na sala 1!\n");
            sala1.entrar(npc);
        }
        else {

            System.out.println("E ele entrou na sala 2!\n");
            sala2.entrar(npc);

        }

        return this;
    }
}
