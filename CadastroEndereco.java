import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroEndereco {
    public static String cadastrarEndereco(String tipoPessoa, Scanner scanner) {
        System.out.println("Cadastro de Endereço para " + tipoPessoa);
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Logradouro: ");
        String logradouro = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();
        System.out.print("Tipo de Endereço (comercial, residencial, etc.): ");
        String tipoEndereco = scanner.nextLine();

        String enderecoCompleto = cep + " - " + logradouro + ", " + numero + " (" + tipoEndereco + ") " + complemento;
        try (FileWriter writer = new FileWriter("data/enderecos.txt", true)) {
            writer.write("Tipo Pessoa: " + tipoPessoa + ", Endereço: " + enderecoCompleto + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar endereço.");
        }

        Logger.registrar("Cadastro de endereço - " + enderecoCompleto);
        return enderecoCompleto;
    }
}