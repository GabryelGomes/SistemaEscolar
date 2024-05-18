import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaEscolar {

    private static HashMap<String, ArrayList<Double>> alunos = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("MENU");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar nota");
            System.out.println("3 - Calcular média de um aluno");
            System.out.println("4 - Listar os nomes dos alunos sem notas");
            System.out.println("5 - Excluir aluno");
            System.out.println("6 - Excluir nota");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarNota();
                    break;
                case 3:
                    calcularMedia();
                    break;
                case 4:
                    listarAlunosSemNotas();
                    break;
                case 5:
                    excluirAluno();
                    break;
                case 6:
                    excluirNota();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 7);
    }

    private static void cadastrarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        if (alunos.containsKey(nome)) {
            System.out.println("Aluno já cadastrado!");
        } else {
            alunos.put(nome, new ArrayList<>());
            System.out.println("Aluno cadastrado com sucesso!");
        }
    }

    private static void cadastrarNota() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        if (alunos.containsKey(nome)) {
            System.out.print("Digite a nota: ");
            double nota = scanner.nextDouble();
            scanner.nextLine();  // Consumir nova linha
            alunos.get(nome).add(nota);
            System.out.println("Nota cadastrada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void calcularMedia() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        if (alunos.containsKey(nome)) {
            ArrayList<Double> notas = alunos.get(nome);
            if (notas.isEmpty()) {
                System.out.println("Aluno não possui notas cadastradas.");
            } else {
                double soma = 0;
                for (double nota : notas) {
                    soma += nota;
                }
                double media = soma / notas.size();
                System.out.println("A média do aluno " + nome + " é: " + media);
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void listarAlunosSemNotas() {
        System.out.println("Alunos sem notas cadastradas:");
        for (String nome : alunos.keySet()) {
            if (alunos.get(nome).isEmpty()) {
                System.out.println(nome);
            }
        }
    }

    private static void excluirAluno() {
        System.out.print("Digite o nome do aluno a ser excluído: ");
        String nome = scanner.nextLine();
        if (alunos.containsKey(nome)) {
            alunos.remove(nome);
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void excluirNota() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        if (alunos.containsKey(nome)) {
            ArrayList<Double> notas = alunos.get(nome);
            if (notas.isEmpty()) {
                System.out.println("Aluno não possui notas para excluir.");
            } else {
                System.out.print("Digite a nota a ser excluída: ");
                double nota = scanner.nextDouble();
                scanner.nextLine();  // Consumir nova linha
                if (notas.remove(nota)) {
                    System.out.println("Nota excluída com sucesso!");
                } else {
                    System.out.println("Nota não encontrada!");
                }
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }
}
