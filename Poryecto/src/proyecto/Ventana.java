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
        super("HOODIE STORE");
        setLayout(new BorderLayout(5,5));
        initCarrito();
        initNOR();
        initEST();
        initOES();

    }

    private void initCarrito() {
        Font fuente = null;

        try {
            fuente = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("Gameplay.ttf")
            ).deriveFont(Font.BOLD, 18f);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Font fuente2 = null;

        try {
            fuente2 = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("beatmap.TTF")
            ).deriveFont(Font.PLAIN, 10f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listaCarrito = new JTextArea ();

        listaCarrito.setPreferredSize( new Dimension(350,400));
        listaCarrito.setEditable(false);
        listaCarrito.setFont(fuente2);

        listaCarrito.setForeground(new Color(247,92,180));
        listaCarrito.setBackground(new Color(30,30,30));

        JPanel panelCarrito = new JPanel(new BorderLayout());
        panelCarrito.setBorder( BorderFactory.createTitledBorder(null,"CARRITO",TitledBorder.CENTER,TitledBorder.TOP ));

        lblTotal = new JLabel("TOTAL: $"+total1);
        lblTotal.setFont(fuente2);
        lblTotal.setForeground(new Color(240,184,216));
        lblTotal.setHorizontalAlignment(JLabel.CENTER);
        panelCarrito.add(listaCarrito, BorderLayout.NORTH);
        panelCarrito.add(lblTotal, BorderLayout.CENTER);

        add(panelCarrito, BorderLayout.EAST);


    }
    private void initNOR() {
        panelNOR = new JPanel(new BorderLayout());
        // panelNOR.setBorder(BorderFactory.createTitledBorder(null,"SUDADERAS",TitledBorder.CENTER,TitledBorder.TOP ));;
        //panelNOR.setBackground(Color.BLACK);
        ImageIcon icono = new ImageIcon(getClass().getResource("titulo.png"));
        Image img = icono.getImage().getScaledInstance(320, 100, Image.SCALE_SMOOTH);

        JLabel titulo = new JLabel(new ImageIcon(img), SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(false);
        titulo.setBackground(Color.WHITE);
        panelNOR.add(titulo, BorderLayout.CENTER);
        add(panelNOR, BorderLayout.NORTH);
    }

    private void initEST() {
        Font fuente2 = null;

        try {
            fuente2 = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("beatmap.TTF")
            ).deriveFont(Font.PLAIN, 7f);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        btnFinalizar.setBackground(new Color(198,251,172));
        btnFinalizar.setFont(fuente2);
        btnFinalizar.setForeground(new Color(30,30,30));
        btnLimpiar.setBackground(new Color(231,172,114));
        btnLimpiar.setFont(fuente2);
        btnLimpiar.setForeground(new Color(30,30,30));
        btnFinalizar.addActionListener(e -> {
            new proyecto.VentanaPago(total);
        });
        btnLimpiar.addActionListener(e -> {
            listaCarrito.setText("");
            total=0;
            lblTotal.setText("TOTAL: $" + total);
        });

        btnFinalizar.setPreferredSize(new Dimension(100, 40));
        btnLimpiar.setPreferredSize(new Dimension(100, 40));

        add(panelEST, BorderLayout.CENTER);
    }

    private void initOES() {
        Font fuente2 = null;

        try {
            fuente2 = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("beatmap.TTF")
            ).deriveFont(Font.PLAIN, 10f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        panelOES = new JPanel(new GridLayout(2,2,10,10));
        panelOES.setBorder(BorderFactory.createTitledBorder("PRODUCTOS"));
        // panelOES.setBackground(Color.BLACK);
        panelOES.setPreferredSize(new Dimension(500,700));


        Font fuente = null;

        try {
            fuente = Font.createFont(
                    Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("Gameplay.ttf")
            ).deriveFont(Font.BOLD, 18f);
        } catch (Exception e) {
            e.printStackTrace();
        }



        //sudadera 1
        JPanel pan1 = new JPanel(new BorderLayout());
        JLabel sud1 = new JLabel(new ImageIcon(getClass().getResource("sudadera1.jpg")));

        pan1.add(sud1, BorderLayout.CENTER);

        JPanel descr1 = new JPanel(new GridLayout(4,1));
        JLabel sudadera1 = new JLabel("Sudadera Negra");

        sudadera1.setFont(fuente);

        descr1.add(sudadera1);
        descr1.add(new JLabel("$"+precio1));

        String tallas[] = {"S","M","L"};

        JComboBox<String> talla1 = new JComboBox<>(tallas);

        descr1.add(talla1);
        JButton agregar1 = new JButton("Comprar");

        descr1.add(agregar1);
        agregar1.setBackground(new Color(240,184,216));
        agregar1.setFont(fuente2);
        agregar1.setForeground(new Color(30,30,30));
        pan1.add(descr1, BorderLayout.SOUTH);
        agregar1.addActionListener(new ActionListener() {



            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera1.getText();
                String talla = (String) talla1.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio1;
                lblTotal.setText("TOTAL: $" + total);
            }
        });

        //sudadera 2
        JPanel pane2 = new JPanel(new BorderLayout());
        JLabel suda2 = new JLabel(new ImageIcon(getClass().getResource("sudadera2.jpg")));
        pane2.add(suda2, BorderLayout.CENTER);
        JPanel descr2 = new JPanel(new GridLayout(4,1));
        JLabel sudadera2 = new JLabel("Sudadera Blanca");
        sudadera2.setFont(fuente);
        descr2.add(sudadera2);
        descr2.add(new JLabel("$"+precio2));

        JComboBox<String> talla2 = new JComboBox<>(tallas);
        descr2.add(talla2);

        JButton agregar2 = new JButton("Comprar");
        descr2.add(agregar2);
        agregar2.setBackground(new Color(240,184,216));
        agregar2.setFont(fuente2);
        agregar2.setForeground(new Color(30,30,30));
        pane2.add(descr2, BorderLayout.SOUTH);
        agregar2.addActionListener(new ActionListener() {




            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera2.getText();
                String talla = (String) talla2.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio2;
                lblTotal.setText("TOTAL: $" + total);
            }
        });


        //sudadera 3
        JPanel pane3 = new JPanel(new BorderLayout());
        JLabel sud3 = new JLabel(new ImageIcon(getClass().getResource("sudadera3.jpg")));
        pane3.add(sud3, BorderLayout.CENTER);
        JPanel desc3 = new JPanel(new GridLayout(4,1));
        JLabel sudadera3 = new JLabel("Sudadera Anime");
        sudadera3.setFont(fuente);

        desc3.add(sudadera3);
        desc3.add(new JLabel("$"+precio3));
        JComboBox<String> talla3 = new JComboBox<>(tallas);
        desc3.add(talla3);

        JButton agregar3 = new JButton("Comprar");
        desc3.add(agregar3);
        agregar3.setBackground(new Color(240,184,216));
        agregar3.setFont(fuente2);
        agregar3.setForeground(new Color(30,30,30));
        pane3.add(desc3, BorderLayout.SOUTH);
        agregar3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera3.getText();
                String talla = (String) talla1.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio3;
                lblTotal.setText("TOTAL: $" + total);
            }
        });


        //sudadera 4
        JPanel pane4 = new JPanel(new BorderLayout());
        JLabel img4 = new JLabel(new ImageIcon(getClass().getResource("sudadera4.jpg")));
        pane4.add(img4, BorderLayout.CENTER);

        JPanel info4 = new JPanel(new GridLayout(4,1));
        JLabel sudadera4 = new JLabel("Sudadera Beige");
        sudadera4.setFont(fuente);

        info4.add(sudadera4);
        info4.add(new JLabel("$"+precio4));
        JComboBox<String> talla4 = new JComboBox<>(tallas);

        info4.add(talla4);
        JButton agregar4 = new JButton("Comprar");
        info4.add(agregar4);
        agregar4.setBackground(new Color(240,184,216));
        agregar4.setFont(fuente2);
        agregar4.setForeground(new Color(30,30,30));
        pane4.add(info4, BorderLayout.SOUTH);
        agregar4.addActionListener(new ActionListener() {



            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = sudadera4.getText();
                String talla = (String) talla1.getSelectedItem();
                listaCarrito.append(nombre + " - Talla: " + talla + "\n");
                total += precio4;
                lblTotal.setText("TOTAL: $" + total);

            }
        });

        panelOES.add(pan1);
        panelOES.add(pane2);
        panelOES.add(pane3);
        panelOES.add(pane4);

        add(panelOES, BorderLayout.WEST);
    }

}

