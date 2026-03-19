package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPago extends JFrame {

    private JPanel panelEST;
    private JLabel totalP;
    private int total;


    //Constructor
    public VentanaPago(int total) {
        super("Ventana de Pago");

        this.total = total;

        setTitle("VENTANA DE PAGO");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        panelEST = new JPanel();
        panelEST.setLayout(new BoxLayout(panelEST, BoxLayout.Y_AXIS));
        panelEST.setBorder(BorderFactory.createTitledBorder("RESUMEN DE CARRITO"));

        totalP = new JLabel("TOTAL A PAGAR: $" + total);
        totalP.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalP.setFont(new Font("Segoe UI", Font.BOLD, 25));
        totalP.setForeground(new Color(255, 105, 180));

        panelEST.add(totalP);


        //Arreglo
        String[] opciones = {"PAGAR TOTAL", "LIMPIAR CARRITO"};

        for (String op : opciones) {

            JButton btn = new JButton(op);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (op.equals("LIMPIAR CARRITO")) {
                     
                        totalP.setText("TOTAL A PAGAR: $0");
                      
                    }

                    if (op.equals("PAGAR TOTAL")) {
                        JOptionPane.showMessageDialog(null, "Pago realizado");
                        dispose();
                    }
                }
            });

            panelEST.add(btn);
            panelEST.add(Box.createVerticalStrut(25));
        }

        add(panelEST, BorderLayout.CENTER);
    }
}