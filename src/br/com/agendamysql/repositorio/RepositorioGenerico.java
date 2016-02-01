package br.com.agendamysql.repositorio;

import javax.persistence.EntityManager;

public class RepositorioGenerico<T> extends ClasseManager {

    public EntityManager manager;

    public void salva(T t) {
        this.manager = getEntityManager();
        this.manager.getTransaction().begin();
        this.manager.persist(t);
        this.manager.getTransaction().commit();
        this.manager.close();
    }
}
