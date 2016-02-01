package br.com.agendamysql.conexao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryDAO {

    private static FactoryDAO singleton;
    private EntityManagerFactory emf = null;

    static {
        singleton = new FactoryDAO();
    }

    private FactoryDAO() {
        emf = Persistence.createEntityManagerFactory("agendaMysqlPU");
    }

    public EntityManagerFactory criarEntityManagerFactory() {
        return emf;
    }

    public static FactoryDAO getInstance() {
        try {
            return singleton;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
