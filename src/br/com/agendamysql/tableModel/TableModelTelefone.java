package br.com.agendamysql.tableModel;

import br.com.agendamysql.modelo.Telefone;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelTelefone extends AbstractTableModel {

    private List<Telefone> telefones;
    private static final int ID = 0;
    private static final int OPERADORA = 1;
    private static final int NUMERO = 2;

    public TableModelTelefone(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public int getRowCount() {
        return this.telefones.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        if (column == ID) {
            return "Id";
        }
        if (column == OPERADORA) {
            return "Operadora";
        }
        if (column == NUMERO) {
            return "Numero";
        }
        return ""; //Nunca deve ocorrer
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Telefone telefone = this.telefones.get(linha);
        switch (coluna) {
            case ID:
                return telefone.getId();
            case OPERADORA:
                return telefone.getOperador();
            case NUMERO:
                return telefone.getNumero();
        }
        return null;
    }
}
