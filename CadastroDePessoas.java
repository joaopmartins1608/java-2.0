import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroDePessoas {
    public static void cpes() {
        try (Scanner sc = new Scanner(System.in)) {
            String nome, telefone, tipoPessoa, documento = "", senha = "", endereco = "";
            boolean valido;

            System.out.print("Digite o nome: ");
            nome = sc.nextLine();

            do {
                System.out.print("Digite o telefone (DDD + número, 12 dígitos): ");
                telefone = sc.nextLine().replaceAll("\\D", "");
                valido = telefone.length() == 12;
                if (!valido) System.out.println("Telefone inválido. Tente novamente.");
            } while (!valido);

            do {
                System.out.print("Pessoa Física (1) ou Jurídica (2): ");
                tipoPessoa = sc.nextLine();
                valido = tipoPessoa.equals("1") || tipoPessoa.equals("2");
                if (!valido) System.out.println("Opção inválida. Tente novamente.");
            } while (!valido);

            if (tipoPessoa.equals("2")) {
                do {
                    System.out.print("Digite o CNPJ (14 dígitos): ");
                    documento = sc.nextLine().replaceAll("\\D", "");
                    valido = documento.length() == 14;
                    if (!valido) System.out.println("CNPJ inválido. Tente novamente.");
                } while (!valido);

                do {
                    System.out.print("Crie uma senha de 4 dígitos: ");
                    senha = sc.nextLine();
                    valido = senha.length() == 4 && senha.matches("\\d{4}");
                    if (!valido) System.out.println("Senha inválida. Tente novamente.");
                } while (!valido);
            } else {
                do {
                    System.out.print("Digite o CPF (11 dígitos): ");
                    documento = sc.nextLine().replaceAll("\\D", "");
                    valido = documento.length() == 11;
                    if (!valido) System.out.println("CPF inválido. Tente novamente.");
                } while (!valido);

                System.out.print("Digite o endereço completo: ");
                endereco = sc.nextLine();
            }

            try (FileWriter writer = new FileWriter("exemplo.txt")) {
                writer.write("Cadastro realizado com sucesso!\n");
                writer.write("Nome: " + nome + "\n");
                writer.write("Telefone: " + telefone + "\n");
                writer.write("Tipo de Pessoa: " + (tipoPessoa.equals("1") ? "Física" : "Jurídica") + "\n");
                writer.write("Documento: " + documento + "\n");
                if (!senha.isEmpty()) writer.write("Senha cadastrada.\n");
                if (!endereco.isEmpty()) writer.write("Endereço: " + endereco + "\n");
                System.out.println("Arquivo salvo com sucesso!");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
            }

            System.out.println("\nCadastro realizado com sucesso!");
            System.out.println("Nome: " + nome);
            System.out.println("Telefone: " + telefone);
            System.out.println("Tipo de Pessoa: " + (tipoPessoa.equals("1") ? "Física" : "Jurídica"));
            System.out.println("Documento: " + documento);
            if (!senha.isEmpty()) System.out.println("Senha cadastrada.");
            if (!endereco.isEmpty()) System.out.println("Endereço: " + endereco);
        }
    }
}
