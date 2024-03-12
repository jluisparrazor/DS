import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vista extends JPanel {
    private JLabel estadoLabel;
    private JToggleButton encenderButton;
    private JToggleButton acelerarButton;
    private JToggleButton frenarButton;

    public vista() {
        setLayout(new FlowLayout());

        estadoLabel = new JLabel("APAGADO");
        add(estadoLabel);

        encenderButton = new JToggleButton("Encender");
        encenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (encenderButton.isSelected()) {
                    encenderButton.setText("Apagar");
                    estadoLabel.setText("APAGADO");
                } else {
                    encenderButton.setText("Encender");
                    estadoLabel.setText("APAGADO");
                }
            }
        });
        add(encenderButton);

        acelerarButton = new JToggleButton("Acelerar");
        acelerarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (encenderButton.isSelected()) {
                    estadoLabel.setText("ACELERANDO");
                    frenarButton.setSelected(false);
                }
            }
        });
        add(acelerarButton);

        frenarButton = new JToggleButton("Frenar");
        frenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (encenderButton.isSelected()) {
                    estadoLabel.setText("FRENANDO");
                    acelerarButton.setSelected(false);
                }
            }
        });
        add(frenarButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Control de Vehículo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.getContentPane().add(new vista());
        frame.setVisible(true);
    }
}
