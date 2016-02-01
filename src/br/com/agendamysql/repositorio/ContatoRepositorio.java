package br.com.agendamysql.repositorio;

import br.com.agendamysql.modelo.Contato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContatoRepositorio extends RepositorioGenerico<Contato> {

    private EntityManager manager;
    private Contato contato;
    private List<Contato> contatos;

    public Contato contatoPorId(Long idContato) {
        contato = new Contato();
        this.manager = getEntityManager();
        this.contato = this.manager.find(Contato.class, idContato);
        this.manager.close();
        return this.contato;
    }

    public void excluir(Contato contato) {
        this.manager = getEntityManager();
        this.contato = this.manager.find(Contato.class, contato.getId());
        this.manager.getTransaction().begin();
        this.manager.remove(this.contato);
        this.manager.getTransaction().commit();
        this.manager.close();
    }

    public List<Contato> listaContatos() {
        this.manager = getEntityManager();
        Query query = this.manager.createQuery("SELECT contato FROM Contato contato ORDER BY contato.nome");
        this.contatos = query.getResultList();
        this.manager.close();
        return this.contatos;
    }
}
