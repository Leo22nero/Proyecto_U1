import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private Container contenedor;
    private JTextArea carrito = new JTextArea();
    private JLabel totalDin = new JLabel("Total: $0");
    private int total = 0;

    public Ventana(){
        super("Tienda de Chamarras");

        JPanel tienda = new JPanel();
        tienda.setLayout(new GridLayout(6,1));

        tienda.add(prenda("Chamarra de Cuero",300));
        tienda.add(prenda("Chamarra de Mezclilla",200));
        tienda.add(prenda("Chamarra de Gamuza",500));
        tienda.add(prenda("Chamarra de Poliéster",250));
        tienda.add(prenda("Chaqueta Deportiva",280));
        tienda.add(prenda("Chamarra de Nylon",230));

        add(tienda,BorderLayout.WEST);
        add(new JScrollPane(carrito),BorderLayout.CENTER);
        add(totalDin,BorderLayout.SOUTH);

        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel prenda(String nombre, int precio){

        JPanel panel = new JPanel();

        JButton boton = new JButton(nombre + " $" + precio);

        boton.addActionListener(e -> {
            carrito.append(nombre + " $" + precio + "\n");
            total += precio;
            totalDin.setText("Total: $" + total);
        });

        panel.add(boton);

        return panel;
    }

    public void pagar(){

        if(total == 0){
            JOptionPane.showMessageDialog(this,"El carrito está vacío");
        }else{
            JOptionPane.showMessageDialog(this,"Pagado");
            limpiar();
        }
    }

    public void limpiar(){

        carrito.setText("");
        total = 0;
        totalDin.setText("Total: $0");

    }

    public static void main(String[] args){
        new Ventana();
    }
}