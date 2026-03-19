package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPago extends JFrame {

    private JTextField tarjetaField, fechaField, cvcField;
    private int total;

    public VentanaPago(int total) {
        this.total = total;

        JPanel panel = new JPanel();

        //Config Ventana
        setTitle("Pago");
        setSize(470, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        JLabel titulo = new JLabel("Realizar Pago");
        titulo.setForeground(new Color(210, 170, 130));
        titulo.setFont(new Font("Serif", Font.ITALIC, 26));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(20));

        // PANEL PRINCIPAL
        panel.setBackground(new Color(20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // TARJETA
        tarjetaField = crearCampo("Número de Tarjeta");
        verificador(tarjetaField, 16);
        panel.add(tarjetaField);
        panel.add(Box.createVerticalStrut(15));

        // MES
        JPanel fila = new JPanel(new GridLayout(1, 2, 8, 0));
        fila.setBackground(new Color(20, 20, 20));

        fechaField = crearCampo("MM / AA");
        verificador(fechaField, 4);

        cvcField = crearCampo("CVC");
        verificador(cvcField, 3);

        fila.add(fechaField);
        fila.add(cvcField);

        panel.add(fila);
        panel.add(Box.createVerticalStrut(25));

        // BOTONES
        JPanel botones = new JPanel(new GridLayout(1, 2, 10, 0));
        botones.setBackground(new Color(20, 20, 20));

        JButton limpiar = new JButton("Limpiar");
        estiloBoton(limpiar, new Color(90, 70, 50));

        limpiar.addActionListener(e -> {
            tarjetaField.setText("");
            fechaField.setText("");
            cvcField.setText("");
        });

        JButton pagar = new JButton("Pagar");
        estiloBoton(pagar, new Color(170, 110, 70));

        pagar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pago realizado");
            dispose();
        });

        botones.add(limpiar);
        botones.add(pagar);

        panel.add(botones);

        add(panel);
        setVisible(true);
    }

    // CREAR CAMPOS
    private JTextField crearCampo(String texto) {
        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        campo.setBackground(new Color(45, 45, 45));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(150, 120, 90)),
                texto, 0, 0, new Font("Arial", Font.PLAIN, 12),
                new Color(210, 170, 130)
        ));
        return campo;
    }

    // caracteriaticas botones
    private void estiloBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setPreferredSize(new Dimension(0, 45));
    }

    private void verificador(JTextField campo, int max) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();

                if (!Character.isDigit(c) || campo.getText().length() >= max) {
                    evt.consume();
                }
            }
        });
    }
}