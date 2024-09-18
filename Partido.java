public class Partido {

    private String nome;
    private int numero;
    private int votos;

    public Partido(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.votos = 0;
    }

    public String getNome() { 
        return nome; 
    }

    public int getNumero() { 
        return numero; 
    }

    public int getVotos() { 
        return votos; 
    }

    public void adicionarVoto() { 
        this.votos++; 
    }
}
