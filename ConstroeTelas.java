/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javax.swing.JFrame;


public class ConstroeTelas {
    public void adicionaConta() {
        TelaConta tela1 = new TelaConta();
        tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         tela1.setSize(300,200);
    tela1.setVisible(true);
    
    }
}
