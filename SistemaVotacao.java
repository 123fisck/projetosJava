import java.util.ArrayList;
import java.util.List;

public class SistemaVotacao {

    private List<Candidato> candidatos;
    private List<Partido> partidos;

    public SistemaVotacao() {
        this.candidatos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void adicionarPartido(Partido partido) {
        this.partidos.add(partido);
    }

    public void adicionarCandidato(Candidato candidato) {
        this.candidatos.add(candidato);
    }

    public Partido buscarPartidoPorNumero(int numero) {
        for (Partido partido : partidos) {
            if (partido.getNumero() == numero) {
                return partido;
            }
        }
        return null;
    }

    public void votar(int numeroCandidato) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numeroCandidato) {
                candidato.adicionarVoto();
                candidato.getPartido().adicionarVoto(); // Adiciona voto ao partido
                System.out.println("Voto registrado para " + candidato.getNome() + " do partido " + candidato.getPartido().getNome());
                return;
            }
        }
        System.out.println("Candidato não encontrado");
    }

    public void exibirResultados() {
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato registrado.");
            return;
        }

        // Separar candidatos por tipo
        List<Candidato> candidatosPrefeito = new ArrayList<>();
        List<Candidato> candidatosVereador = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (String.valueOf(candidato.getNumero()).length() == 2) {
                candidatosPrefeito.add(candidato);
            } else if (String.valueOf(candidato.getNumero()).length() == 5) {
                candidatosVereador.add(candidato);
            }
        }

        // Encontrar o vencedor de cada categoria
        Candidato vencedorPrefeito = encontrarVencedor(candidatosPrefeito);
        Candidato vencedorVereador = encontrarVencedor(candidatosVereador);

        // Encontrar o partido vencedor
        Partido partidoVencedor = encontrarPartidoVencedor();

        System.out.println("Vencedor para Prefeito: " + (vencedorPrefeito != null ? vencedorPrefeito.getNome() : "Nenhum candidato a prefeito"));
        System.out.println("Vencedor para Vereador: " + (vencedorVereador != null ? vencedorVereador.getNome() : "Nenhum candidato a vereador"));
        System.out.println("Partido vencedor: " + (partidoVencedor != null ? partidoVencedor.getNome() : "Nenhum partido vencedor"));
    }

    private Candidato encontrarVencedor(List<Candidato> candidatos) {
        if (candidatos.isEmpty()) return null;
        Candidato vencedor = candidatos.get(0);
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > vencedor.getVotos()) {
                vencedor = candidato;
            }
        }
        return vencedor;
    }

    private Partido encontrarPartidoVencedor() {
        if (partidos.isEmpty()) return null;
        Partido vencedor = partidos.get(0);
        for (Partido partido : partidos) {
            if (partido.getVotos() > vencedor.getVotos()) {
                vencedor = partido;
            }
        }
        return vencedor;
    }
}
