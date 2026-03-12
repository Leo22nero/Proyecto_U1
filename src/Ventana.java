import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Ventana extends JFrame {
   private JButton btns[];
    private JComboBox chamarras;
    private JRadioButton talla, chica,mediana,grande;
   private JCheckBox envio, carrito;
   private JTextArea pedido;
   private JButton extra, agregar, limpiar;
   
   private Container contenedor;
   
   public Ventana(){

        super("Tienda de Chamarras");
}
