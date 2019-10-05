package entities;

public class EstadoNormal extends Estado {

    public EstadoNormal(Personagem personagem) {
        super(personagem);
        personagem.setEstragetias(new PuloMedio(), new VelocidadeMedia(), new AtaqueMedio());
    }

    @Override
    protected void verificaAlteracaoEstado() {
        if (this.getPersonagem().getSaude() < 30 && this.getPersonagem().getSaude() > 0) {
            this.getPersonagem().setEstado(new EstadoPerigo(this.getPersonagem()));
        } else if (this.getPersonagem().getSaude() > 70) {
            this.getPersonagem().setEstado(new EstadoForte(this.getPersonagem()));
        }
    }
}
