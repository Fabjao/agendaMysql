package br.com.agendamysql.controller;

import br.com.agendamysql.modelo.Telefone;
import br.com.agendamysql.repositorio.TelefoneRepositorio;

public class TelefoneController {

    private TelefoneRepositorio telefoneRepositorio;

    public TelefoneController() {
        this.telefoneRepositorio = new TelefoneRepositorio();
    }

    public void salvar(Telefone telefone) {
        this.telefoneRepositorio.salva(telefone);
    }

    public void excluiPeloId(Long idTelefone) {
        Telefone telefone = new Telefone();
        telefone = this.telefoneRepositorio.buscaPeloId(idTelefone);
        this.telefoneRepositorio.excluir(telefone);
    }
}
