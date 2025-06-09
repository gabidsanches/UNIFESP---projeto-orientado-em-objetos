import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaApp extends JFrame {
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JButton botaoCopiar;
    private MediadorTexto mediador;

    public JanelaApp(String titulo, MediadorTexto mediador) {
        super(titulo);
        this.mediador = mediador;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelTexto1 = new JLabel("  Texto 1:");
        campoTexto1 = new JTextField();

        JLabel labelTexto2 = new JLabel("  Texto 2:");
        campoTexto2 = new JTextField();

        botaoCopiar = new JButton("Copiar para Outra Janela");

        add(labelTexto1);
        add(campoTexto1);
        add(labelTexto2);
        add(campoTexto2);
        add(new JLabel());
        add(botaoCopiar);

        botaoCopiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediador.sincronizar(JanelaApp.this);
            }
        });
        this.mediador.registrarJanela(this);
    }

    public String getTexto1() {
        return campoTexto1.getText();
    }

    public String getTexto2() {
        return campoTexto2.getText();
    }

    public void setTexto1(String texto) {
        campoTexto1.setText(texto);
    }

    public void setTexto2(String texto) {
        campoTexto2.setText(texto);
    }
}