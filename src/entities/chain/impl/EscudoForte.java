package entities.chain.impl;
import entities.chain.Escudo;

public class EscudoForte extends Escudo {
    public EscudoForte(int carga){
        super(carga);
        this.defesa = 15;
    }
    public  void adcCarga(Escudo escudo){
        if(escudo instanceof EscudoForte) this.carga += escudo.getCarga();
    }
}
