import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PessoaJuridica {
    public static void cadastrarPJ() {
        try (Scanner sc = new Scanner(System.in)) {
            String razaoSocial, telefone, cnpj, senha, enderecoStr;
            boolean valido;

            System.out.print("Digite a razão social: ");
            razaoSocial = sc.nextLine();

            do {
                System.out.print("Digite o telefone (DDD + número, 12 dígitos): ");
                telefone = sc.nextLine().replaceAll("\\D", "");
                valido = telefone.length() == 12;
                if (!valido) System.out.println("Telefone inválido. Tente novamente.");
            } while (!valido);

            do {
                System.out.print("Digite o CNPJ (14 dígitos): ");
                cnpj = sc.nextLine().replaceAll("\\D", "");
                valido = cnpj.length() == 14;
                if (!valido) System.out.println("CNPJ inválido. Tente novamente.");
            } while (!valido);

            do {
                System.out.print("Crie uma senha de 4 dígitos: ");
                senha = sc.nextLine();
                valido = senha.matches("\\d{4}");
                if (!valido) System.out.println("Senha inválida. Tente novamente.");
            } while (!valido);

            System.out.println("\nCadastro de endereço da empresa:");
            Endereco endereco = CadastroDeEndereco.cadastrarEndereco();
            enderecoStr = endereco.toString();

            try (FileWriter writer = new FileWriter("exemplo.txt", true)) {
                writer.write("Cadastro realizado com sucesso!\n");
                writer.write("Razão Social: " + razaoSocial + "\n");
                writer.write("Telefone: " + telefone + "\n");
                writer.write("Tipo de Pessoa: Jurídica\n");
                writer.write("Documento (CNPJ): " + cnpj + "\n");
                writer.write("Senha cadastrada.\n");
                writer.write("Endereço: " + enderecoStr + "\n");
                writer.write("====================================\n");
                System.out.println("Arquivo salvo com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
            }

            System.out.println("\nCadastro realizado com sucesso!");
            System.out.println("Razão Social: " + razaoSocial);
            System.out.println("Telefone: " + telefone);
            System.out.println("Tipo de Pessoa: Jurídica");
            System.out.println("Documento: " + cnpj);
            System.out.println("Senha cadastrada.");
            System.out.println("Endereço: " + enderecoStr);
            System.out.println("Redirecionando para o cardápio...");

            Cardapio.exibirCardapio(razaoSocial, cnpj);
        }
    }
}

