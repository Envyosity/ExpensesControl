package trabalhoFinal.negocio;

public class Categoria {
 
    private String nome;
    private int id;

    public Categoria(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Categoria() {
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
    public String toString()
    {
        return this.nome;
    }
    
    public boolean equals(Object object)
    {
        Categoria c = (Categoria)object;
        
        return (this.id == c.id);
    }
    
}
