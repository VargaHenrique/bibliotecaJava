/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Username
 */
public class testeConexaoBancoDados {

    public static void main(String[] args) throws SQLException {

        ConexaoBDBiblioteca teste = new ConexaoBDBiblioteca();
        teste.getNewConnection();
        


        String buscaDados = "SELECT * FROM ROOT.USUARIO";
        ResultSet dadosBanco = teste.getNewConnection().createStatement().executeQuery(buscaDados);
        System.out.println("Execução result set");
        
        while (dadosBanco.next()) {
            System.out.println("CODIGO: " + dadosBanco.getString("CODIGO"));
            System.out.println("Usuario: " + dadosBanco.getString("NOME"));
            System.out.println("EMAIL: " + dadosBanco.getString("EMAIL"));
        }

    }

}


// Bom, suspeitei desde o princípio...
// A aplicação estava usando uma classe criada em outro projeto; antes
// ela inocava o metodo ConexaoDB com 'c' maiúsulo;
// refatorei o arquivo, ele passou a apontar para o projeto local;
// Agora está acessando o banco de dados normalemente...
// Fiz a alteração no arquivo cliente banco de dados.. mas nele vcs terão que realizar
// as adaptações para o operação da aplicação biblioteca...
// Vocês ainda tem bastante trabalho. Façam um esforço para até quarta termos pelo meno a primeira tela
// em funciuonamento. A manutenção dos prazos de entrega são importantes, principalmente
// na formação profissional tática. 

// Agora é com vocês. Abs!

