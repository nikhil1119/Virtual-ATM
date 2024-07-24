/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,310,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN :");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,350,180,25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,350,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter NEW PIN :");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,390,180,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,390,180,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(362,522,150,38);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(365,559,150,38);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "PIN is required");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Pin is required");
                    return;
                }
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "UPDATE bank SET pin = '"+rpin+"' WHERE pin = '"+pinnumber+"'";
                String query2 = "UPDATE login SET pin_number = '"+npin+"' WHERE pin_number = '"+pinnumber+"'";
                String query3 = "UPDATE signupThree SET pin_number = '"+npin+"' WHERE pin_number = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin);
            }
            catch(Exception e){
                System.out.println("Error = "+e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber);
        }     
    }
    
    public static void main(String args[]) {
        new PinChange("");
    }
}
