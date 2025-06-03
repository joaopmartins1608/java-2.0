import java.util.Scanner;

public class CadastroDePessoas {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            String nome, telefone, tipoPessoa, tipoCadastro, documento = "", senha = "", endereco = "";
            boolean valido;

            // Nome
            System.out.print("Digite o nome: ");
            nome = sc.nextLine();

        // Telefone
        do {
            System.out.print("Digite o telefone (DDD + número, 12 dígitos): ");
            telefone = sc.nextLine().replaceAll("\\D", "");
            valido = telefone.length() == 12;
            if (!valido) System.out.println("Telefone inválido. Tente novamente.");
        } while (!valido);

        // Tipo de pessoa
        do {
            System.out.print("Pessoa Física (1) ou Jurídica (2): ");
            tipoPessoa = sc.nextLine();
            valido = tipoPessoa.equals("1") || tipoPessoa.equals("2");
            if (!valido) System.out.println("Opção inválida. Tente novamente.");
        } while (!valido);

        // Tipo de cadastro
        do {
            System.out.print("Cliente (1), Fornecedor (2) ou Ambos (3): ");
            tipoCadastro = sc.nextLine();
            valido = tipoCadastro.equals("1") || tipoCadastro.equals("2") || tipoCadastro.equals("3");
            if (!valido) System.out.println("Opção inválida. Tente novamente.");
        } while (!valido);

        // Documentos e senha
        switch (tipoCadastro) {
            case "2" -> { // Fornecedor
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
            }
            case "3" -> { // Ambos
                String opcaoDoc;
                do {
                    System.out.print("Deseja cadastrar CPF (1) ou CNPJ (2)? ");
                    opcaoDoc = sc.nextLine();
                    valido = opcaoDoc.equals("1") || opcaoDoc.equals("2");
                    if (!valido) System.out.println("Opção inválida. Tente novamente.");
                } while (!valido);

                if (opcaoDoc.equals("1")) {
                    do {
                        System.out.print("Digite o CPF (11 dígitos): ");
                        documento = sc.nextLine().replaceAll("\\D", "");
                        valido = documento.length() == 11;
                        if (!valido) System.out.println("CPF inválido. Tente novamente.");
                    } while (!valido);
                } else {
                    do {
                        System.out.print("Digite o CNPJ (14 dígitos): ");
                        documento = sc.nextLine().replaceAll("\\D", "");
                        valido = documento.length() == 14;
                        if (!valido) System.out.println("CNPJ inválido. Tente novamente.");
                    } while (!valido);
                }

                do {
                    System.out.print("Crie uma senha de 4 dígitos: ");
                    senha = sc.nextLine();
                    valido = senha.length() == 4 && senha.matches("\\d{4}");
                    if (!valido) System.out.println("Senha inválida. Tente novamente.");
                } while (!valido);
            }
            default -> { // Cliente
                do {
                    System.out.print("Digite o CPF (11 dígitos): ");
                    documento = sc.nextLine().replaceAll("\\D", "");
                    valido = documento.length() == 11;
                    if (!valido) System.out.println("CPF inválido. Tente novamente.");
                } while (!valido);

                // Cadastro de endereço
                System.out.println("Cadastro de Endereço:");
                System.out.print("Digite o endereço completo: ");
                endereco = sc.nextLine();
            }
        }

        // Aqui você pode salvar os dados em um banco de dados, arquivo, etc.
        System.out.println("\nCadastro realizado com sucesso!");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Tipo de Pessoa: " + (tipoPessoa.equals("1") ? "Física" : "Jurídica"));
        System.out.println("Tipo de Cadastro: " + (tipoCadastro.equals("1") ? "Cliente" : tipoCadastro.equals("2") ? "Fornecedor" : "Ambos"));
        System.out.println("Documento: " + documento);
        if (!senha.isEmpty()) System.out.println("Senha cadastrada.");
        if (!endereco.isEmpty()) System.out.println("Endereço: " + endereco);

        }
    }
}
