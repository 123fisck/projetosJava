//Bruno Veloso - RGM 5832482627


import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaVotacao sistema = new SistemaVotacao();

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Criar Partido: ");
            System.out.println("2. Criar Candidato: ");
            System.out.println("3. Votar");
            System.out.println("4. Exibir Resultados");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do partido:");
                    String nomePartido = scanner.nextLine();
                    System.out.println("Digite o número do partido (2 dígitos):");
                    int numeroPartido = scanner.nextInt();
                    Partido partido = new Partido(nomePartido, numeroPartido);
                    sistema.adicionarPartido(partido);
                    System.out.println("Partido " + nomePartido + " criado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o nome do candidato:");
                    String nomeCandidato = scanner.nextLine();
                    int numeroCandidato;

                    while (true) {
                        System.out.println("Digite o número do candidato (5 dígitos para vereador, 2 dígitos para prefeito): ");
                        String input = scanner.nextLine();
                    

                         try {
                        numeroCandidato = Integer.parseInt(input);


                        if (String.valueOf(numeroCandidato).length() == 5 || String.valueOf(numeroCandidato).length() == 2) {
                            break;
                        } else {
                            System.out.println("Número de candidato inválido. Por favor, insira um número com 5 dígitos (Vereador) ou 2 dígitos (Prefeito).");
                        }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Por favor insíra um número válido");
                        }
                    }

                    
                    int numeroPartidoCandidato = Integer.parseInt(String.valueOf(numeroCandidato).substring(0, 2));
                    Partido partidoCandidato = sistema.buscarPartidoPorNumero(numeroPartidoCandidato);

                    if (partidoCandidato != null) {
                        Candidato candidato = new Candidato(nomeCandidato, partidoCandidato, numeroCandidato);
                        sistema.adicionarCandidato(candidato);
                        System.out.println("Candidato " + nomeCandidato + " foi criado com sucesso.");
                    } else {
                        System.out.println("Partido não encontrado. Certifique-se de que o partido foi criado e que o número do candidato corresponde ao partido.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número do candidato para votar:");
                    int numeroVotoCandidato = scanner.nextInt();
                    sistema.votar(numeroVotoCandidato);
                    break;

                case 4:
                    sistema.exibirResultados();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
