package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaPago extends JFrame {

    private JPanel panelEST;
    private JLabel totalP;
    private int total;

    public VentanaPago(int total) {
        super("Ventana de Pago");

        this.total = total;

        setTitle("VENTANA DE PAGO");
        setSize(380, 350);
        setLocationRelativeTo(null);
        setResizable(false);

        panelEST = new JPanel();
        panelEST.setLayout(new BoxLayout(panelEST, BoxLayout.Y_AXIS));
        panelEST.setBackground(new Color(20, 20, 20));
        panelEST.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // TÍTULO
        JLabel titulo = new JLabel("Realizar Pago");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Serif", Font.ITALIC, 26));
        titulo.setForeground(new Color(210, 170, 130));

        panelEST.add(titulo);
        panelEST.add(Box.createVerticalStrut(25));

        // TOTAL
        totalP = new JLabel("TOTAL: $" + total);
        totalP.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalP.setFont(new Font("Segoe UI", Font.BOLD, 22));
        totalP.setForeground(Color.WHITE);

        panelEST.add(totalP);
        panelEST.add(Box.createVerticalStrut(40));

    
        Action pagarAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pago realizado");
                dispose();
            }
        };

        // PANEL BOTONES
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(20, 20, 20));
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));

        String[] opciones = {"LIMPIAR", "PAGAR"};

        for (String op : opciones) {

            JButton btn = new JButton(op);

            btn.setPreferredSize(new Dimension(110, 35));
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));

            if (op.equals("PAGAR")) {
                btn.setBackground(new Color(170, 110, 70));
                btn.addActionListener(pagarAction);
            } else {
                btn.setBackground(new Color(90, 70, 50));
                btn.addActionListener(e -> totalP.setText("TOTAL: $0"));
            }

            panelBotones.add(btn);
        }

        panelEST.add(panelBotones);

        // Ctrl + P
        KeyStroke ctrlP = KeyStroke.getKeyStroke("control P");

        panelEST.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(ctrlP, "pagar");

        panelEST.getActionMap().put("pagar", pagarAction);

        add(panelEST);
        setVisible(true);
    }
}
