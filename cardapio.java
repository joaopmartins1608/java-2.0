import java.util.*;

public class cardapio {
    static class TamanhoPizza {
        String nome;
        String descricao;
        double fatorPreco;

        TamanhoPizza(String nome, String descricao, double fatorPreco) {
            this.nome = nome;
            this.descricao = descricao;
            this.fatorPreco = fatorPreco;
        }
    }

    static class SaborPizza {
        String nome;
        String descricao;
        double precoBase;

        SaborPizza(String nome, String descricao, double precoBase) {
            this.nome = nome;
            this.descricao = descricao;
            this.precoBase = precoBase;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

        // Tamanhos de pizza
        TamanhoPizza[] tamanhos = {
                new TamanhoPizza("Pequena", "20 a 25 cm | 4 a 6 fatias | 1 a 2 pessoas", 1.0),
                new TamanhoPizza("Média", "30 cm | 6 a 8 fatias | 2 a 3 pessoas", 1.3),
                new TamanhoPizza("Grande", "35 cm | 8 a 10 fatias | 3 a 4 pessoas", 1.6),
                new TamanhoPizza("Gigante", "40 a 45 cm | 10 a 12 fatias | 4 a 6 pessoas", 2.0),
                new TamanhoPizza("Família", "45 a 50 cm | 12 a 16 fatias | 5 a 7 pessoas", 2.5)
            };
            
            // Sabores de pizza
            SaborPizza[] sabores = {
                new SaborPizza("Calabresa Especial", "Calabresa fatiada, cebola roxa, mussarela e orégano", 28.00),
                new SaborPizza("Frango com Catupiry", "Frango desfiado, catupiry original, milho e mussarela", 35.00),
                new SaborPizza("Marguerita", "Mussarela, tomate, manjericão fresco e parmesão", 30.00),
                new SaborPizza("Quatro Queijos", "Mussarela, provolone, gorgonzola e requeijão cremoso", 36.00),
                new SaborPizza("Portuguesa", "Presunto, ovo, cebola, pimentão, ervilha, azeitona e mussarela", 38.00)
            };
            
            // Seleção do tamanho
            System.out.println("Escolha o tamanho da pizza:");
            for (int i = 0; i < tamanhos.length; i++) {
                System.out.printf("%d - %s (%s)\n", i + 1, tamanhos[i].nome, tamanhos[i].descricao);
            }
            int escolhaTamanho = 0;
            while (escolhaTamanho < 1 || escolhaTamanho > tamanhos.length) {
                System.out.print("Digite o número do tamanho desejado: ");
                escolhaTamanho = sc.nextInt();
            }
            TamanhoPizza tamanhoSelecionado = tamanhos[escolhaTamanho - 1];
            
            // Seleção dos sabores
            System.out.println("\nEscolha de 1 a 5 sabores para sua pizza:");
            for (int i = 0; i < sabores.length; i++) {
                System.out.printf("%d - %s: %s (R$ %.2f)\n", i + 1, sabores[i].nome, sabores[i].descricao, sabores[i].precoBase);
            }
            System.out.print("Quantos sabores deseja? (1 a 5): ");
            int qtdSabores = 0;
            while (qtdSabores < 1 || qtdSabores > 5) {
                qtdSabores = sc.nextInt();
            }
            Set<Integer> indicesSabores = new HashSet<>();
            while (indicesSabores.size() < qtdSabores) {
                System.out.print("Digite o número do sabor desejado: ");
                int idx = sc.nextInt();
                if (idx >= 1 && idx <= sabores.length) {
                    indicesSabores.add(idx - 1);
                } else {
                    System.out.println("Sabor inválido, tente novamente.");
                }
            }
            
            // Cálculo do valor
            double maiorPreco = 0;
            List<String> saboresEscolhidos = new ArrayList<>();
            for (int idx : indicesSabores) {
                saboresEscolhidos.add(sabores[idx].nome);
                if (sabores[idx].precoBase > maiorPreco) {
                    maiorPreco = sabores[idx].precoBase;
                }
            }
            double total = maiorPreco * tamanhoSelecionado.fatorPreco;
            
            // Exibe resumo e salva (simulação)
            System.out.println("\nResumo do pedido:");
            System.out.println("Tamanho: " + tamanhoSelecionado.nome + " (" + tamanhoSelecionado.descricao + ")");
            System.out.println("Sabores: " + String.join(", ", saboresEscolhidos));
            System.out.printf("Total a pagar: R$ %.2f\n", total);
            
            // Simula salvamento dos dados (poderia ser em arquivo ou banco de dados)
            salvarPedido(tamanhoSelecionado, saboresEscolhidos, total);
            
        System.out.println("\nObrigado por comprar na nossa pizzaria! Volte sempre!");
        }
    }

    static void salvarPedido(TamanhoPizza tamanho, List<String> sabores, double total) {
        // Aqui você pode implementar o salvamento em arquivo ou banco de dados.
        // Exemplo simples: apenas imprime que salvou.
        System.out.println("\nPedido salvo com sucesso!");
    }
}
