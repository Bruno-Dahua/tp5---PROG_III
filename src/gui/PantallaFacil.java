package gui;

import modelo.SudokuTableModel;
import rederer.SudokuCellRenderer;
import logica.Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaFacil extends JFrame {
    private JPanel panelFacil;
    private JTable tablaFacil;
    private JButton RESOLVERButton;
    private JButton DESHACERButton;
    private JButton SOLUCIONButton;
    private JButton SALIRButton;

    private final int[][] completo = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    private int[][] incompleto = {
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

    public PantallaFacil() {

        // Inicializo panel y botones
        panelFacil = new JPanel();
        RESOLVERButton = new JButton("RESOLVER");
        DESHACERButton = new JButton("ELIMINAR");
        SOLUCIONButton = new JButton("SOLUCION");
        SALIRButton = new JButton("SALIR");

        setContentPane(panelFacil);
        panelFacil.setLayout(new BorderLayout());

        tablaFacil = new JTable(new SudokuTableModel(incompleto));
        tablaFacil.setRowHeight(40);
        tablaFacil.setFont(new Font("Arial", Font.PLAIN, 20));
        tablaFacil.setCellSelectionEnabled(true);
        tablaFacil.setDefaultRenderer(Object.class, new SudokuCellRenderer(completo, incompleto));

        panelFacil.add(new JScrollPane(tablaFacil), BorderLayout.CENTER);

        //instancio la clase para usar metodos
        Logica logicaFacil = new Logica();

        //panel de botones
        JPanel buttonPanel = new JPanel();
        panelFacil.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(RESOLVERButton);

        RESOLVERButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (logicaFacil.checkSolucion(tablaFacil, completo)) {
                    JOptionPane.showMessageDialog(PantallaFacil.this, "¡Excelente! Resolviste el Sudoku.");
                } else {
                    JOptionPane.showMessageDialog(PantallaFacil.this, "Hay errores en tu solución.");
                    logicaFacil.resetFacil(incompleto, tablaFacil, completo);
                }
            }
        });

        buttonPanel.add(DESHACERButton);

        DESHACERButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logicaFacil.resetFacil(incompleto, tablaFacil, completo);
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
                setVisible(false);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }



}
