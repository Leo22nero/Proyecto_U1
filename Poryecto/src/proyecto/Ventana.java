package proyecto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {
    //Atributos
    private JPanel panelNOR, panelEST, panelOES, panelSUR;
    private JButton btns[];
    private int total = 0;
    private JLabel sudadera1,sudadera2,sudadera3,sudadera4;
    //Lista del carrito
    private DefaultListModel<String> modeloLista;
    private JTextArea listaCarrito;
    private JLabel lblTotal;
    private int precio1=599;
    private int precio2=550;
    private int precio3=780;
    private int precio4=399;
    private int total1=0;

    //Inicio del Constructor
    public Ventana(){
        super("Proyecto 1");
        setLayout(new BorderLayout(5,5));
        initCarrito();
        initNOR();
        initEST();
        initOES();

    }

    private void initCarrito() {


        listaCarrito = new JTextArea ();
        listaCarrito.setSize(200,200);
        listaCarrito.setPreferredSize( new Dimension(250,180));
        listaCarrito.setEditable(false);
        JPanel panelCarrito = new JPanel(new BorderLayout());
        panelCarrito.setBorder( BorderFactory.createTitledBorder(null,"CARRITO",TitledBorder.CENTER,TitledBorder.TOP ));
        lblTotal = new JLabel("Total: $"+total1);
        lblTotal.setHorizontalAlignment(JLabel.CENTER);
        panelCarrito.add(listaCarrito, BorderLayout.NORTH);
        panelCarrito.add(lblTotal, BorderLayout.CENTER);
        add(panelCarrito, BorderLayout.EAST);


    }
    private void initNOR() {
        panelNOR = new JPanel(new BorderLayout());
        panelNOR.setBorder(BorderFactory.createTitledBorder(null,"SUDADERAS",TitledBorder.CENTER,TitledBorder.TOP ));;
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

        panelEST = new JPanel(new GridBagLayout());
        JButton btnFinalizar = new JButton("FINALIZAR");
        JButton btnLimpiar = new JButton(" LIMPIAR ");
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;

        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.gridy = 0;
        panelEST.add(btnFinalizar, gbc);


        gbc.gridy = 2;
        panelEST.add(btnLimpiar, gbc);

        btnFinalizar.addActionListener(e -> {
            new proyecto.VentanaPago(total);
        });
        btnLimpiar.addActionListener(e -> {
            listaCarrito.setText("");
            total=0;
            lblTotal.setText("Total: $" + total);
        });

        btnFinalizar.setPreferredSize(new Dimension(100, 40));
        btnLimpiar.setPreferredSize(new Dimension(100, 40));

        add(panelEST, BorderLayout.CENTER);
    }

    private void initOES() {
        panelOES = new JPanel(new GridLayout(2,2,10,10));
        panelOES.setBorder(BorderFactory.createTitledBorder("PRODUCTOS"));
        panelOES.setBackground(Color.BLACK);

        //sud1
        JPanel pan1 = new JPanel(new BorderLayout());
        JLabel sud1 = new JLabel(new ImageIcon(getClass().getResource("sudadera1.jpg")));
        pan1.add(sud1, BorderLayout.CENTER);
        JPanel descr1 = new JPanel(new GridLayout(4,1));
        JLabel sudadera1 = new JLabel("Sudadera Negra");
        descr1.add(sudadera1);
        descr1.add(new JLabel("$"+precio1));
        String tallas[] = {"S","M","L"};
        JComboBox<String> talla1 = new JComboBox<>(tallas);
        descr1.add(talla1);
        JButton agregar1 = new JButton("Comprar");

        descr1.add(agregar1);
        pan1.add(descr1, BorderLayout.SOUTH);
        agregar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera1.getText();
                String talla = (String) talla1.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio1;
                lblTotal.setText("Total: $" + total);
            }
        });
        talla1.setSelectedIndex(0);
        //sud2
        JPanel pane2 = new JPanel(new BorderLayout());
        JLabel suda2 = new JLabel(new ImageIcon(getClass().getResource("sudadera2.jpg")));
        pane2.add(suda2, BorderLayout.CENTER);
        JPanel descr2 = new JPanel(new GridLayout(4,1));
        JLabel sudadera2 = new JLabel("Sudadera Blanca");
        descr2.add(sudadera2);
        descr2.add(new JLabel("$"+precio2));

        JComboBox<String> talla2 = new JComboBox<>(tallas);
        descr2.add(talla2);

        JButton agregar2 = new JButton("Comprar");
        descr2.add(agregar2);

        pane2.add(descr2, BorderLayout.SOUTH);
        agregar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera2.getText();
                String talla = (String) talla2.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio2;
                lblTotal.setText("Total: $" + total);
            }
        });
        talla2.setSelectedIndex(0);

        //sud3
        JPanel pane3 = new JPanel(new BorderLayout());
        JLabel sud3 = new JLabel(new ImageIcon(getClass().getResource("sudadera3.jpg")));
        pane3.add(sud3, BorderLayout.CENTER);
        JPanel desc3 = new JPanel(new GridLayout(4,1));
        JLabel sudadera3 = new JLabel("Sudadera Anime");
        desc3.add(sudadera3);
        desc3.add(new JLabel("$"+precio3));
        JComboBox<String> talla3 = new JComboBox<>(tallas);
        desc3.add(talla3);

        JButton agregar3 = new JButton("Comprar");
        desc3.add(agregar3);

        pane3.add(desc3, BorderLayout.SOUTH);
        agregar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera3.getText();
                String talla = (String) talla1.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio3;
                lblTotal.setText("Total: $" + total);
            }
        });
        talla3.setSelectedIndex(0);

        //sud4
        JPanel pane4 = new JPanel(new BorderLayout());
        JLabel img4 = new JLabel(new ImageIcon(getClass().getResource("sudadera4.jpg")));
        pane4.add(img4, BorderLayout.CENTER);

        JPanel info4 = new JPanel(new GridLayout(4,1));
        JLabel sudadera4 = new JLabel("Sudadera Beige");

        info4.add(new JLabel("$"+precio4));
        JComboBox<String> talla4 = new JComboBox<>(tallas);
        info4.add(sudadera4);
        info4.add(talla4);
        JButton agregar4 = new JButton("Comprar");
        info4.add(agregar4);
        pane4.add(info4, BorderLayout.SOUTH);
        agregar4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera4.getText();
                String talla = (String) talla1.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio4;
                lblTotal.setText("Total: $" + total);
            }
        });
        talla1.setSelectedIndex(0);
        panelOES.add(pan1);
        panelOES.add(pane2);
        panelOES.add(pane3);
        panelOES.add(pane4);

        add(panelOES, BorderLayout.WEST);
    }

}

