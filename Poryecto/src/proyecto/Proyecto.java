package proyecto;
//@author Leonardo Estrada, Mariana Correa, Ana Laura Gervacio, Julia Ruiz, Lissandro Perez.
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Proyecto {

 
    public static void main(String[] args) {
          SwingUtilities.invokeLater(()->{
            
            Ventana ventana = new Ventana();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(700, 600);
            ventana.setLocationRelativeTo(null);
            ventana.setResizable(false);
            ventana.setVisible(true);
            
    });
    }
    
}
