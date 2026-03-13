import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Ventana extends JFrame {
   private Container contenedor;
   
   public Ventana(){
        super("Tienda de Chamarras");
}

   //Pagar las compras u informar que hace falta seleccionar alguna chamarra
   public void pagar(){

        if(total == 0){
            JOptionPane.showMessageDialog(this,"El carrito está vacío");
        }else{
            JOptionPane.showMessageDialog(this,"Tu pago fue exitoso");
            limpiar();
         }
   }
//limpia las compras que se hayan seleccionado por error 
    public void limpiar(){

        carrito.setText("");
        total = 0;
        totalDin.setText("Total: $0");

    }
