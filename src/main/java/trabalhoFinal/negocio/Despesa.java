package trabalhoFinal.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Despesa {

    private int id;
    private String nome;
    private Categoria categoria;
    private Familiar familiar;
    private double valor;
    private Date data;

    public Despesa(int id, String nome, Categoria categoria, Familiar familiar, double valor, Date data) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.familiar = familiar;
        this.valor = valor;
        this.data = data;
    }

    public Despesa() {
        this.nome = "";
        this.categoria = null;
        this.familiar = null;
        this.valor = 0;
        this.data = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        return outputFormat.format(this.data);
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
