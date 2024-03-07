/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ClienteBancoDeDados;
import java.util.ArrayList;
import org.apache.derby.diag.ContainedRoles;

/**
 *
 * @author Username
 */
public class clienteModel {

    private int id;
    private String cpf;
    private String nome;
    private String endereço;
    private String idade;
    private String email;

    public clienteModel() {
    }
    


    public clienteModel(int id, String nome, String cpf, String endereço, String idade, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.endereço = endereço;
        this.idade = idade;
        this.email = email;
    }

    public clienteModel(String nome, String cpf, String endereço, String idade, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereço = endereço;
        this.idade = idade;
        this.email = email;

    }

    public clienteModel(String nome, String endereço) {
        this.nome = nome;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void cadastrarclienteDAO(clienteModel novocliente) {
        ClienteBancoDeDados novoRegistro = new ClienteBancoDeDados();
        novoRegistro.inserirclientesBD(novocliente);
    }

    public ArrayList<clienteModel> listarclientes() {
        return new ClienteBancoDeDados().listarTodosClientes();
    }

    public void alterarCliente(clienteModel clienteAjuste) {
        ClienteBancoDeDados ajusteDados = new ClienteBancoDeDados();
        ajusteDados.alterarclienteBD(clienteAjuste);
    }
    
    public boolean excluirCliente(String nome) {
        new ClienteBancoDeDados().excluirCliente(nome);
        return false; 
    }

}
