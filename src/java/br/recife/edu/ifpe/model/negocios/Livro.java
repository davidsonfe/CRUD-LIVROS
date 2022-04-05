
package br.recife.edu.ifpe.model.negocios;

/**
 *
 * @author Davidson Felix
 */
public class Livro {
    
    private int id;
    private String titulo;
    private String autor;
    private String categoria;
    private String valor;
    private String desc;

    public Livro( String titulo, String autor, String categoria, String valor, String desc) {
        
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.valor = valor;
        this.desc = desc;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
