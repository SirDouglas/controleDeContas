/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Calendar;


public class Ganho {
private Long idRecebimento;
private String nomeRecebimento;
private Calendar dataRecebimento;
private Categoria categoria;
private double valorRecebimento;
private boolean situacaoRecebimento;
public long getIdRecebimento() {
	return idRecebimento;
}
public void setIdRecebimento(Long idRecebimento) {
	this.idRecebimento = idRecebimento;
}
public String getNomeRecebimento() {
	return nomeRecebimento;
}
public void setNomeRecebimento(String nomeRecebimento) {
	this.nomeRecebimento = nomeRecebimento;
}
public Calendar getDataRecebimento() {
	return dataRecebimento;
}
public void setDataRecebimento(Calendar data) {
	this.dataRecebimento = data;
}
public double getValorRecebimento() {
	return valorRecebimento;
}
public void setValorRecebimento(double valorRecebimento) {
	this.valorRecebimento = valorRecebimento;
}
public boolean isSituacaoRecebimento() {
	return situacaoRecebimento;
}
public void setSituacaoRecebimento(boolean situacaoRecebimento) {
	this.situacaoRecebimento = situacaoRecebimento;
}

public void receber(Calendar data) {
	this.dataRecebimento = data;
	this.setSituacaoRecebimento(true);
	
}
public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

}
