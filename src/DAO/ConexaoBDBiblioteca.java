/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Username
 */


public class ConexaoBDBiblioteca {
    
    public Connection getNewConnection(){
        
    System.out.println("Executou classe");
    Connection conn = null; 
    String className = "org.apache.derby.jdbc.ClientDriver"; 
    String url = "jdbc:derby://localhost:1527/bibliotecaTeste"; 
    String user = "root";
    String password = "123";
        System.out.println("Etapa 1 concluida");
    
    try{
      Class.forName(className);
      System.out.println("ClassName com valor correto!!!");
    }catch(Exception e){
    e.printStackTrace();
    System.out.println("Erro ao realizar conexão");
    }
    
    try{
    conn = DriverManager.getConnection(url, user, password);
        System.out.println(" Conexão realizada com sucesso");
    }catch(Exception e){
    e.printStackTrace();
        System.out.println("Erro ao realizar a conexão junto a URL");
    }
    
    
   
    return conn;
    }
}
