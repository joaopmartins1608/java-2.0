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
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    CadastroDePessoas.cpes();
                    //CadastroPessoas.realizarCadastro(scanner);
                    break;
                }
                case 2 -> {
                    Cardapio.mostrarCardapio();
                    break;
                }
                default -> System.out.println("Opção inválida. Por favor, tente novamente.");
            }
            
            
        }
    }
}

/* 
class CadastroPessoas {
    public static void realizarCadastro(Scanner scanner) {
        System.out.println("Indo para o cadastro de pessoas...");
        
        
    }
}
*/

class Cardapio {
    public static void mostrarCardapio() {
        System.out.println("Indo para o cardápio...");
        
    }
}
