import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Endereco {
    private final String cep;
    private final String cidade;
    private final String bairro;
    private final String rua;
    private final String tipoResidencia; // Casa ou Condomínio
    private final String numero;
    private final String complemento;
    private final String nomeCondominio;
    private final String bloco;
    private final String apartamento;
    private final String tipoEndereco; // Residencial, Comercial, Somente Entrega, etc.

    public Endereco(String cep, String cidade, String bairro, String rua, String tipoResidencia,
                    String numero, String complemento, String nomeCondominio, String bloco,
                    String apartamento, String tipoEndereco) {
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.tipoResidencia = tipoResidencia;
        this.numero = numero;
        this.complemento = complemento;
        this.nomeCondominio = nomeCondominio;
        this.bloco = bloco;
        this.apartamento = apartamento;
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CEP: ").append(cep)
          .append(", Cidade: ").append(cidade)
          .append(", Bairro: ").append(bairro)
          .append(", Rua: ").append(rua)
          .append(", Tipo: ").append(tipoResidencia);
        if (tipoResidencia.equalsIgnoreCase("Casa")) {
            sb.append(", Número: ").append(numero);
            if (complemento != null && !complemento.isEmpty()) {
                sb.append(", Complemento: ").append(complemento);
            }
        } else if (tipoResidencia.equalsIgnoreCase("Condomínio")) {
            sb.append(", Condomínio: ").append(nomeCondominio)
              .append(", Número: ").append(numero);
            if (bloco != null && !bloco.isEmpty()) {
                sb.append(", Bloco: ").append(bloco);
            }
            if (apartamento != null && !apartamento.isEmpty()) {
                sb.append(", Apartamento: ").append(apartamento);
            }
        }
        sb.append(", Tipo de Endereço: ").append(tipoEndereco);
        return sb.toString();
    }
}

class Pessoa {
    private final String nome;
    private final List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void adicionarEndereco(Endereco endereco) {
        if (enderecos.size() < 5) {
            enderecos.add(endereco);
        } else {
            System.out.println("Limite de 5 endereços atingido.");
        }
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public String getNome() {
        return nome;
    }
}

public class CadastroDeEndereco {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Simulação do cadastro de pessoa
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nome);

        System.out.println("1 - Cadastrar endereço");
        System.out.println("2 - Sair");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Cadastro de endereço " + (i + 1));
                Endereco endereco = cadastrarEndereco();
                pessoa.adicionarEndereco(endereco);

                if (i < 4) {
                    System.out.print("Deseja cadastrar outro endereço? (s/n): ");
                    String resp = scanner.nextLine();
                    if (!resp.equalsIgnoreCase("s")) {
                        break;
                    }
                }
            }
            System.out.println("Endereços cadastrados para " + pessoa.getNome() + ":");
            for (Endereco e : pessoa.getEnderecos()) {
                System.out.println(e);
            }
            System.out.println("Redirecionando para o cardápio...");
            // Aqui você pode chamar o método/menu do cardápio
        } else {
            System.out.println("Saindo...");
        }
    }

    private static Endereco cadastrarEndereco() {
        String cep;
        do {
            System.out.print("CEP (somente 8 números): ");
            cep = scanner.nextLine();
        } while (!cep.matches("\\d{8}"));

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        String tipoResidencia;
        do {
            System.out.print("Tipo de residência (Casa/Condomínio): ");
            tipoResidencia = scanner.nextLine();
        } while (!tipoResidencia.equalsIgnoreCase("Casa") && !tipoResidencia.equalsIgnoreCase("Condomínio"));

        String numero;
        String complemento = null;
        String nomeCondominio = null;
        String bloco = null;
        String apartamento = null;

        if (tipoResidencia.equalsIgnoreCase("Casa")) {
            System.out.print("Número: ");
            numero = scanner.nextLine();
            System.out.print("Complemento (opcional): ");
            complemento = scanner.nextLine();
        } else {
            System.out.print("Nome do condomínio: ");
            nomeCondominio = scanner.nextLine();
            System.out.print("Número: ");
            numero = scanner.nextLine();
            System.out.print("Bloco (opcional): ");
            bloco = scanner.nextLine();
            System.out.print("Apartamento (opcional): ");
            apartamento = scanner.nextLine();
        }

        System.out.print("Tipo de endereço (Residencial, Comercial, Somente Entrega, etc): ");
        String tipoEndereco = scanner.nextLine();

        return new Endereco(cep, cidade, bairro, rua, tipoResidencia, numero, complemento, nomeCondominio, bloco, apartamento, tipoEndereco);
    }
}
