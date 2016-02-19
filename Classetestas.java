/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Classetestas {
    public void testaInsere() {
   
        
    }
    
    public void testaLista() {
        ContaDao dao = new ContaDao();
        List<Conta> contas = new ArrayList();
       contas = dao.getLista();
        System.out.println(contas.get(0).getCategoria().getNome());
    }
    
    public void testaSoma() {
        ContaDao dao = new ContaDao();
        GanhoDao dao1 = new GanhoDao();
        Calendar data = Calendar.getInstance();
               Calendar data1 = Calendar.getInstance();
        System.out.println("Somar contas " + dao.getSoma(data));
        System.out.println("Somar ganhos " + dao1.getSoma(data1));
    }
    
}
