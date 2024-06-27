package rederer;

import javax.swing.*;
import javax.swing.border.Border;
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
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            // Configuración del borde
            Border border = BorderFactory.createMatteBorder(
                    row % 3 == 0 ? 2 : 1, // Top border
                    col % 3 == 0 ? 2 : 1, // Left border
                    (row + 1) % 3 == 0 ? 2 : 1, // Bottom border
                    (col + 1) % 3 == 0 ? 2 : 1, // Right border
                    Color.BLACK
            );

            if (isSelected) {
                cell.setBackground(table.getSelectionBackground());
                cell.setForeground(table.getSelectionForeground());
            } else {
                cell.setBackground(table.getBackground());
                cell.setForeground(table.getForeground());
            }

            cell.setFont(new Font("Arial", Font.PLAIN, 20));
            ((JComponent) cell).setBorder(border);

            return cell;

    }
}

