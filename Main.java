import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Olá, bem-vindo à Pizzaria 2 Irmão!");
            System.out.println("Deseja realizar um cadastro ou gostaria de ver nosso cardápio?");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Cardápio de Produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1 -> CadastroPessoas.cpes();
                case 2 -> CadastroEndereco.cadastrarEndereco("Pessoa", scanner);
                case 3 -> CadastroProduto.cp(scanner);
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}


