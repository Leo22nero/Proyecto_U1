package proyecto;
//@author Leonardo Estrada, Mariana Correa, Ana Laura Gervacio, Julia Ruiz, Lissandro Perez.

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

    // Atributos
    private JPanel panelNOR, panelEST, panelOES;
    private JTextArea listaCarrito;
    private JLabel lblTotal;
    private int total = 0;

    private int precio1 = 599;
    private int precio2 = 550;
    private int precio3 = 780;
    private int precio4 = 399;

    public Ventana() {
        super("Proyecto 1");
        setLayout(new BorderLayout(5, 5));

        initCarrito();
        initNOR();
        initEST();
        initOES();
    }

    private void initCarrito() {
        listaCarrito = new JTextArea();
        listaCarrito.setPreferredSize(new Dimension(250, 180));
        listaCarrito.setEditable(false);

        JPanel panelCarrito = new JPanel(new BorderLayout());
        panelCarrito.setBorder(BorderFactory.createTitledBorder(null, "CARRITO",
                TitledBorder.CENTER, TitledBorder.TOP));

        lblTotal = new JLabel("Total: $" + total);
        lblTotal.setHorizontalAlignment(JLabel.CENTER);

        panelCarrito.add(listaCarrito, BorderLayout.NORTH);
        panelCarrito.add(lblTotal, BorderLayout.CENTER);

        add(panelCarrito, BorderLayout.EAST);
    }

    private void initNOR() {
        panelNOR = new JPanel(new BorderLayout());
        panelNOR.setBorder(BorderFactory.createTitledBorder(null, "SUDADERAS",
                TitledBorder.CENTER, TitledBorder.TOP));
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
        GridBagConstraints gbc = new GridBagConstraints();

        JButton btnFinalizar = new JButton("FINALIZAR");
        JButton btnLimpiar = new JButton("LIMPIAR");

        gbc.gridx = 0;
        gbc.insets = new Insets(20, 10, 20, 10);

        gbc.gridy = 0;
        panelEST.add(btnFinalizar, gbc);

        gbc.gridy = 1;
        panelEST.add(btnLimpiar, gbc);

        // Acción reutilizable
        Action finalizarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new proyecto.VentanaPago(total);
            }
        };

        btnFinalizar.addActionListener(finalizarAction);

        btnLimpiar.addActionListener(e -> {
            listaCarrito.setText("");
            total = 0;
            lblTotal.setText("Total: $" + total);
        });

        //Ctrl + F
        KeyStroke ctrlF = KeyStroke.getKeyStroke("control F");
        panelEST.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(ctrlF, "finalizar");
        panelEST.getActionMap().put("finalizar", finalizarAction);

        btnFinalizar.setPreferredSize(new Dimension(100, 40));
        btnLimpiar.setPreferredSize(new Dimension(100, 40));

        add(panelEST, BorderLayout.CENTER);
    }

    private void initOES() {
        panelOES = new JPanel(new GridLayout(2, 2, 10, 10));
        panelOES.setBorder(BorderFactory.createTitledBorder("PRODUCTOS"));
        panelOES.setBackground(Color.BLACK);

        String tallas[] = {"S", "M", "L"};

        //sud1
        JPanel pan1 = new JPanel(new BorderLayout());
        JLabel img1 = new JLabel(new ImageIcon(getClass().getResource("sudadera1.jpg")));
        pan1.add(img1, BorderLayout.CENTER);

        JPanel descr1 = new JPanel(new GridLayout(4, 1));
        JLabel nombre1 = new JLabel("Sudadera Negra");
        JComboBox<String> talla1 = new JComboBox<>(tallas);
        JButton agregar1 = new JButton("Comprar");

        descr1.add(nombre1);
        descr1.add(new JLabel("$" + precio1));
        descr1.add(talla1);
        descr1.add(agregar1);

        pan1.add(descr1, BorderLayout.SOUTH);

        agregar1.addActionListener(e -> {
            listaCarrito.append(nombre1.getText() + " - Talla: " +
                    talla1.getSelectedItem() + "\n");
            total += precio1;
            lblTotal.setText("Total: $" + total);
        });

        talla1.setSelectedIndex(0);

        //sud2
        JPanel pan2 = new JPanel(new BorderLayout());
        JLabel img2 = new JLabel(new ImageIcon(getClass().getResource("sudadera2.jpg")));
        pan2.add(img2, BorderLayout.CENTER);

        JPanel descr2 = new JPanel(new GridLayout(4, 1));
        JLabel nombre2 = new JLabel("Sudadera Blanca");
        JComboBox<String> talla2 = new JComboBox<>(tallas);
        JButton agregar2 = new JButton("Comprar");

        descr2.add(nombre2);
        descr2.add(new JLabel("$" + precio2));
        descr2.add(talla2);
        descr2.add(agregar2);

        pan2.add(descr2, BorderLayout.SOUTH);

        agregar2.addActionListener(e -> {
            listaCarrito.append(nombre2.getText() + " - Talla: " +
                    talla2.getSelectedItem() + "\n");
            total += precio2;
            lblTotal.setText("Total: $" + total);
        });

        talla2.setSelectedIndex(0);

        //sud3
        JPanel pan3 = new JPanel(new BorderLayout());
        JLabel img3 = new JLabel(new ImageIcon(getClass().getResource("sudadera3.jpg")));
        pan3.add(img3, BorderLayout.CENTER);

        JPanel descr3 = new JPanel(new GridLayout(4, 1));
        JLabel nombre3 = new JLabel("Sudadera Anime");
        JComboBox<String> talla3 = new JComboBox<>(tallas);
        JButton agregar3 = new JButton("Comprar");

        descr3.add(nombre3);
        descr3.add(new JLabel("$" + precio3));
        descr3.add(talla3);
        descr3.add(agregar3);

        pan3.add(descr3, BorderLayout.SOUTH);

        agregar3.addActionListener(e -> {
            listaCarrito.append(nombre3.getText() + " - Talla: " +
                    talla3.getSelectedItem() + "\n");
            total += precio3;
            lblTotal.setText("Total: $" + total);
        });

        talla3.setSelectedIndex(0);

        //sud4
        JPanel pan4 = new JPanel(new BorderLayout());
        JLabel img4 = new JLabel(new ImageIcon(getClass().getResource("sudadera4.jpg")));
        pan4.add(img4, BorderLayout.CENTER);

        JPanel descr4 = new JPanel(new GridLayout(4, 1));
        JLabel nombre4 = new JLabel("Sudadera Beige");
        JComboBox<String> talla4 = new JComboBox<>(tallas);
        JButton agregar4 = new JButton("Comprar");

        descr4.add(nombre4);
        descr4.add(new JLabel("$" + precio4));
        descr4.add(talla4);
        descr4.add(agregar4);

        pan4.add(descr4, BorderLayout.SOUTH);

        agregar4.addActionListener(e -> {
            listaCarrito.append(nombre4.getText() + " - Talla: " +
                    talla4.getSelectedItem() + "\n");
            total += precio4;
            lblTotal.setText("Total: $" + total);
        });

        talla4.setSelectedIndex(0);

        panelOES.add(pan1);
        panelOES.add(pan2);
        panelOES.add(pan3);
        panelOES.add(pan4);

        add(panelOES, BorderLayout.WEST);
    }
}
