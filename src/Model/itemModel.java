/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ItemBancoDeDados;
import java.util.ArrayList;

/**
 *
 * @author Username
 */
public class itemModel {

   
    private String status;
    private String dataLocacao;
    private String dataDevolucao;
   


    public itemModel(String status, String dataLocacao, String dataDevolucao) {
        this.status = status;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

   
    public itemModel(String status, String dataDevolucao) {
        this.status = status;
        this.dataDevolucao = dataDevolucao;
        
    }

    public itemModel() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void cadastraritemDAO(itemModel novoitem) {
        ItemBancoDeDados novoRegistro = new ItemBancoDeDados();
        novoRegistro.inserirItemBD(novoitem);
        System.out.println("METODO MODEL CADASTRAR LIVRO EXECUTADO!");
    }

    public ArrayList<itemModel> listaritem() {
        return new ItemBancoDeDados().listarTodosItem();
    }

    public void alterarItem(itemModel itemAjuste) {
        ItemBancoDeDados ajusteDados = new ItemBancoDeDados();
        ajusteDados.alteraritemBD(itemAjuste);
    }
 
    public ArrayList<itemModel> excluirItem(String status) {
        return new ItemBancoDeDados().excluirItem(status); 
    }

     public ArrayList<itemModel> buscarItem(String status){
          return new ItemBancoDeDados().buscarItems(status);
    }

}
