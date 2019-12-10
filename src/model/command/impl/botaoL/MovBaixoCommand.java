package model.command.impl.botaoL;

import model.command.Command;
import model.observer.Jogador;

public class MovBaixoCommand implements Command {

    private Jogador jogador;

    public MovBaixoCommand(Jogador jogador) {
        this.jogador = jogador;
    }


    @Override
    public void execute() {
        this.jogador.baixo();
    }
}