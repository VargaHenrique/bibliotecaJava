/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import DAO.AutorBancoDeDados; 



/**
 *
 * @author Username
 */
public class autorModel {

    private String nome;
    private String nacionalidade;
    
    public autorModel(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
       
    }  

    public autorModel() {
        //new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNascionalidade() {
        return nacionalidade;
    }
     
    public void setNascionalidade(String nacionalidade){
     this.nacionalidade = nacionalidade;
    } 
    
    
    
    public void cadastrarAutorDAO(autorModel novoautor){
        AutorBancoDeDados novoRegistro = new AutorBancoDeDados();
         novoRegistro.inserirAutorBD(novoautor);
        System.out.println("METODO MODEL CADASTRAR LIVRO EXECUTADO!");
    }
    
    public ArrayList<autorModel> listarautor(){
        return new AutorBancoDeDados().listarTodosAutores();
    }
    
    public void alterarAutor(autorModel autorAjuste){
        AutorBancoDeDados ajusteDados = new AutorBancoDeDados();
        ajusteDados.alterarautorBD(autorAjuste);

    }
    
    public boolean excluirAutor(String nome){
        new AutorBancoDeDados().excluirAutor(nome);
        return false;
    }
   
     public ArrayList<autorModel> buscarAutores(String nome){
         return new AutorBancoDeDados().buscarAutores(nome); 
    }
    
}
