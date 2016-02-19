/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;


public class CategoriaDao {
      private Connection connection;

    public CategoriaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
      
    public void adiciona(Categoria categoria) {
        String sql = "insert INTO Categoria "  +
                "(idCategoria,nomeCategoria)" +
               "values (?,?)" ;
          try {
            PreparedStatement stmt;
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, categoria.getId());
            stmt.setString(2, categoria.getNome());
          } catch (SQLException e)  {
             throw  new RuntimeException(e);
          }
        
                
    }
    
    public  java.util.List<Categoria> getLista() {
        try {
            java.util.List<Categoria> categorias;
            categorias = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Ganho");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
             Categoria categoria = new Categoria();
                categoria.setId(rs.getLong("id"));
                categoria.setNome(rs.getString("nomeCategoria"));
             categorias.add(categoria);
            }
            rs.close();
            stmt.close();
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
      

}
