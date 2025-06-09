class Contagem {
    int contagemEspacos = 0;
    int contagemLetrasA = 0;
    int contagemPontos = 0;

    public void incrementarEspacos() {
        contagemEspacos++;
    }

    public void incrementarLetrasA() {
        contagemLetrasA++;
    }

    public void incrementarPontos() {
        contagemPontos++;
    }

    @Override
    public String toString() {
        return "Estatísticas do texto:\n" +
               " - Número de espaços: " + contagemEspacos + "\n" +
               " - Número de letras 'a' (maiúsculas ou minúsculas): " + contagemLetrasA + "\n" +
               " - Número de pontos: " + contagemPontos;
    }
}