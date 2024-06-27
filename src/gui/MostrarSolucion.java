package gui;

import modelo.SudokuTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarSolucion extends JFrame{
    private JTable tablaMostrar;
    private JPanel panelMostrar;
    private JButton SALIRButton;

    public MostrarSolucion(int[][] solucion) {
        setTitle("Solución del Sudoku");

        // Inicializar panel y botón
        panelMostrar = new JPanel();
        SALIRButton = new JButton("SALIR");

        setContentPane(panelMostrar);
        panelMostrar.setLayout(new BorderLayout());

        tablaMostrar = new JTable(new SudokuTableModel(solucion));
        tablaMostrar.setRowHeight(40);
        tablaMostrar.setFont(new Font("Arial", Font.PLAIN, 20));
        tablaMostrar.setEnabled(false);  // Deshabilitar la edición

        panelMostrar.add(new JScrollPane(tablaMostrar), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(SALIRButton);
        panelMostrar.add(buttonPanel, BorderLayout.SOUTH);

        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
