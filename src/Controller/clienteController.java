/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import org.apache.derby.iapi.types.ConcatableDataValue;
import Model.clienteModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;






public class clienteController {
    public void cadastrarclienteController(String nome, String cpf, String endereço, String idade, String email) {

        if ((nome != null && nome.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (endereço != null && endereço.length() > 0)
                && (idade != null && idade.length() > 0)
                && (email != null && email.length() > 0)
               ) {

           clienteModel novocliente = new clienteModel(nome, cpf, endereço, idade, email );

            novocliente.cadastrarclienteDAO(novocliente);

        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");

        }

    }

    public ArrayList<clienteModel> listarclienteController() {
        clienteModel cliente = new clienteModel();
        return cliente.listarclientes();

    }

    public void alterarcliente(String nome, String cpf, String endereço, String idade, String email) {
        if ((nome != null && nome.length() > 0)
                && (cpf != null && cpf.length() > 0)
                && (endereço != null && endereço.length() > 0)
                && (idade != null && idade.length() > 0)
                && (email != null && email.length() > 0)
               ) {

            clienteModel clienteAjuste = new clienteModel(nome, cpf, endereço, idade, email);
            clienteAjuste.alterarCliente(clienteAjuste);
            JOptionPane.showMessageDialog(null, "AJUSTE REALIZADO COM SUCESSO");
           }else{
            JOptionPane.showMessageDialog(null, "INFROMAÇÕES INCORRETAS");
        }   
    }
 

    public boolean excluirCliente(String nome) {
        if (nome != null && nome.length() > 0) {
            clienteModel nomeCliente = new clienteModel();
            nomeCliente.excluirCliente(nome);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, forneça um nome válido.");
            
        }
        return false;

    }
}

