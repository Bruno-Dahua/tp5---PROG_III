package gui;

import logica.Logica;
import modelo.SudokuTableModel;
import rederer.SudokuCellRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDificil extends  JFrame{
    private JPanel panelDificil;
    private JTable tablaDificil;
    private JButton RESOLVERButton;
    private JButton DESHACERButton;
    private JButton SOLUCIONButton;
    private JButton SALIRButton;

    private final int [][] completo = {
            {6, 8, 2, 4, 3, 5, 1, 7, 9},
            {7, 1, 5, 2, 9, 6, 3, 8, 4},
            {9, 4, 3, 8, 7, 1, 6, 2, 5},
            {2, 7, 1, 6, 8, 9, 5, 4, 3},
            {4, 6, 9, 3, 5, 7, 8, 1, 2},
            {5, 3, 8, 1, 4, 2, 9, 6, 7},
            {8, 2, 7, 9, 6, 3, 4, 5, 1},
            {3, 5, 4, 7, 1, 8, 2, 9, 6},
            {1, 9, 6, 5, 2, 4, 7, 3, 8}
    };

    private int [][] incompleto = {
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

    public PantallaDificil(){
        panelDificil = new JPanel();
        RESOLVERButton = new JButton("RESOLVER");
        DESHACERButton = new JButton("ELIMINAR");
        SOLUCIONButton = new JButton("SOLUCION");
        SALIRButton = new JButton("SALIR");

        setContentPane(panelDificil);
        panelDificil.setLayout(new BorderLayout());

        tablaDificil = new JTable(new SudokuTableModel(incompleto));
        tablaDificil.setRowHeight(40);
        tablaDificil.setFont(new Font("Arial", Font.PLAIN, 20));
        tablaDificil.setCellSelectionEnabled(true);
        tablaDificil.setDefaultRenderer(Object.class, new SudokuCellRenderer(completo, incompleto));

        panelDificil.add(new JScrollPane(tablaDificil), BorderLayout.CENTER);

        Logica logicaDificil = new Logica();

        JPanel buttonPanel = new JPanel();
        panelDificil.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(RESOLVERButton);

        RESOLVERButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (logicaDificil.checkSolucion(tablaDificil, completo)) {
                    JOptionPane.showMessageDialog(PantallaDificil.this, "¡Excelente! Resolviste el Sudoku.");
                } else {
                    JOptionPane.showMessageDialog(PantallaDificil.this, "Hay errores en tu solución.");
                    logicaDificil.resetDificil(incompleto, tablaDificil, completo);
                }
            }
        });

        buttonPanel.add(DESHACERButton);

        DESHACERButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logicaDificil.resetDificil(incompleto, tablaDificil, completo);
            }
        });

        buttonPanel.add(SOLUCIONButton);

        SOLUCIONButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MostrarSolucion(completo);
            }
        });

        buttonPanel.add(SALIRButton);

        SALIRButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
