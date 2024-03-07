/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import org.apache.derby.iapi.types.ConcatableDataValue;
import javax.swing.JOptionPane;
import Model.autorModel; 
import java.util.ArrayList;
/**
 *
 * @author Username
 */
public class AutorController {
    
     public void cadastrarAutorController(String nome, String nacionalidade) {

        if ((nome != null && nome.length() > 0)
                && (nacionalidade != null && nacionalidade.length() > 0) 
               ) {

           autorModel novoautor = new autorModel(nome, nacionalidade);
             novoautor.cadastrarAutorDAO(novoautor);
            System.out.println("METODO CONTROLLER CADASTRAR LIVRO EXECUTADO!");
        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");

        }

    }

    public ArrayList<autorModel> listarAutorController() {
        autorModel autor = new autorModel();
        return autor.listarautor(); 

    }

    public void alterarautor(String nome, String nacionalidade) {
        if ((nome != null && nome.length() > 0)
                && (nacionalidade != null && nacionalidade.length() > 0)
                
               ){

         autorModel autorAjuste = new autorModel(nome, nacionalidade);
        autorAjuste.alterarAutor(autorAjuste); 
        JOptionPane.showMessageDialog(null, "AJUSTE REALIZADO COM SUCESSO");
        }else{
        JOptionPane.showMessageDialog(null, "INFROMAÇÕES INCORRETAS");
        
        }
    }

    public boolean excluiAutor(String nome) {
        if (nome != null && nome.length() > 0) {
            autorModel nomeautor = new autorModel();
             nomeautor.excluirAutor(nome);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, forneça um nome válido.");
            
        }
        return false;
    }
    
       public ArrayList<autorModel> buscarAutorController(String nome) {
        autorModel autor = new autorModel();
       return autor.buscarAutores(nome); 
    }
    
}
