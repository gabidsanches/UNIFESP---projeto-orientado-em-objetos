import java.util.ArrayList;
import java.util.List;

public class MediadorTextoConcreto implements MediadorTexto {
    private List<JanelaApp> janelas;

    public MediadorTextoConcreto() {
        this.janelas = new ArrayList<>();
    }

    @Override
    public void registrarJanela(JanelaApp janela) {
        this.janelas.add(janela);
    }

    @Override
    public void sincronizar(JanelaApp janelaRemetente) {
        String texto1Remetente = janelaRemetente.getTexto1();
        String texto2Remetente = janelaRemetente.getTexto2();

        for (JanelaApp janelaDestino : janelas) {
            if (janelaDestino != janelaRemetente) {
                janelaDestino.setTexto1(texto1Remetente);
                janelaDestino.setTexto2(texto2Remetente);
            }
        }
    }
}