/*Maximus Ocampo Calderon Tics practica10 estaciones del año*/
 package program;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Practica10 extends JFrame {

    private final JTextField mesTextField;
    private final JButton determinarButton;
    private final JLabel resultadoLabel;

    public Practica10() {
        // Configurar la ventana
        setTitle("Determinar Estación del Año");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Crear los componentes
        JLabel mesLabel = new JLabel("Número de mes (1-12):");
        mesLabel.setBounds(20, 20, 150, 20);
        add(mesLabel);

        mesTextField = new JTextField();
        mesTextField.setBounds(170, 20, 50, 20);
        add(mesTextField);

        determinarButton = new JButton("Determinar");
        determinarButton.setBounds(20, 60, 100, 30);
        add(determinarButton);

        resultadoLabel = new JLabel("Estación: ");
        resultadoLabel.setBounds(20, 100, 200, 20);
        add(resultadoLabel);

        // Agregar un ActionListener al botón
        determinarButton.addActionListener((ActionEvent e) -> {
            determinarEstacion();
        });
    }

    private void determinarEstacion() {
        try {
            int numeroMes = Integer.parseInt(mesTextField.getText());

            if (numeroMes >= 1 && numeroMes <= 12) {
                String estacion = determinarEstacionDelAnio(numeroMes);
                resultadoLabel.setText("Estación: " + estacion);
            } else {
                resultadoLabel.setText("Ingresa un número de mes válido (1-12).");
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Ingresa un número de mes válido (1-12).");
        }
    }

    private String determinarEstacionDelAnio(int numeroMes) {
        String estacion;

        estacion = switch (numeroMes) {
            case 12, 1, 2 -> "Invierno";
            case 3, 4, 5 -> "Primavera";
            case 6, 7, 8 -> "Verano";
            case 9, 10, 11 -> "Otoño";
            default -> "Desconocida";
        };

        return estacion;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Practica10 programa = new Practica10();
            programa.setVisible(true);
        });
    }
}
