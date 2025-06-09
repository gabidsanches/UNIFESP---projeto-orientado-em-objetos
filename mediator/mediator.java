import javax.swing.SwingUtilities;

public class AppMediatorJanelas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MediadorTexto mediador = new MediadorTextoConcreto();

                JanelaApp janelaUm = new JanelaApp("Janela UM", mediador);
                JanelaApp janelaDois = new JanelaApp("Janela DOIS", mediador);

                janelaUm.setLocation(100, 200);
                janelaDois.setLocation(550, 200);

                janelaUm.setVisible(true);
                janelaDois.setVisible(true);
            }
        });
    }
}