package br.com.agendamysql.repositorio;

import br.com.agendamysql.modelo.Telefone;

public class TelefoneRepositorio extends RepositorioGenerico<Telefone> {

    private Telefone telefone;

    public Telefone buscaPeloId(Long idTelefone) {
        this.manager = getEntityManager();
        this.telefone = new Telefone();
        this.telefone = this.manager.find(Telefone.class, idTelefone);
        this.manager.close();
        return this.telefone;
    }

    public void excluir(Telefone telefone) {
        this.manager = getEntityManager();
        this.manager.getTransaction().begin();
        this.telefone = this.manager.find(Telefone.class, telefone.getId());
        this.manager.remove(this.telefone);
        this.manager.getTransaction().commit();
        this.manager.close();
    }
}
