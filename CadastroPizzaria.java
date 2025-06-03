import java.util.Scanner;

public class CadastroPizzaria {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Olá, bem-vindo à Pizzaria 2 Irmão!");
            System.out.println("Deseja realizar um cadastro ou gostaria de ver nosso cardápio?");
            System.out.println("Opção 1 - Realizar cadastro");
            System.out.println("Opção 2 - Ver cardápio");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> {
                    // Chama o método ou classe de cadastro de pessoas
                    CadastroPessoas.realizarCadastro(scanner);
                }
                case 2 -> {
                    // Chama o método ou classe do cardápio
                    Cardapio.mostrarCardapio();
                }
                default -> System.out.println("Opção inválida. Por favor, tente novamente.");
            }

            // Ir para o código de cadastro de pessoas diretamente
            System.out.println("\nIndo para o cadastro de pessoas...");
            CadastroPessoas.realizarCadastro(scanner);

        }
    }
}

// Classe Cardapio adicionada para evitar erro de símbolo não encontrado
class Cardapio {
    public static void mostrarCardapio() {
        System.out.println("Indo para o cardápio...");
    }
}

// Classe CadastroPessoas adicionada para evitar erro de símbolo não encontrado
class CadastroPessoas {
    public static void realizarCadastro(Scanner scanner) {
        System.out.println("Cadastro realizado com sucesso!");
        // Aqui você pode adicionar a lógica de cadastro de pessoas
    }
}
