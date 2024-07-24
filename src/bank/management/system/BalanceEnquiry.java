/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    ImageIcon i1,i3;
    Image i2;
    JLabel image;
    String pinnumber;
    JLabel balancelbl;
    
    BalanceEnquiry(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        this.add(image);
        
        JButton back = new JButton("Back");
        back.setBounds(355,557,150,38);
        back.addActionListener(this);
        image.add(back);
        
        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        balancelbl = new JLabel("Your Current Account Balance is Rs: "+balance);
        balancelbl.setForeground(Color.WHITE);
        balancelbl.setBounds(170,300,400,30);
        image.add(balancelbl);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber);
        
            
    }
    
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
