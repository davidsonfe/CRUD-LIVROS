
package br.recife.edu.ifpe.model.repositorios;

import br.recife.edu.ifpe.model.negocios.Livro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davidson Felix
 */
public class RepositorioLivro {
    
    private static int ultimoCodigo = 1;
    
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Livro> livros = new ArrayList<>();
    
    public static void inserir(Livro c){
        c.setId(ultimoCodigo++);
        livros.add(c);
    }
    
    public static void alterar(Livro c){
        
        for(Livro cont: livros){
            if(cont.getId() == c.getId()){
                cont.setTitulo(c.getTitulo());
                cont.setAutor(c.getAutor());
                cont.setCategoria(c.getCategoria());
                cont.setValor(c.getValor());
                cont.setDesc(c.getDesc());
            }
            return;
        }
    }
    
    public static Livro ler(int id){
        for(Livro c: livros){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    
    public static void delete(Livro c){
        
        Livro cAux = null;
        
        for(Livro cont: livros){
            if(cont.getId() == c.getId()){
                cAux = cont;
                break;
            }
        }
        
        livros.remove(cAux);
        
        
    }
    
    public static List<Livro> lerTudo(){
        return livros;
    }
    
}
