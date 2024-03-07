
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.LivroBancoDeDados;
import java.util.ArrayList;
import org.apache.derby.diag.ContainedRoles;
/**
 *
 * @author Username
 */
public class livroModel {
    
  
    private String titulo;
    private String genero;
    private String paginas;
    private String sinopse;
  

    
    public livroModel(int codigo, String titulo, String genero, String paginas, String sinopse) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.sinopse = sinopse;
     
    }
    
   public livroModel(String titulo, String paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
       
    }  
   
    public livroModel(String titulo, String genero, String paginas, String sinopse) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.sinopse = sinopse;
    }
   

    public livroModel() {
        //new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
       public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getGenero() {
        return genero;
    }
     
    public void setGenero(String genero){
     this.genero = genero;
    } 
    
    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
   
    
   
    
    
    public void cadastrarlivroDAO(livroModel novolivro){
        LivroBancoDeDados novoRegistro = new LivroBancoDeDados();
        novoRegistro.inserirlivroBD(novolivro);
        System.out.println("METODO MODEL CADASTRAR LIVRO EXECUTADO!");
    }
    
    public ArrayList<livroModel> listarlivro(){
        return new LivroBancoDeDados().listarTodosLivros();
    }
    
    public void alterarLivro(livroModel livroAjuste){
        LivroBancoDeDados ajusteDados = new LivroBancoDeDados();
        ajusteDados.alterarlivroBD(livroAjuste);
    }
    
    public boolean excluirLivro(String titulo){
        new LivroBancoDeDados().excluirLivro(titulo);
        return false;
    }
   
    public ArrayList<livroModel> buscarlivros(String titulo){
        return new LivroBancoDeDados().buscarLivros(titulo);
    }

    
     
}
