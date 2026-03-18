package proyecto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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

        panelOES = new JPanel(new GridLayout(3,3,4,4));
        panelOES.setBorder(BorderFactory.createTitledBorder("PRODUCTOS"));

        btns = new JButton[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            btns[i] = new JButton(nombres[i]);
            panelOES.add(btns[i]);
        }

        add(panelOES, BorderLayout.WEST);
    }
}


