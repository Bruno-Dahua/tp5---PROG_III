package gui;

import logica.Logica;
import modelo.SudokuTableModel;
import rederer.SudokuCellRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaIntermedio extends JFrame{
    private JPanel panelIntermedio;
    private JTable tablaIntermedio;
    private JButton RESOLVERButton;
    private JButton DESHACERButton;
    private JButton SOLUCIONButton;
    private JButton SALIRButton;

    private final int[][] completo = {
            {3, 5, 2, 4, 7, 6, 1, 8, 9},
            {1, 6, 8, 9, 5, 2, 7, 3, 4},
            {7, 4, 9, 8, 1, 3, 6, 2, 5},
            {4, 2, 5, 6, 9, 7, 8, 1, 3},
            {6, 8, 3, 2, 4, 1, 5, 9, 7},
            {9, 7, 1, 5, 3, 8, 4, 6, 2},
            {8, 9, 7, 3, 6, 5, 2, 4, 1},
            {2, 1, 4, 7, 8, 9, 3, 5, 6},
            {5, 3, 6, 1, 2, 4, 9, 7, 8}
    };

    private int[][] incompleto = {
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

    public PantallaIntermedio(){

        //inicializo panel y botones
        panelIntermedio = new JPanel();
        RESOLVERButton = new JButton("RESOLVER");
        DESHACERButton = new JButton("ELIMINAR");
        SOLUCIONButton = new JButton("SOLUCION");
        SALIRButton = new JButton("SALIR");

        setContentPane(panelIntermedio);
        panelIntermedio.setLayout(new BorderLayout());

        tablaIntermedio = new JTable(new SudokuTableModel(incompleto));
        tablaIntermedio.setRowHeight(40);
        tablaIntermedio.setFont(new Font("Arial", Font.PLAIN, 20));
        tablaIntermedio.setCellSelectionEnabled(true);
        tablaIntermedio.setDefaultRenderer(Object.class, new SudokuCellRenderer(completo, incompleto));

        panelIntermedio.add(new JScrollPane(tablaIntermedio), BorderLayout.CENTER);

        //instancio clase para usar metodos
        Logica logicaIntermedio = new Logica();

        //panel de botones
        JPanel buttonPanel = new JPanel();
        panelIntermedio.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(RESOLVERButton);

        RESOLVERButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (logicaIntermedio.checkSolucion(tablaIntermedio, completo)) {
                    JOptionPane.showMessageDialog(PantallaIntermedio.this, "¡Excelente! Resolviste el Sudoku.");
                } else {
                    JOptionPane.showMessageDialog(PantallaIntermedio.this, "Hay errores en tu solución.");
                    logicaIntermedio.resetIntermedio(incompleto, tablaIntermedio, completo);
                }
            }
        });

        buttonPanel.add(DESHACERButton);

        DESHACERButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logicaIntermedio.resetIntermedio(incompleto, tablaIntermedio, completo);
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
