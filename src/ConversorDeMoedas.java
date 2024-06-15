import java.util.Scanner;

public class ConversorDeMoedas {
    private final ConsultaCotacaoAtual consultaCotacaoAtual;

    public ConversorDeMoedas(String apiKey) {
        this.consultaCotacaoAtual = new ConsultaCotacaoAtual(apiKey);
    }

    public void converterMoeda(String moedaDe, String moedaPara) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o valor em " + moedaDe + ": ");
            double valor = Double.parseDouble(scanner.nextLine());

            double taxa = consultaCotacaoAtual.obterTaxaDeCambio(moedaDe, moedaPara);
            double resultado = valor * taxa;
            System.out.println("Valor em " + moedaPara + ": " + resultado + "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
