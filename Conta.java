/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Calendar;


public class Conta {
private Long idPagamento;
private String nomePagamento;
private Calendar dataPagamento;
private double valorPagamento;
private Categoria categoria;
private boolean situacaoPagamento;
public Long getIdPagamento() {
	return idPagamento;
}
public void setIdPagamento(Long idPagamento) {
	this.idPagamento = idPagamento;
}
public String getNomePagamento() {
	return nomePagamento;
}
public void setNomePagamento(String nomePagamento) {
	this.nomePagamento = nomePagamento;
}
public Calendar getDataPagamento() {
	return dataPagamento;
}
public void setDataPagamento(Calendar dataPagamento) {
	this.dataPagamento = dataPagamento;
}
public double getValorPagamento() {
	return valorPagamento;
}
public void setValorPagamento(double valorPagamento) {
	this.valorPagamento = valorPagamento;
}
public boolean isSituacaoPagamento() {
	return situacaoPagamento;
}
public void setSituacaoPagamento(boolean situacaoPagamento) {
	this.situacaoPagamento = situacaoPagamento;
}
public void pagar() {
	this.situacaoPagamento = true;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

 
}

