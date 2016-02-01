package br.com.agendamysql.controller;

import br.com.agendamysql.modelo.Contato;
import br.com.agendamysql.repositorio.ContatoRepositorio;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ContatoController {

    private ContatoRepositorio contatoRepositorio;

    public ContatoController() {
        this.contatoRepositorio = new ContatoRepositorio();
    }

    public void salva(Contato contato) {
        this.contatoRepositorio.salva(contato);
    }

    public Contato contatoPorId(Long idContato) {
        return this.contatoRepositorio.contatoPorId(idContato);
    }

    public void excluir(Contato contato) {
        this.contatoRepositorio.excluir(contato);
    }

    public List<Contato> listaContatos() {
        return this.contatoRepositorio.listaContatos();
    }

    public void relatorio(List<Contato> contatos, boolean todosContato) {
        try {
            HashMap parametros = new HashMap();
            JRBeanCollectionDataSource jrs;
            if (todosContato) {
                jrs = new JRBeanCollectionDataSource(listaContatos());
            } else {
                jrs = new JRBeanCollectionDataSource(contatos);
            }
            URL url3 = this.getClass().getResource("/Contato_subreport1.jasper");
            parametros.put("relatorio", url3);

            URL arquivo = getClass().getResource("/Contato.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(arquivo);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, jrs);
            JasperViewer jrv = new JasperViewer(jp, false);
            jrv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
