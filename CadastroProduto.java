import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroProduto {
    public static void cp(Scanner scanner) {
        System.out.print("Código do Produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Custo (R$): ");
        double custo = scanner.nextDouble();
        System.out.print("Preço de Venda (R$): ");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        System.out.print("Código do Fornecedor: ");
        String codFornecedor = scanner.nextLine();

        try (FileWriter writer = new FileWriter("data/produtos.txt", true)) {
            writer.write("Código: " + codigo + ", Descrição: " + descricao + ", Custo: R$" + custo +
                         ", Preço de Venda: R$" + precoVenda + ", Fornecedor: " + codFornecedor + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar produto.");
        }

        Logger.registrar("Cadastro de produto - Código: " + codigo);
    }
}