import java.util.*;

class Endereco {
    private final String cep, cidade, bairro, rua, tipoResidencia, numero, complemento, nomeCondominio, bloco, apartamento, tipoEndereco;

    public Endereco(String cep, String cidade, String bairro, String rua, String tipoResidencia, String numero,
                    String complemento, String nomeCondominio, String bloco, String apartamento, String tipoEndereco) {
        this.cep = cep; this.cidade = cidade; this.bairro = bairro; this.rua = rua; this.tipoResidencia = tipoResidencia;
        this.numero = numero; this.complemento = complemento; this.nomeCondominio = nomeCondominio;
        this.bloco = bloco; this.apartamento = apartamento; this.tipoEndereco = tipoEndereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CEP: ").append(cep).append(", Cidade: ").append(cidade)
            .append(", Bairro: ").append(bairro).append(", Rua: ").append(rua)
            .append(", Tipo: ").append(tipoResidencia).append(", Número: ").append(numero);
        if (tipoResidencia.equalsIgnoreCase("Casa")) {
            if (complemento != null && !complemento.isEmpty()) sb.append(", Complemento: ").append(complemento);
        } else {
            sb.append(", Condomínio: ").append(nomeCondominio);
            if (bloco != null && !bloco.isEmpty()) sb.append(", Bloco: ").append(bloco);
            if (apartamento != null && !apartamento.isEmpty()) sb.append(", Apartamento: ").append(apartamento);
        }
        return sb.append(", Tipo de Endereço: ").append(tipoEndereco).toString();
    }
}

class Pessoa {
    private final String nome;
    private final List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(String nome) { this.nome = nome; }
    public void adicionarEndereco(Endereco e) {
        if (enderecos.size() < 5) enderecos.add(e);
        else System.out.println("Limite de 5 endereços atingido.");
    }
    public List<Endereco> getEnderecos() { return enderecos; }
    public String getNome() { return nome; }
}

public class CadastroDeEndereco {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite o nome do usuário: ");
        Pessoa pessoa = new Pessoa(sc.nextLine());

        System.out.println("1 - Cadastrar endereço\n2 - Sair");
        if (!sc.nextLine().equals("1")) {
            System.out.println("Saindo...");
            return;
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Cadastro de endereço " + (i + 1));
            pessoa.adicionarEndereco(cadastrarEndereco());
            if (i < 4) {
                System.out.print("Deseja cadastrar outro endereço? (s/n): ");
                if (!sc.nextLine().equalsIgnoreCase("s")) break;
            }
        }

        System.out.println("Endereços cadastrados para " + pessoa.getNome() + ":");
        pessoa.getEnderecos().forEach(System.out::println);
        System.out.println("Redirecionando para o cardápio...");
    }

    private static Endereco cadastrarEndereco() {
        String cep;
        do {
            System.out.print("CEP (somente 8 números): ");
            cep = sc.nextLine();
        } while (!cep.matches("\\d{8}"));

        System.out.print("Cidade: "); String cidade = sc.nextLine();
        System.out.print("Bairro: "); String bairro = sc.nextLine();
        System.out.print("Rua: "); String rua = sc.nextLine();

        String tipoResidencia;
        do {
            System.out.print("Tipo de residência (Casa/Condomínio): ");
            tipoResidencia = sc.nextLine();
        } while (!tipoResidencia.equalsIgnoreCase("Casa") && !tipoResidencia.equalsIgnoreCase("Condomínio"));

        String numero, complemento = "", cond = "", bloco = "", apto = "";
        if (tipoResidencia.equalsIgnoreCase("Casa")) {
            System.out.print("Número: "); numero = sc.nextLine();
            System.out.print("Complemento (opcional): "); complemento = sc.nextLine();
        } else {
            System.out.print("Nome do condomínio: "); cond = sc.nextLine();
            System.out.print("Número: "); numero = sc.nextLine();
            System.out.print("Bloco (opcional): "); bloco = sc.nextLine();
            System.out.print("Apartamento (opcional): "); apto = sc.nextLine();
        }

        System.out.print("Tipo de endereço (Residencial, Comercial, etc): ");
        String tipoEndereco = sc.nextLine();

        return new Endereco(cep, cidade, bairro, rua, tipoResidencia, numero, complemento, cond, bloco, apto, tipoEndereco);
    }
}
