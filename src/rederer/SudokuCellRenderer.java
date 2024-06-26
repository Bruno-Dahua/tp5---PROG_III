package rederer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class SudokuCellRenderer extends DefaultTableCellRenderer {
    private final int[][] solution;
    private final int[][] puzzle;

    public SudokuCellRenderer(int[][] solution, int[][] puzzle) {
        this.solution = solution;
        this.puzzle = puzzle;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (puzzle[row][column] == 0) {
            cell.setForeground(Color.BLUE);
        } else {
            cell.setForeground(Color.BLACK);
        }
        return cell;
    }
}

