/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.clienteModel; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;



/**
 *
 * @author Username
 */
public class ClienteBancoDeDados {

    private String nome;
    // por exemplo; ajustem os atriutos para receber um usuário que contenha o construtor do modelo
    // implementado na camada model...
    // O que está definido abaixo, ainda é o que fizemos na atividade da aula..
    
    public void inserirclientesBD(clienteModel novocliente) {
        String sql = "INSERT INTO USUARIO (cpf, nome,endereco, datanascimento, email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBDBiblioteca().getNewConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novocliente.getCPF());
            stmt.setString(2, novocliente.getNome());
            stmt.setString(3, novocliente.getEndereço());
            stmt.setString(4, novocliente.getIdade());
            stmt.setString(5, novocliente.getEmail());
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
        
        
        public ArrayList<clienteModel> listarTodosClientes() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        clienteModel cliente = null;
        ArrayList<clienteModel> listaclientes = null;
        
        String sql = "SELECT * FROM ROOT.USUARIO";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaclientes = new ArrayList<>();
                while (rs.next()) {
                    cliente = new clienteModel();
                    cliente.setNome(rs.getString("Nome"));
                    cliente.setCPF(rs.getString("CPF"));
                    cliente.setEndereço(rs.getString("Endereco"));
                    cliente.setIdade(rs.getString("datanascimento"));
                    cliente.setEmail(rs.getString("Email"));
                    listaclientes.add(cliente);
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
        System.out.println("Lista: " + listaclientes);
        return listaclientes;
        
    }
        
        public void alterarclienteBD(clienteModel clienteAjuste){

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.USUARIO SET cpf=?, endereco=?, datanascimento=?, email=? "
                + "WHERE nome=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, clienteAjuste.getCPF());
            stmt.setString(2, clienteAjuste.getEndereço());
            stmt.setString(3, clienteAjuste.getIdade());
            stmt.setString(4, clienteAjuste.getEmail());
            stmt.setString(5, clienteAjuste.getNome());

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
        
        
        public void excluirCliente(String nome) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.USUARIO WHERE nome=?";

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


