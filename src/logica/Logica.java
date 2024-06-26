package logica;

import modelo.SudokuTableModel;
import rederer.SudokuCellRenderer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class Logica {
    public boolean checkSolucion(JTable tablaFacil, int[][] solucion) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Object value = tablaFacil.getValueAt(row, col);
                if (value == null || !value.toString().matches("\\d")) {
                    return false;
                }
                int num = Integer.parseInt(value.toString());
                if (num != solucion[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetFacil(int [][] puzzle, JTable tablaFacil, int [][] solucion) {
        int[][] originalPuzzle = {
                {5, 3, 0, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 0, 5, 3, 4, 8},
                {1, 0, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 0, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 0, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 0, 9}
        };

        // Restablecer las celdas en el modelo de datos
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                puzzle[row][col] = originalPuzzle[row][col];
            }
        }

        // Crear un nuevo modelo de tabla con el estado original
        SudokuTableModel newModel = new SudokuTableModel(puzzle);
        tablaFacil.setModel(newModel);
        tablaFacil.setDefaultRenderer(Object.class, new SudokuCellRenderer(solucion, puzzle));

        // Notificar al modelo de la tabla para que actualice la vista
        ((AbstractTableModel) tablaFacil.getModel()).fireTableDataChanged();
    }

    public void resetIntermedio(int [][] puzzle, JTable tablaIntermedio, int [][] solucion){
        int[][] originalPuzzle = {
                {3, 0, 2, 0, 0, 0, 0, 8, 9},
                {0, 6, 8, 0, 5, 2, 7, 3, 4},
                {0, 0, 9, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 8, 3, 2, 0, 1, 5, 9, 0},
                {0, 0, 0, 5, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 2, 0, 0},
                {2, 1, 4, 7, 8, 0, 3, 5, 0},
                {5, 3, 0, 0, 0, 0, 9, 0, 8}
        };
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                puzzle[row][col] = originalPuzzle[row][col];
            }
        }

        // Crear un nuevo modelo de tabla con el estado original
        SudokuTableModel newModel = new SudokuTableModel(puzzle);
        tablaIntermedio.setModel(newModel);
        tablaIntermedio.setDefaultRenderer(Object.class, new SudokuCellRenderer(solucion, puzzle));

        // Notificar al modelo de la tabla para que actualice la vista
        ((AbstractTableModel) tablaIntermedio.getModel()).fireTableDataChanged();

    }

    public void resetDificil(int[][] puzzle, JTable tablaDificil, int[][] solucion){
        int [][] originalPuzzle = {
                {0, 8, 0, 0, 0, 0, 0, 0, 9},
                {0, 0, 0, 2, 0, 0, 0, 0, 4},
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 7, 0, 0}
        };
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                puzzle[row][col] = originalPuzzle[row][col];
            }
        }

        // Crear un nuevo modelo de tabla con el estado original
        SudokuTableModel newModel = new SudokuTableModel(puzzle);
        tablaDificil.setModel(newModel);
        tablaDificil.setDefaultRenderer(Object.class, new SudokuCellRenderer(solucion, puzzle));

        // Notificar al modelo de la tabla para que actualice la vista
        ((AbstractTableModel) tablaDificil.getModel()).fireTableDataChanged();
    }

    public void solucion(int [][] puzzle, JTable tablaFacil, int [][] solucion){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                puzzle[row][col] = solucion[row][col];
            }
        }

        // Crear un nuevo modelo de tabla con el estado original
        SudokuTableModel newModel = new SudokuTableModel(puzzle);
        tablaFacil.setModel(newModel);
        tablaFacil.setDefaultRenderer(Object.class, new SudokuCellRenderer(solucion, puzzle));

        // Notificar al modelo de la tabla para que actualice la vista
        ((AbstractTableModel) tablaFacil.getModel()).fireTableDataChanged();
    }
}
