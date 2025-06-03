import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeProdutos {

    static class Produto {
        String nome;
        int quantidade;
        double valorUnitario;
        double valorTotal;
        String observacao;

        Produto(String nome, int quantidade, double valorUnitario, String observacao) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.valorUnitario = valorUnitario;
            this.valorTotal = quantidade * valorUnitario;
            this.observacao = observacao;
        }

        @Override
        public String toString() {
            return "Produto: " + nome +
                    ", Quantidade: " + quantidade +
                    ", Valor Unitário: R$" + valorUnitario +
                    ", Valor Total: R$" + valorTotal +
                    ", Observação: " + observacao;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Simulação da opção recebida do cadastro de usuário
            // 2 = fornecedor, 3 = ambos
            System.out.print("Informe sua opção (2 - Fornecedor, 3 - Ambos): ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            if (opcao == 2 || opcao == 3) {
                System.out.print("Nome de usuário: ");
                String nomeUsuario = sc.nextLine();
                System.out.println("Bem-vindo, " + nomeUsuario + "!");
                System.out.print("Senha cadastrada: ");
                sc.nextLine();
                System.out.println("Senha cadastrada com sucesso para o usuário " + nomeUsuario + ".");

                ArrayList<Produto> produtos = new ArrayList<>();
                int maxProdutos = 2000;
                int contador = 0;

                while (true) {
                    System.out.print("Nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    System.out.print("Valor unitário: ");
                    double valorUnitario = sc.nextDouble();
                    sc.nextLine(); // Limpar buffer

                    System.out.print("Observação: ");
                    String observacao = sc.nextLine();

                    produtos.add(new Produto(nomeProduto, quantidade, valorUnitario, observacao));
                    contador++;

                    if (contador >= maxProdutos) {
                        System.out.println("Limite máximo de produtos atingido.");
                        break;
                    }

                    System.out.print("Deseja cadastrar outro produto? (s/n): ");
                    String resp = sc.nextLine();
                    if (!resp.equalsIgnoreCase("s")) {
                        break;
                    }
                }

                // Simulação de salvamento das informações
                System.out.println("\nProdutos cadastrados:");
                for (Produto p : produtos) {
                    System.out.println(p);
                }

                // Aqui você pode salvar as informações em arquivo ou banco de dados

                if (opcao == 2) {
                    System.out.println("\nObrigado pelo cadastro, fornecedor!");
                    System.exit(0);
                } else if (opcao == 3) {
                    System.out.println("\nAgora vamos para o cadastro de endereço...");
                    // Chame aqui o método ou classe de cadastro de endereço
                    // Exemplo: CadastroDeEndereco.cadastrarEndereco(nomeUsuario);
                }
            } else {
                System.out.println("Opção inválida.");
            }

        }
    }
}
