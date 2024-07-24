
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Deposit extends JFrame implements ActionListener{

    JButton depositbtn,backbtn;
    JTextField amountTF;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,310,400,20);
        image.add(text);
        
        amountTF = new JTextField();
        amountTF.setFont(new Font("Raleway",Font.BOLD,22));
        amountTF.setBounds(170,350,320,25);
        image.add(amountTF);
        
        depositbtn = new JButton("Deposit");
        depositbtn.setBounds(362,522,150,38);
        depositbtn.addActionListener(this);
        image.add(depositbtn);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(362,559,150,38);
        backbtn.addActionListener(this);
        image.add(backbtn);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==depositbtn){
            String amount = amountTF.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an amount");
            }
            else{
                Conn conn = new Conn();
                String query = "INSERT INTO BANK VALUES('"+pinnumber+"', '"+date+"','Deposit','"+amount+"')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (SQLException ex) {
                    Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(ae.getSource()==backbtn){
            setVisible(false);
            new Transactions(pinnumber);
            
        }
    }
    
    public static void main(String args[]) {
        // TODO code application logic here
        new Deposit("");
    }
}
