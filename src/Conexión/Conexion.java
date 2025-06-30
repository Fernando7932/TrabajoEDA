/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fernando
 */
public class Conexion {

    public static Connection conectar() {
        
        /* 
        
        Método que realiza la conexión con la base de datos.
        
        Output:
        
        -> true: en caso se haga la conexión de manera satisfactoria.
        -> null: Error en la conexión, activa la excepción.
        
       
        */
        
        try {
            String url = "jdbc:mysql://103.23.61.21:3306/dbMagisTV?allowPublicKeyRetrieval=true&useSSL=false";
            String user = "Fernando";
            String password = "#967c7c@82A8A5*";
            Connection cn = DriverManager.getConnection(url, user, password);
            return cn;
            
        } catch (SQLException e) {
            System.out.println("Error en la conexión " + e);
            return null;
        }
    }
        

}