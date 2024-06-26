package modelo;

import javax.swing.table.AbstractTableModel;

public class SudokuTableModel extends AbstractTableModel {
    private final int[][] data;

    public SudokuTableModel(int[][] data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return 9;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data[rowIndex][columnIndex] == 0) {
            return "";
        } else {
            return data[rowIndex][columnIndex];
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex] == 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue.toString().matches("\\d")) {
            data[rowIndex][columnIndex] = Integer.parseInt(aValue.toString());
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}


