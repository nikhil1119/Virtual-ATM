/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton savingaccrbtn,fdaccrbtn,currentaccrbtn,rdaccrbtn;
    JCheckBox atmchk, ibchk, mbchk, emailandsmschk, chequebookchk, estatementchk, declarechk;
    JButton submitbtn, cancelbtn;
    String formno,cardnumber,pinnumber;
    Random random;
    
    
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        //heading
        JLabel headingLbl = new JLabel("Page 3: Account Details");
        headingLbl.setFont(new Font("Raleway",Font.BOLD,22));
        headingLbl.setBounds(280,40,400,40);
        add(headingLbl);
        
        
        //Account Type
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        savingaccrbtn = new JRadioButton("Saving Account");
        savingaccrbtn.setFont(new Font("Raleway", Font.BOLD,16));
        savingaccrbtn.setBounds(100,180,180,20);
        add(savingaccrbtn);
        
        fdaccrbtn = new JRadioButton("Fixed Deposit Account");
        fdaccrbtn.setFont(new Font("Raleway", Font.BOLD,16));
        fdaccrbtn.setBounds(350,180,250,20);
        add(fdaccrbtn);
        
        currentaccrbtn = new JRadioButton("Current Account");
        currentaccrbtn.setFont(new Font("Raleway", Font.BOLD,16));
        currentaccrbtn.setBounds(100,220,180,20);
        add(currentaccrbtn);
        
        rdaccrbtn = new JRadioButton("Recurring Deposit Account");
        rdaccrbtn.setFont(new Font("Raleway", Font.BOLD,16));
        rdaccrbtn.setBounds(350,220,260,20);
        add(rdaccrbtn);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savingaccrbtn);
        accountGroup.add(fdaccrbtn);
        accountGroup.add(currentaccrbtn);
        accountGroup.add(rdaccrbtn);
        
        
        //Card Number
        random = new Random();
        cardnumber = ""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        JLabel cardlbl = new JLabel("Card Number:");
        cardlbl.setFont(new Font("Raleway",Font.BOLD,22));
        cardlbl.setBounds(100,300,200,30);
        add(cardlbl);
        
        JLabel cardnumberlbl = new JLabel("XXXX-XXXX-XXXX-"+cardnumber.substring(cardnumber.length()-4));//DUMMY
        cardnumberlbl.setFont(new Font("Raleway",Font.BOLD,22));
        cardnumberlbl.setBounds(330,300,300,30);
        add(cardnumberlbl);
        
        JLabel cardinfolbl = new JLabel("Your 16 digit card Number");//DUMMY
        cardinfolbl.setFont(new Font("Raleway",Font.BOLD,12));
        cardinfolbl.setBounds(100,330,300,20);
        add(cardinfolbl);
        
        //Pin Number
        JLabel pinlbl = new JLabel("PIN:");
        pinlbl.setFont(new Font("Raleway",Font.BOLD,22));
        pinlbl.setBounds(100,370,200,30);
        add(pinlbl);
        
        pinnumber = ""+Math.abs((random.nextLong() % 9000L) + 1000L);
        JLabel pinnumberlbl = new JLabel("XXXX");//DUMMY
        pinnumberlbl.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumberlbl.setBounds(330,370,300,30);
        add(pinnumberlbl);
        
        JLabel pininfolbl = new JLabel("Your 4 digit PIN");//DUMMY
        pininfolbl.setFont(new Font("Raleway",Font.BOLD,12));
        pininfolbl.setBounds(100,400,300,20);
        add(pininfolbl);
        
        
        //Services
        JLabel sreviceslbl = new JLabel("Services Required:");
        sreviceslbl.setFont(new Font("Raleway",Font.BOLD,22));
        sreviceslbl.setBounds(100,450,250,30);
        add(sreviceslbl);
        
        atmchk = new JCheckBox("ATM CARD");
        atmchk.setFont(new Font("Raleway",Font.BOLD,16));
        atmchk.setBounds(100,500,200,30);
        add(atmchk);
        
        ibchk = new JCheckBox("Internet Banking");
        ibchk.setFont(new Font("Raleway",Font.BOLD,16));
        ibchk.setBounds(350,500,200,30);
        add(ibchk);
        
        mbchk = new JCheckBox("Mobile Banking");
        mbchk.setFont(new Font("Raleway",Font.BOLD,16));
        mbchk.setBounds(100,550,200,30);
        add(mbchk);
        
        emailandsmschk = new JCheckBox("Email & SMS Alerts");
        emailandsmschk.setFont(new Font("Raleway",Font.BOLD,16));
        emailandsmschk.setBounds(350,550,200,30);
        add(emailandsmschk);
        
        chequebookchk = new JCheckBox("Cheque Book");
        chequebookchk.setFont(new Font("Raleway",Font.BOLD,16));
        chequebookchk.setBounds(100,600,200,30);
        add(chequebookchk);
        
        estatementchk = new JCheckBox("E Statement");
        estatementchk.setFont(new Font("Raleway",Font.BOLD,16));
        estatementchk.setBounds(350,600,200,30);
        add(estatementchk);
        
        declarechk = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        declarechk.setFont(new Font("Raleway",Font.BOLD,12));
        declarechk.setBounds(100,680,600,30);
        add(declarechk);
        
        
        //Buttons
        submitbtn = new JButton("Submit");
        submitbtn.setFont(new Font("Raleway",Font.BOLD,14));
        submitbtn.setBounds(400,720,100,40);
        submitbtn.addActionListener(this);
        add(submitbtn);
        
        cancelbtn = new JButton("Cancel");
        cancelbtn.setFont(new Font("Raleway",Font.BOLD,14));
        cancelbtn.setBounds(270,720,100,40);
        cancelbtn.addActionListener(this);
        add(cancelbtn);
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submitbtn){
            String accountType = "";
            if(savingaccrbtn.isSelected()){
                accountType = "Saving Account";
            }
            else if(fdaccrbtn.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(currentaccrbtn.isSelected()){
                accountType = "Current Account";
            }
            else if(rdaccrbtn.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            //cardnumber and random are in Card Number section => line no. 70,71
            //pinnumber is in Pin Number section => line no. 93
            
            String facility = "";
            if(atmchk.isSelected()){
                facility = facility + " ATM CARD";
            } 
            if(ibchk.isSelected()){
                facility = facility + " Internet Banking";
            }
            if(mbchk.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(emailandsmschk.isSelected()){
                facility = facility + " Email and SMS Alert";
            }
            if(chequebookchk.isSelected()){
                facility = facility + " Cheque Book";
            }
            if(estatementchk.isSelected()){
                facility = facility + " E Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                else{
                    Conn c = new Conn();
                    if(declarechk.isSelected()==true){
                        String query1 = "INSERT INTO signupthree VALUES('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                        String query2 = "INSERT INTO login VALUES('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, "Details uploaded successfully"+"\nCard no : "+cardnumber+"\nPin : "+pinnumber);
                        
                        setVisible(false);
                        new Deposit(pinnumber);
                    }
                    else if(declarechk.isSelected()==false){
                        JOptionPane.showMessageDialog(null, "Please Check the Declaration Box");
                    }
                    else{
                        setVisible(false);
                        new Login();
                    }
                }
            }
            catch(Exception e){
                System.out.println("Error : "+e);
            }
            
            
        }
        else if(ae.getSource()==cancelbtn){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]) {
        // TODO code application logic here
        new SignupThree("");
        
    }
}
