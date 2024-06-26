package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame{
    private JButton FACILButton;
    private JButton INTERMEDIOButton;
    private JButton DIFICILButton;
    private JButton SALIRButton;
    private JPanel panelPrincipal;

    public PantallaPrincipal(){
        setContentPane(this.panelPrincipal);
        setSize(500,500);


        FACILButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaFacil pantallaFacil = new PantallaFacil();
                pantallaFacil.setVisible(true);
                pantallaFacil.setTitle("Sudoku FACIL");
                pantallaFacil.setLocationRelativeTo(null);
                pantallaFacil.pack();
            }
        });

        INTERMEDIOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaIntermedio pantallaIntermedio = new PantallaIntermedio();
                pantallaIntermedio.setVisible(true);
                pantallaIntermedio.setTitle("Sudoku INTERMEDIO");
                pantallaIntermedio.setLocationRelativeTo(null);
                pantallaIntermedio.pack();
            }
        });


        DIFICILButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaDificil pantallaDificil = new PantallaDificil();
                pantallaDificil.setVisible(true);
                pantallaDificil.setTitle("Sudoku DIFICIL");
                pantallaDificil.setLocationRelativeTo(null);
                pantallaDificil.pack();
            }
        });


        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
