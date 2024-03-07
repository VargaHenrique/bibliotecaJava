/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.itemModel; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Username
 */
public class ItemBancoDeDados {

    private String status;
    // por exemplo; ajustem os atriutos para receber um usuário que contenha o construtor do modelo
    // implementado na camada model...
    // O que está definido abaixo, ainda é o que fizemos na atividade da aula..
    
    public void inserirItemBD(itemModel novoitem) {
        String sql = "INSERT INTO ITEM (status, dataLocacao, dataDevolucao) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;
        System.out.println("METODO DAO INSERIR LIVRO EXECUTADO!");

        try {
            connection = new ConexaoBDBiblioteca().getNewConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoitem.getStatus());
            stmt.setString(2, novoitem.getDataLocacao());
            stmt.setString(3, novoitem.getDataDevolucao());     
            stmt.execute();
            System.out.println("REGISTRO REALIZADO COM SUCESSO!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR O REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");

            }

        }
    }
        
        
        public ArrayList<itemModel> listarTodosItem() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        itemModel item = null;
        ArrayList<itemModel> listaitem = null;
        
        String sql = "SELECT * FROM ROOT.ITEM";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaitem = new ArrayList<>();
                while (rs.next()) {
                    item = new itemModel();
                    item.setStatus(rs.getString("Status"));
                    item.setDataLocacao(rs.getString("DataLocacao"));
                    item.setDataDevolucao(rs.getString("DataDevolucao"));
                    listaitem.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR O REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }

        }
        System.out.println("Lista: " + listaitem);
        return listaitem;
        
    }
        
        public void alteraritemBD(itemModel itemAjuste) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.ITEM SET dataLocacao=?, dataDevolucao=? "
                + "WHERE status=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, itemAjuste.getStatus());
            stmt.setString(2, itemAjuste.getDataLocacao());
            stmt.setString(3, itemAjuste.getDataDevolucao());
            stmt.executeUpdate();
            System.out.println("Alteração do registro realizada do sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR A ALTERAÇÃO DO REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }
        }   
    }
  
        public ArrayList<itemModel> excluirItem(String status) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        itemModel item = null;
        ArrayList<itemModel> listaitem = null;

        String sql = "DELETE FROM ROOT.ITEM WHERE status LIKE '%" + status + "%' ORDER BY status";

        try{
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaitem = new ArrayList<>();
                while (rs.next()) {
                    item = new itemModel();
                    item.setStatus(rs.getString("Status"));
                    item.setDataLocacao(rs.getString("DataLocacao"));
                    item.setDataDevolucao(rs.getString("DataDevolucao"));
                    listaitem.add(item);
                }
            }
            System.out.println("DADOS COLETADOS NO BANCO DE DADOS COM SUCESSO");
        
        } catch(Exception ex){
        ex.printStackTrace();
        System.out.println("ERRO AO REALIZAR O REGISTRO");
   
        }finally{
         try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }
        }
        return listaitem;

    }
        
        public ArrayList<itemModel> buscarItems(String status){
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        itemModel item = null;
        ArrayList<itemModel> listaitem = null;
        
        String sql = "SELECT * FROM ROOT.ITEM WHERE status LIKE '%" + status + "%' ORDER BY status";
        
        try{
        
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaitem = new ArrayList<>();
                while (rs.next()) {
                    item = new itemModel();
                    item.setStatus(rs.getString("Status"));
                    item.setDataLocacao(rs.getString("DataLocacao"));
                    item.setDataDevolucao(rs.getString("DataDevolucao"));
                    listaitem.add(item);
                }
            }
            System.out.println("DADOS COLETADOS NO BANCO DE DADOS COM SUCESSO");
        
        }catch(Exception ex){
        ex.printStackTrace();
        System.out.println("ERRO AO REALIZAR O REGISTRO");
   
        }finally{
         try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }
        }
        return listaitem;
    }

 }
