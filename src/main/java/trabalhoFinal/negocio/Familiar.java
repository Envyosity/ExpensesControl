package trabalhoFinal.negocio;

public class Familiar {

    private String nome;
    private int id;

    public Familiar(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Familiar() {
        this.nome = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
        public boolean equals(Object object)
    {
        Familiar f = (Familiar)object;
        
        return (this.id == f.id);
    }
}
