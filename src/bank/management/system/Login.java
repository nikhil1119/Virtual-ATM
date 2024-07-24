/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, signup;
    JTextField cardTF;
    JPasswordField  pinPTF;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        //disable default layout
        setLayout(null);
        
        //set icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //title
        JLabel title = new JLabel("Welcome To ATM");
        title.setFont(new Font("Osward",Font.BOLD, 38));
        add(title);
        title.setBounds(200, 40, 400, 40);
        
        //cardno
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD, 28));
        add(cardno);
        cardno.setBounds(120, 150, 400, 30);
        
        cardTF = new JTextField();
        cardTF.setBounds(300,150,230,30);
        cardTF.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTF);
        
        //pin
        JLabel text = new JLabel("PIN:");
        text.setFont(new Font("Raleway",Font.BOLD, 28));
        add(text);
        text.setBounds(120, 220, 400, 30);
        
        pinPTF = new JPasswordField();
        pinPTF.setBounds(300,220,230,30);
        add(pinPTF);
        
        //login button
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.red);
        login.addActionListener(this);
//        login.setForeground(Color.blue);
        add(login);
        
        //clear button
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.red);
        clear.addActionListener(this);
//        clear.setForeground(Color.blue);
        add(clear);
        
        //sign up button
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.red);
        signup.addActionListener(this);
//        signup.setForeground(Color.blue);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.white);
        
//        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTF.setText("");
            pinPTF.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTF.getText();
            String pinnumber = pinPTF.getText();
            String query = "SELECT * FROM login WHERE card_number = '"+cardnumber+"' AND pin_number = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Credentials");
                }
            }
            catch(Exception e){
                System.out.println("Error = "+e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne(this);
        }
    }
    
    public static void main(String[] args){
        Login l = new Login();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
