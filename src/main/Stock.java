/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Panorama121
 */
public class Stock extends JFrame {

    public Stock() {

        initComponent();
        setUpAction();

    }

    private void initComponent() {

        ImageIcon img = new ImageIcon("img/admin.png");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setIconImage(img.getImage());
        setLocationRelativeTo(null);
        //getContentPane().setLayout(new FlowLayout());
        //getContentPane().setLayout(null);
        getContentPane().setBackground(Color.GRAY);
        setTitle("Admin");

        //Panel 1 (Add Item)
        jpPan1 = new JPanel();
        jpPan1.setLayout(null);
        //jpPan1.setSize(500, 300);

//        GridBagConstraints cons = new GridBagConstraints();
//        cons.anchor = GridBagConstraints.WEST;
//        cons.insets = new Insets(10, 10, 10, 10);

        //Input item name
        jlbItem = new JLabel("Item name");
        jlbItem.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbItem.setBounds(8, 5, 100, 35);
        jtfItem = new JTextField(20);
        //jtfItem.setPreferredSize(new Dimension(20, 30));
        jtfItem.setBounds(110, 7, 200, 30);

        //Input Quantity item
        jlbQua = new JLabel("Quantity");
        jlbQua.setFont(new Font("SansSerif", Font.PLAIN, 20));
        jlbQua.setBounds(20, 20, 100, 75);
        jtfQua = new JTextField(10);
        //jtfQua.setPreferredSize(new Dimension(20, 30));
        jtfQua.setBounds(110, 48, 100, 30);

        //Add item name and quantity
        jbAdd = new JButton("Add");
        jbAdd.setBounds(110, 90, 100, 30);
        jbAdd.setPreferredSize(new Dimension(100, 30));
        jbAdd.setBackground(Color.DARK_GRAY);
        jbAdd.setForeground(Color.WHITE);

        //See added item list
        jbStock = new JButton("Stock");
        jbStock.setBounds(110, 130, 100, 30);
        jbStock.setPreferredSize(new Dimension(100, 30));
        jbStock.setBackground(Color.LIGHT_GRAY);
        
        
//        cons.gridx = 0;
//        cons.gridy = 0;
        jpPan1.add(jlbItem);
        
//        cons.gridx = 1;
        jpPan1.add(jtfItem);
        
//        cons.gridx = 0;
//        cons.gridy = 1;
        jpPan1.add(jlbQua);

//        cons.gridx = 1;
        jpPan1.add(jtfQua);

//        cons.gridx = 0;
//        cons.gridy = 2;
        jpPan1.add(jbAdd);

//        cons.gridx = 1;
//        cons.gridy = 2;
        jpPan1.add(jbStock);

        jpPan2 = new JPanel();

        jtpPn = new JTabbedPane();
        jtpPn.setSize(500, 300);
        jtpPn.add("Stock", jpPan1);
        jtpPn.add("Menu", jpPan2);

        add(jtpPn);
//        add(jpPan1);

    }

    private void setUpAction() {

        //Add Stock
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbAddClick(e);
            }
        });

        //See stock
        jbStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jbStockClick(e);
            }
        });

    }

    private void jbAddClick(ActionEvent e) {

        int result = JOptionPane.showConfirmDialog((Component) null, "Add stock ?", "alert", JOptionPane.OK_CANCEL_OPTION);
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Success");
        }

    }

    private void jbStockClick(ActionEvent e) {

        JFrame showStock = new JFrame();
        showStock.setSize(300, 400);
        showStock.setLocation(1000, 350);
        showStock.setResizable(false);

        String[] colname = {"No.", "Item", "Quantity"};
        String[][] data = {{"1", "Java Bean", "20"},
        {"2", "Toraja Bean", "15"},
        {"3", "Papua Bean", "15"}};

        jtbStock = new JTable(data, colname);
        jtbStock.setBounds(95, 130, 100, 30);

        jscJsc1 = new JScrollPane(jtbStock);
        showStock.add(jscJsc1);
        showStock.setVisible(true);
    }

    public static void main(String[] args) {

        new Stock().setVisible(true);

    }

    JButton jbAdd;
    JButton jbStock;

    JTextField jtfItem;
    JTextField jtfQua;

    JLabel jlbItem;
    JLabel jlbQua;

    JTable jtbStock;
    JScrollPane jscJsc1;

    JPanel jpPan1;
    JPanel jpPan2;

    JTabbedPane jtpPn;
    JSplitPane jspPn;
}
