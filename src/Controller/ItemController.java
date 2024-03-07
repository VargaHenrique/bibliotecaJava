/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.itemModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Username
 */
public class ItemController {
    
    public void  cadastrarItemController(String status, String dataLocacao, String dataDevolucao) {

        if ((status != null && status.length() > 0)
                && (dataLocacao != null && dataLocacao.length() > 0)
                && (dataDevolucao != null && dataDevolucao.length() > 0)
                )
               {

          itemModel novoitem = new itemModel(status, dataLocacao, dataDevolucao);
          novoitem.cadastraritemDAO(novoitem);
          System.out.println("METODO CONTROLLER CADASTRAR LIVRO EXECUTADO!");


        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");

        }

    }

    public ArrayList<itemModel> ListarItemController() {
        itemModel item = new itemModel();
        return item.listaritem();

    }

    public void alteraritem(String status, String dataLocacao, String dataDevolucao) {
         if ((status != null && status.length() > 0)
                && (dataLocacao != null && dataLocacao.length() > 0)
                && (dataDevolucao != null && dataDevolucao.length() > 0)
                )
               {

            itemModel itemAjuste = new itemModel(status, dataLocacao, dataDevolucao);
           itemAjuste.alterarItem(itemAjuste);
           JOptionPane.showMessageDialog(null, "AJUSTE REALIZADO COM SUCESSO");
           }else{
           JOptionPane.showMessageDialog(null, "INFROMAÇÕES INCORRETAS");
        
        }
    }

    public ArrayList<itemModel> excluirItem(String status) {
        itemModel item = new itemModel();
        return item.excluirItem(status); 
    }
        
    
    public ArrayList<itemModel> buscarItemController(String status) {
        itemModel item = new itemModel();
        return item.buscarItem(status); 
    }
}


