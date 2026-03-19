package proyecto;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Ventana extends JFrame {

    //Atributos
    private JPanel panelNOR, panelEST, panelOES, panelSUR;
    private JButton btns[];
    private int total = 0;
    private JLabel titulo;

    //Lista del carrito
    private List<String> carrito = new ArrayList<>();



    //Lista
    private final String nombres[] = {"MODELO 1", "MODELO 2", " MODELO 3", "MODELO 4"};


    //Inicio del Cosntructor
    public Ventana(){
        super("Proyecto 1");
        setLayout(new BorderLayout(5,5));

        initNOR();
        initEST();
        initOES();
    }

    private void initNOR() {
        panelNOR = new JPanel(new BorderLayout());
        panelNOR.setBorder(BorderFactory.createTitledBorder("SUDADERAS"));
        panelNOR.setBackground(Color.BLACK);

        JLabel titulo = new JLabel("TIENDA DE SUDADERAS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(true);
        titulo.setBackground(Color.WHITE);
        panelNOR.add(titulo, BorderLayout.CENTER);

        add(panelNOR, BorderLayout.NORTH);
    }

    private void initEST() {

        panelEST = new JPanel();
        JButton btnFinalizar = new JButton("FINALIZAR");
        btnFinalizar.addActionListener(e -> {
            new proyecto.VentanaPago(total);
        });

        panelEST.add(btnFinalizar);
        add(panelEST, BorderLayout.CENTER);
    }

    private void initOES() {


        /*
        Falta darle mas espacio al panel Oeste
        Falta hacerlo carrito y acomodar el boton de finalizar al ultimo
        Falta hacer visible la lista de lo que se va agregando
         */

        panelOES = new JPanel(new GridLayout(2,2,10,10));
        panelOES.setBorder(BorderFactory.createTitledBorder("PRODUCTOS"));
        panelOES.setBackground(Color.BLACK);

        //sud1
        JPanel pan1 = new JPanel(new BorderLayout());
        JLabel sud1 = new JLabel(new ImageIcon(getClass().getResource("sudadera1.jpg")));
        pan1.add(sud1, BorderLayout.CENTER);
        JPanel descr1 = new JPanel(new GridLayout(4,1));
        descr1.add(new JLabel("Sudadera Negra"));
        descr1.add(new JLabel("$599"));
        String tallas[] = {"S","M","L"};
        JComboBox<String> talla1 = new JComboBox<>(tallas);
        descr1.add(talla1);
        JButton agregar1 = new JButton("Comprar");
        descr1.add(agregar1);
        
        pan1.add(descr1, BorderLayout.SOUTH);

        //sud2
        JPanel pane2 = new JPanel(new BorderLayout());
        JLabel suda2 = new JLabel(new ImageIcon(getClass().getResource("sudadera2.jpg")));
        pane2.add(suda2, BorderLayout.CENTER);    
        JPanel descr2 = new JPanel(new GridLayout(4,1));
        descr2.add(new JLabel("Sudadera Blanca"));
        descr2.add(new JLabel("$550"));

        JComboBox<String> talla2 = new JComboBox<>(tallas);
        descr2.add(talla2);

        JButton agregar2 = new JButton("Comprar");
        descr2.add(agregar2);

        pane2.add(descr2, BorderLayout.SOUTH);

        //sud3
        JPanel pane3 = new JPanel(new BorderLayout());
        JLabel sud3 = new JLabel(new ImageIcon(getClass().getResource("sudadera3.jpg")));
        pane3.add(sud3, BorderLayout.CENTER);
        JPanel desc3 = new JPanel(new GridLayout(4,1));
        desc3.add(new JLabel(" Sudadera de Anime"));
        desc3.add(new JLabel("$780"));
        JComboBox<String> talla3 = new JComboBox<>(tallas);
        desc3.add(talla3);

        JButton agregar3 = new JButton("Comprar");
        desc3.add(agregar3);

        pane3.add(desc3, BorderLayout.SOUTH);

        //sud4
        JPanel pane4 = new JPanel(new BorderLayout());
        JLabel img4 = new JLabel(new ImageIcon(getClass().getResource("sudadera4.jpg")));
        pane4.add(img4, BorderLayout.CENTER);

        JPanel info4 = new JPanel(new GridLayout(4,1));
        info4.add(new JLabel("Sudadera Beige"));
        info4.add(new JLabel("$399"));
        JComboBox<String> talla4 = new JComboBox<>(tallas);
        info4.add(talla4);
        JButton agregar4 = new JButton("Comprar");
        info4.add(agregar4);
        pane4.add(info4, BorderLayout.SOUTH);
        
        panelOES.add(pan1);
        panelOES.add(pane2);
        panelOES.add(pane3);
        panelOES.add(pane4);

        add(panelOES, BorderLayout.WEST);
    }
}


