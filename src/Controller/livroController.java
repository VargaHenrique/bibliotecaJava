/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.LivroBancoDeDados;
import org.apache.derby.iapi.types.ConcatableDataValue;
import Model.livroModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Username
 */
public class livroController {
    
     
    

    public void cadastrarLivroController(String titulo, String genero, String paginas, String sinopse) {
    
        if ((titulo != null && titulo.length() > 0)
                && (genero != null && genero.length() > 0)
                && (paginas != null && paginas.length() > 0)
                && (sinopse != null && sinopse.length() > 0)
                
               ) {

            
          livroModel novolivro = new livroModel( titulo, genero, paginas, sinopse);
          novolivro.cadastrarlivroDAO(novolivro);
            System.out.println("METODO CONTROLLER CADASTRAR LIVRO EXECUTADO!");
        }else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
        }
  
        
    }
    

    public ArrayList<livroModel> listarLivroController() {
        livroModel livro = new livroModel();
        return livro.listarlivro();

    }
    
    
    

    public void alterarlivro(String titulo, String genero, String paginas, String sinopse) {
                if ((titulo != null && titulo.length() > 0)
                && (genero != null && genero.length() > 0)
                && (paginas != null && paginas.length() > 0)
                && (sinopse != null && sinopse.length() > 0)
                  
                
               ){
            livroModel livroAjuste = new livroModel(titulo, genero, paginas, sinopse);
        livroAjuste.alterarLivro(livroAjuste);
        JOptionPane.showMessageDialog(null, "AJUSTE REALIZADO COM SUCESSO");
        }else{
        JOptionPane.showMessageDialog(null, "INFROMAÇÕES INCORRETAS");
        
        }
    }

    
    
   public boolean excluirLivro(String titulo) {
        if (titulo != null && titulo.length() > 0) {
            livroModel nomelivro = new livroModel();
            nomelivro.excluirLivro(titulo);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, forneça um título válido.");
            
        }
        return false;
    }
   
   
   public ArrayList<livroModel> buscarLivroController(String titulo) {
        livroModel livro = new livroModel();
        return livro.buscarlivros(titulo);

    }
  
}