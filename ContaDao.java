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
import java.util.List;


public class ContaDao {
    private final Connection connection;

    public ContaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Conta conta) {
        String sql =    "insert into Conta " +
                "(idPagamento,dataPagamento,nomePagamento,categoriaPagamento,situacaoPagamento,valorPagamento)" +
                "values (?,?,?,?,?,?)";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             
             //seta os valores
             stmt.setLong(1, conta.getIdPagamento());
             stmt.setDate(2, new Date(conta.getDataPagamento().getTimeInMillis()));
             stmt.setString(3, conta.getNomePagamento());
             stmt.setString(4, conta.getCategoria().getNome());
             stmt.setBoolean(5, conta.isSituacaoPagamento());
             stmt.setDouble(6, conta.getValorPagamento());
             
             //executa
             stmt.execute();
             stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Conta> getLista() {
        try {
            List<Conta> contas = new ArrayList<Conta>();
            PreparedStatement stm = this.connection.prepareStatement("select * from Conta");
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                //criando o Objeto Conta
                Conta conta = new Conta();
                conta.setIdPagamento(rs.getLong("idPagamento"));
                conta.setNomePagamento(rs.getString("nomePagamento"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataPagamento"));
                conta.setDataPagamento(data);
                Categoria categoria = new Categoria();
                categoria.setNome(rs.getString("categoriaPagamento"));
                conta.setCategoria(categoria);
                conta.setValorPagamento(rs.getDouble("valorPagamento"));
                conta.setSituacaoPagamento(rs.getBoolean("situacaoPagamento"));
                contas.add(conta);
            }
            rs.close();
                    stm.close();
                    return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void altera(Conta conta) {
        String sql = "update Conta set nomePagamento=?,dataPagamento=?,valorPagamento=?" +
                "situacaoPagamento=?,categoriaPagamento=? where idPagamento=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, conta.getNomePagamento());
            stmt.setDate(2, new Date (conta.getDataPagamento().getTimeInMillis()));
            stmt.setDouble(3, conta.getValorPagamento());
            stmt.setBoolean(4, conta.isSituacaoPagamento());
            stmt.setString(5, conta.getCategoria().getNome());
            stmt.setLong(5, conta.getIdPagamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void remove(Conta conta) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from Conta where idPagamento=?");
            stmt.setLong(1, conta.getIdPagamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    public double getSoma(Calendar data) {
        String sql = "SELECT sum(valorPagamento)  as valor FROM `fj21`.`Conta` where dataPagamento  between ? and ?";
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
 
