/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tiago
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "tiago", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
