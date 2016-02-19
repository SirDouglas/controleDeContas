/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author tiago
 */
public class GanhoDao {
    private final Connection connection;

    public GanhoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Ganho ganho) {
        String sql = "insert INTO Ganho"  +
                "(idRecebimento,dataRecebimento,nomeRecebimento,situacaoRecebimento,valorRecebimento,categoria)" +
                 "values(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, ganho.getIdRecebimento());
            stmt.setDate(2, new Date (ganho.getDataRecebimento().getTimeInMillis()));
            stmt.setString(3, ganho.getNomeRecebimento());
            stmt.setBoolean(4, ganho.isSituacaoRecebimento());
            stmt.setDouble(5, ganho.getValorRecebimento());
            stmt.setLong(6, ganho.getCategoria().getId());
            
               //executa
             stmt.execute();
             stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        
    }
    
    public java.util.List<Ganho> getGanho() {
        try {
            java.util.List<Ganho> ganhos = new ArrayList<Ganho>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Ganho");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ganho ganho  = new Ganho();
                ganho.setIdRecebimento(rs.getLong("idRecebimento"));
                Categoria categoria = new Categoria();
                categoria.setId(rs.getLong("categoria"));
                ganho.setNomeRecebimento(rs.getString("nomeRecebimento"));
                ganho.setCategoria(categoria);
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataRecebimento"));
                ganho.setDataRecebimento(data);
                ganho.setSituacaoRecebimento(rs.getBoolean("situacaoRecebimento"));
                ganho.setValorRecebimento(rs.getDouble("valorRecebimento"));
                ganhos.add(ganho);
            }
            rs.close();
            stmt.close();
            return ganhos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
    public void altera(Ganho ganho)  {
        String sql = "update Ganho set nomeRecebimento=?" +
        "categoria=?,dataRecebimento=?,situacaoRecebimento=?"
                + "valorRecebimento=? where idRecebimento=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ganho.getNomeRecebimento());
            stmt.setLong(2, ganho.getCategoria().getId());
            stmt.setDate(3, new Date(ganho.getDataRecebimento().getTimeInMillis()));
            stmt.setBoolean(4, ganho.isSituacaoRecebimento());
            stmt.setDouble(5, ganho.getValorRecebimento());
            stmt.setLong(6, ganho.getIdRecebimento());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
    public void remove(Ganho ganho) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from Ganho where idRecebimento=?");
            stmt.setLong(1,ganho.getIdRecebimento());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    

public double getSoma(Calendar data) {
       String sql = "SELECT sum(valorRecebimento)  as valor  FROM `fj21`.`Ganho`"
               + " where dataRecebimento  between ? and ?";
        try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setDate(1, new Date(data.getTimeInMillis()));
           Calendar data1 = Calendar.getInstance();
           data1 = data;
            data1.add(Calendar.MONDAY, 1);
           stmt.setDate(2, new Date(data1.getTimeInMillis()));
           ResultSet rs = stmt.executeQuery();
           rs.next();
     double valor = rs.getDouble("valor");
           return valor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

}
}





    
    
    
    

