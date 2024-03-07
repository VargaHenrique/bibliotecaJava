/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.autorModel; 
import org.apache.derby.iapi.types.ConcatableDataValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author Username
 */



public class AutorBancoDeDados {

private String nome; 
    
    public void inserirAutorBD(autorModel novoautor){
        String sql = "INSERT INTO AUTOR (nome, nacionalidade) VALUES (?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;
        System.out.println("METODO DAO INSERIR AUTOR EXECUTADO!");

        try {
            connection = new ConexaoBDBiblioteca().getNewConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoautor.getNome());
            stmt.setString(2, novoautor.getNascionalidade());
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
        
        
        public ArrayList<autorModel> listarTodosAutores() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        autorModel autor = null;
        ArrayList<autorModel> listaautor = null;
        
        String sql = "SELECT * FROM ROOT.AUTOR";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaautor = new ArrayList<>();
                while (rs.next()) {
                    autor = new autorModel();
                    autor.setNome(rs.getString("Nome"));
                    autor.setNascionalidade(rs.getString("Nacionalidade"));
                    listaautor.add(autor);
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
        System.out.println("Lista: " + listaautor);
        return listaautor;
    }
        
         public ArrayList<autorModel> buscarAutores(String nome){
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        autorModel autor = null;
        ArrayList<autorModel> listaautor = null;
        
        String sql = "SELECT * FROM ROOT.AUTOR WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
        
        try{
        
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaautor = new ArrayList<>();
                while (rs.next()) {
                    autor = new autorModel();
                    autor.setNome(rs.getString("Nome"));
                    autor.setNascionalidade(rs.getString("cionalidade"));
                    listaautor.add(autor);
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
        return listaautor;
    }
        
        
        
        public void alterarautorBD(autorModel autorAjuste) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.AUTOR SET nacionalidade=? "
                + "WHERE nome=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autorAjuste.getNome());
            stmt.setString(2, autorAjuste.getNascionalidade());
            
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
        
        
        public void excluirAutor(String nome){
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.AUTOR WHERE nome=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.execute();
            System.out.println("Exclusão realizada do sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR A EXCLUSÃO DO REGISTRO");
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
 }
