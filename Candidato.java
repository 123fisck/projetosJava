public class Candidato implements Votavel {

    private String nome;
    private Partido partido;
    private int numero;
    private int votos;
    private String tipo;  // "Vereador" ou "Prefeito"

    public Candidato(String nome, Partido partido, int numero) {
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.votos = 0;

        // Verifica o tipo de candidato com base no número de dígitos
        if (String.valueOf(numero).length() == 5) {
            this.tipo = "Vereador";
        } else if (String.valueOf(numero).length() == 2) {
            this.tipo = "Prefeito";
        } else {
            throw new IllegalArgumentException("Número de candidato inválido");
        }
    }

    @Override
    public void adicionarVoto() {
        this.votos++;
        this.partido.adicionarVoto();
    }

    @Override
    public int getVotos() {
        return this.votos;
    }

    public String getNome() {
        return this.nome;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getNumeroPartido() {
        if (this.tipo.equals("Vereador")) {
            return Integer.parseInt(String.valueOf(numero).substring(0, 2));
        } else {
            throw new UnsupportedOperationException("Prefeito não possui número de partido separado.");
        }
    }
}
