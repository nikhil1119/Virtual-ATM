/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame{
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 140, 350, 200); // Set bounds for the scroll pane
        add(scrollPane);
        
        JLabel mini = new JLabel();
        scrollPane.setViewportView(mini);
//        mini.setBounds(20,70,100,100);
//        add(mini);
        
        
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
//            mini.setText("Hello");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your account balance is Rs "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
//        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(500,120);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                new Transactions(pinnumber);
            }});
        }
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
