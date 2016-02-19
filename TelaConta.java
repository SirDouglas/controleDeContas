/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
   



public class TelaConta  extends JFrame{
    
    private JLabel texto;
    private JLabel texto1;
    private JLabel texto2;
    private JLabel texto3;
    private JLabel texto4;
    private JLabel texto5;
    private JLabel texto6;
    private JTextField id;
    private JTextField nome;
    private JTextField data;
    private JTextField valor;
    private JCheckBox situacao;
    private JComboBox categoria;
    private JButton botao1;
    private JButton botao2;
    private ButtonHandler handler = new ButtonHandler();

    public TelaConta() {
        super("Usando rotulos");
        setLayout(new FlowLayout());
        Categoria categoria1 = new Categoria();
        categoria1.setNome("Nome");
        CategoriaDao dao1 = new CategoriaDao();
         texto = new JLabel("Id");
        texto1 = new JLabel("Nome");
        texto2 = new JLabel("Data");
        texto3 = new JLabel("Valor");
        texto4 = new JLabel("Situacao");
        texto5 = new JLabel("Categoria");
        id = new JTextField(20);
        nome = new JTextField(20);
        data = new JTextField(20);
        valor = new JTextField(20);
        situacao = new JCheckBox("Pago");
        categoria = new JComboBox();
        categoria.addItem(categoria1.getNome());
        botao1 = new JButton("Adicionar");
        botao2 = new JButton("Limpar");
        botao1.addActionListener(handler);
        botao2.addActionListener(handler);
        
        add(texto);
        add(id);
        add(texto1);
        add(nome);
        add(texto2);
        add(data);
        add(texto3);
        add(valor);
        add(texto4);
        add(situacao);
        add(texto5);
        add(categoria);
          add(botao1);
        add(botao2);

    }
    
    
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == botao1) {
                JOptionPane.showMessageDialog(null, "Bom dia");
                Conta conta = new Conta();
                ContaDao dao = new ContaDao();
                conta.setIdPagamento(Long.getLong(id.getText()));
                conta.setNomePagamento(nome.getText());
                conta.setValorPagamento(Double.parseDouble(valor.getText()));
                Categoria categoria1 = new Categoria();
                categoria1.setNome(categoria.getSelectedItem().toString());
                conta.setCategoria(categoria1);
                conta.setSituacaoPagamento(situacao.isSelected());
                Calendar calendar = Calendar.getInstance();
                String data1 = data.getText();
                SimpleDateFormat dataFormata = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    calendar.setTime(dataFormata.parse(data1));
                } catch (ParseException ex) {
                    Logger.getLogger(TelaConta.class.getName()).log(Level.SEVERE, null, ex);
                }
                 conta.setDataPagamento(calendar);
                 dao.adiciona(conta);
                
                
                
            }
            
            if (evento.getSource() == botao2) {
                id.setText("");
                nome.setText("");
                data.setText("");
                categoria.setSelectedItem("");
                situacao.setSelected(false);
                valor.setText("");
                
            }
        }
        
    }
    
}
