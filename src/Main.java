import gui.PantallaPrincipal;

public class Main {
    public static void main(String[] args){
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);
        pantallaPrincipal.setLocationRelativeTo(null);
        pantallaPrincipal.pack();
        pantallaPrincipal.setTitle("Sudoku");
        pantallaPrincipal.setDefaultCloseOperation(pantallaPrincipal.EXIT_ON_CLOSE);
    }
}
