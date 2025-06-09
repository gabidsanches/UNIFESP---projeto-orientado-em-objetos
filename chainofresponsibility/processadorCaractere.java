interface ProcessadorCaractere {
    void definirProximo(ProcessadorCaractere proximoProcessador);

    void processar(char caractere, Contagem contagem);
}