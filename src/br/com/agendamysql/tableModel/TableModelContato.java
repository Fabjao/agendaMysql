package br.com.agendamysql.tableModel;

import br.com.agendamysql.modelo.Contato;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelContato extends AbstractTableModel {

    private List<Contato> contatos;
    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int EMPRESA = 2;

    public TableModelContato(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public int getRowCount() {
        return this.contatos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        if (column == CODIGO) {
            return "Codigo";
        }
        if (column == NOME) {
            return "Nome";
        }
        if (column == EMPRESA) {
            return "Empresa";
        }
        return "";
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Contato contato = this.contatos.get(linha);
        switch (coluna) {
            case CODIGO:
                return contato.getId();
            case NOME:
                return contato.getNome();
            case EMPRESA:
                return contato.getEmpresa();
        }
        return null;
    }
}
