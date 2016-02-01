package br.com.agendamysql.repositorio;

import br.com.agendamysql.conexao.FactoryDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

class ClasseManager {

    private EntityManagerFactory factory = null;

    public ClasseManager() {
        this.factory = FactoryDAO.getInstance().criarEntityManagerFactory();
    }

    public EntityManager getEntityManager() {
        return this.factory.createEntityManager();
    }
}
