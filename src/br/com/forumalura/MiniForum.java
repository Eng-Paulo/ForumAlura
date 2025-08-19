import java.util.ArrayList;
import java.util.Scanner;

// Classe interna para representar os tópicos
class Topico {
    String titulo;
    String mensagem;
    ArrayList<String> respostas = new ArrayList<>();

    Topico(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    void adicionarResposta(String resposta) {
        respostas.add(resposta);
    }
}

public class MiniForum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Topico> topicos = new ArrayList<>();

        while (true) {
            System.out.println("\n1 - Criar tópico");
            System.out.println("2 - Responder tópico");
            System.out.println("3 - Listar tópicos");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Mensagem: ");
                String mensagem = scanner.nextLine();
                topicos.add(new Topico(titulo, mensagem));
                System.out.println("Tópico criado!");
            }
            else if (opcao == 2) {
                if (topicos.isEmpty()) {
                    System.out.println("Nenhum tópico disponível.");
                    continue;
                }
                for (int i = 0; i < topicos.size(); i++) {
                    System.out.println(i + " - " + topicos.get(i).titulo);
                }
                System.out.print("Escolha o número do tópico: ");
                int index = Integer.parseInt(scanner.nextLine());
                System.out.print("Resposta: ");
                String resposta = scanner.nextLine();
                topicos.get(index).adicionarResposta(resposta);
                System.out.println("Resposta adicionada!");
            }
            else if (opcao == 3) {
                for (Topico t : topicos) {
                    System.out.println("\nTópico: " + t.titulo + "\nMensagem: " + t.mensagem);
                    for (String r : t.respostas) {
                        System.out.println(" - " + r);
                    }
                }
            }
            else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
