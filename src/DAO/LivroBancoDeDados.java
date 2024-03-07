/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.livroModel; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
//import javax.management.remote.JMXConnectorFactory;


/**
 *
 * @author Username
 */
public class LivroBancoDeDados {

    private String titulo;
    // por exemplo; ajustem os atriutos para receber um usuário que contenha o construtor do modelo
    // implementado na camada model...
    // O que está definido abaixo, ainda é o que fizemos na atividade da aula..
      
    
    public void inserirlivroBD(livroModel novolivro){
        String sql = "INSERT INTO LIVRO (titulo, genero, paginas, sinopse) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;
        System.out.println("METODO DAO INSERIR LIVRO EXECUTADO!");

        try {
            connection = new ConexaoBDBiblioteca().getNewConnection();
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, novolivro.getTitulo());
            stmt.setString(2, novolivro.getGenero());
            stmt.setString(3, novolivro.getPaginas());
            stmt.setString(4, novolivro.getSinopse());
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
        
        
        public ArrayList<livroModel> listarTodosLivros() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        livroModel livro = null;
        ArrayList<livroModel> listalivro = null;
        
        String sql = "SELECT * FROM ROOT.LIVRO";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listalivro = new ArrayList<>();
                while (rs.next()) {
                    livro = new livroModel();
                    
                    livro.setTitulo(rs.getString("Titulo"));
                    livro.setGenero(rs.getString("Genero"));
                    livro.setPaginas(rs.getString("Paginas"));
                    livro.setSinopse(rs.getString("Sinopse"));
                    listalivro.add(livro);
                }
            }
            System.out.println("DADOS COLETADOS NO BANCO DE DADOS COM SUCESSO");
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
        System.out.println("Lista: " + listalivro);
        return listalivro;  
    }
 
        
        public ArrayList<livroModel> buscarLivros(String titulo){
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        livroModel livro = null;
        ArrayList<livroModel> listalivro = null;
        
        String sql = "SELECT * FROM ROOT.LIVRO WHERE titulo LIKE '%" + titulo + "%' ORDER BY titulo";
        
        try{
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listalivro = new ArrayList<>();
                while (rs.next()) {
                    livro = new livroModel();
                    
                    livro.setTitulo(rs.getString("Titulo"));
                    livro.setGenero(rs.getString("Genero"));
                    livro.setPaginas(rs.getString("Paginas"));
                    livro.setSinopse(rs.getString("Sinopse"));
                    listalivro.add(livro);
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
        return listalivro;
    }
        
        
        public void alterarlivroBD(livroModel livroAjuste) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.LIVRO SET genero=?, paginas=?, sinopse=? "
                + "WHERE titulo=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
      
             stmt.setString(1, livroAjuste.getGenero());
             stmt.setString(2, livroAjuste.getPaginas());
             stmt.setString(3, livroAjuste.getSinopse());
             stmt.setString(4, livroAjuste.getTitulo());

             stmt.executeUpdate();
             System.out.println("Alteração do registro realizada com sucesso");

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
        
        
        public void excluirLivro(String titulo){
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.LIVRO WHERE titulo=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
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
  

