import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AnalisadorTexto {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, forneça um texto ou nome de arquivo como argumento.");
            return;
        }

        String textoEntrada = "";
        String primeiroArgumento = args[0];

        if (args.length == 1 && (primeiroArgumento.endsWith(".txt") || Files.exists(Paths.get(primeiroArgumento)))) {
            try {
                System.out.println("Lendo texto do arquivo: " + primeiroArgumento + "...");
                textoEntrada = lerArquivo(primeiroArgumento);
            } catch (IOException e) {
                System.err.println("Erro ao tentar ler o arquivo '" + primeiroArgumento + "'.");
                System.err.println("Verifique se o nome está correto e se você tem permissão para lê-lo.");
                System.err.println("Detalhe do erro: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Lendo texto fornecido diretamente na linha de comando...");
            StringBuilder construtorTexto = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                construtorTexto.append(args[i]);
                if (i < args.length - 1) {
                    construtorTexto.append(" ");
                }
            }
            textoEntrada = construtorTexto.toString();
        }

        if (textoEntrada.isEmpty() && args.length > 0) {
             System.out.println("O texto de entrada (ou conteúdo do arquivo) está vazio.");
        } else if (textoEntrada.isEmpty()) {
             System.out.println("Nenhum texto fornecido para análise.");
             return;
        }


        System.out.println("\nTexto para analisar:\n\"" + textoEntrada + "\"\n");

        Estatisticas estatisticas = new Estatisticas();

        ProcessadorCaractere processadorEspaco = new ProcessadorEspaco();
        ProcessadorCaractere processadorLetraA = new ProcessadorLetraA();
        ProcessadorCaractere processadorPonto = new ProcessadorPonto();

        processadorEspaco.definirProximo(processadorLetraA);
        processadorLetraA.definirProximo(processadorPonto);
        ProcessadorCaractere primeiroEloDaCorrente = processadorEspaco;

        for (char caractereIndividual : textoEntrada.toCharArray()) {
            primeiroEloDaCorrente.processar(caractereIndividual, estatisticas);
        }

        System.out.println(estatisticas.toString());
    }

    private static String lerArquivo(String caminhoArquivo) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linhaAtual;
            while ((linhaAtual = leitor.readLine()) != null) {
                conteudo.append(linhaAtual).append(System.lineSeparator());
            }
        }
        return conteudo.toString();
    }
}