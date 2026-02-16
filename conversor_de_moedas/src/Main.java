import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Declaração de valores para URL de requisição da API
        String ApiKey = "0a8f3ac3000c3203ff655628";

        String url = "https://v6.exchangerate-api.com/v6/%s/latest/BRL".formatted(ApiKey);
        // Para uso futuro:
        //String currentCoin = "BRL";

        //String url = "https://v6.exchangerate-api.com/v6/pair/%s/%s/%s".formatted(ApiKey, currentCoin, targetCoin);

        // Criando cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criando a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Criando a variavel que vai armazenar as taxas
        JsonObject rates = null;

        try {
            // Enviando requisição e recebendo resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Conversão para JSON
            JsonElement element = JsonParser.parseString(response.body());
            JsonObject objectRoot = element.getAsJsonObject();

            // Formatando retorno para exibir em teste
            /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonFormatado = gson.toJson(element);

            System.out.println(jsonFormatado);*/

            // Accessando o JsonObject e salvando a lista de taxas
            rates = objectRoot.getAsJsonObject("conversion_rates");
        } catch (Exception e){
            System.out.print("Ocorreu um erro ao efetuar a requisição e não foi possível obter o retorno das taxas vigentes.\nErro: " + e);
        }

        String home = """
        =========================
           CONVERSOR DE MOEDAS
        =========================
        1 - Converter moeda
        2 - Atualizar taxas
        0 - Sair
        
        Opção: 
        """;

        String conversionMenu = """
        =========================
            CONVERSÃO (BRL)
        =========================
        Escolha a moeda destino:

        1 - BRL → USD (Dólar americano)
        2 - BRL → ARS (Peso argentino)
        3 - BRL → BOB (Boliviano boliviano)
        4 - BRL → CLP (Peso chileno)
        5 - BRL → COP (Peso colombiano)
        0 - Voltar ao menu principal
        
        Opção: 
        """;

        Scanner input = new Scanner(System.in);
        int opcao = -1;
        int subOpcao = -1;

        while(opcao != 0){
            System.out.println(home);
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    while(subOpcao != 0){
                        System.out.print(conversionMenu);

                        subOpcao = input.nextInt();
                        input.nextLine();

                        // variavel que vai armazenar o valor da taxa de conversão escolhida pelo usuário para o calculo.
                        String targetCoin = "BRL";

                        switch (subOpcao) {
                            case 1:
                                targetCoin = "USD"; // Dólar americano
                                break;
                            case 2:
                                targetCoin = "ARS"; // Peso argentino
                                break;
                            case 3:
                                targetCoin = "BOB"; // Boliviano boliviano
                                break;
                            case 4:
                                targetCoin = "CLP"; // Peso chileno
                                break;
                            case 5:
                                targetCoin = "COP"; // Peso colombiano
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida! Escolha novamente.");
                        }

                        // Só calcula se o usuário escolheu uma moeda válida (1 a 5)
                        if (subOpcao >= 1 && subOpcao <= 5) {
                            double taxa = rates.get(targetCoin).getAsDouble();

                            System.out.print("Digite o valor em BRL: ");
                            double valorBRL = input.nextDouble();
                            input.nextLine();

                            double valorConvertido = valorBRL * taxa;
                            System.out.printf("%.2f BRL = %.2f %s%n", valorBRL, valorConvertido, targetCoin);
                        }
                    }
                    // 🔹 reset do submenu para funcionar corretamente na próxima vez
                    subOpcao = -1;
                    break;
                case 2:
                    try {
                        // Enviando requisição e recebendo resposta
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                        // Conversão para JSON
                        JsonElement element = JsonParser.parseString(response.body());
                        JsonObject objectRoot = element.getAsJsonObject();

                        // Formatando retorno para exibir em teste
                        /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonFormatado = gson.toJson(element);

                        System.out.println(jsonFormatado);*/

                        // Accessando o JsonObject e salvando a lista de taxas
                        rates = objectRoot.getAsJsonObject("conversion_rates");

                        System.out.println("Taxas atualizadas com sucesso!");
                    } catch (Exception e){
                        System.out.print("Ocorreu um erro ao efetuar a requisição e não foi possível obter o retorno das taxas vigentes.\nErro: " + e.getMessage());
                    };
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}