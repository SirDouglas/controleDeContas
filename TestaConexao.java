/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class TestaConexao {
    public void testar  () {
        Connection conexao = new ConnectionFactory().getConnection();
       System.out.println("Conexao Aberta");
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(TestaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
