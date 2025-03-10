import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cashtrack extends JFrame {
    private JTextField campoTexto;
    private JButton botonIngreso;
    private JButton botonGasto;
    private JLabel etiquetaSaldo;
    private JLabel ingresosEtiqueta;
    private JLabel gastosEtiqueta;
    private JPanel panelResultados;
    private double ingresos = 0;
    private double gastos = 0;

    public cashtrack() {
        setTitle("CashTrack");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel etiqueta = new JLabel("Ingrese un monto:");
        campoTexto = new JTextField(10);
        botonIngreso = new JButton("Ingreso");
        botonGasto = new JButton("Gasto");

        ingresosEtiqueta = new JLabel("Total Ingresos: $0.0");
        gastosEtiqueta = new JLabel("Total Gastos: $0.0");
        etiquetaSaldo = new JLabel("Saldo Disponible: $0.0");
        etiquetaSaldo.setFont(new Font("Arial", Font.BOLD, 14));
        
        panelResultados = new JPanel();
        panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));

        botonIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(campoTexto.getText());
                    ingresos += valor;
                    actualizarSaldo();
                    
                    JLabel nuevoLabel = new JLabel("Ingreso: +$" + valor);
                    nuevoLabel.setForeground(Color.GREEN);
                    panelResultados.add(nuevoLabel);
                    panelResultados.revalidate();
                    panelResultados.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonGasto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(campoTexto.getText());
                    gastos += valor;
                    actualizarSaldo();
                    
                    JLabel nuevoLabel = new JLabel("Gasto: -$" + valor);
                    nuevoLabel.setForeground(Color.RED);
                    panelResultados.add(nuevoLabel);
                    panelResultados.revalidate();
                    panelResultados.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(etiqueta, gbc);

        gbc.gridx = 1;
        add(campoTexto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(botonIngreso, gbc);

        gbc.gridx = 1;
        add(botonGasto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(ingresosEtiqueta, gbc);

        gbc.gridy = 3;
        add(gastosEtiqueta, gbc);

        gbc.gridy = 4;
        add(etiquetaSaldo, gbc);

        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelResultados, gbc);
    }

    private void actualizarSaldo() {
        double saldo = ingresos - gastos;
        ingresosEtiqueta.setText("Total Ingresos: $" + ingresos);
        gastosEtiqueta.setText("Total Gastos: $" + gastos);
        etiquetaSaldo.setText("Saldo Disponible: $" + saldo);

        if (saldo < 0) {
            etiquetaSaldo.setForeground(Color.RED);
        } else {
            etiquetaSaldo.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            cashtrack ventana = new cashtrack();
            ventana.setVisible(true);
        });
    }
}