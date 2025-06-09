class ProcessadorPonto implements ProcessadorCaractere {
    private ProcessadorCaractere proximo;

    @Override
    public void definirProximo(ProcessadorCaractere proximoProcessador) {
        this.proximo = proximoProcessador;
    }

    @Override
    public void processar(char caractere, Contagem contagem) {
        if (caractere == '.') {
            contagem.incrementarPontos();
        }

        if (proximo != null) {
            proximo.processar(caractere, contagem);
        }
    }
}