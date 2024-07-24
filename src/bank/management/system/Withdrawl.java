
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Withdrawl extends JFrame implements ActionListener{

    JButton withdrawbtn,backbtn;
    JTextField amountTF;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,310,400,20);
        image.add(text);
        
        amountTF = new JTextField();
        amountTF.setFont(new Font("Raleway",Font.BOLD,22));
        amountTF.setBounds(170,350,320,25);
        image.add(amountTF);
        
        withdrawbtn = new JButton("Withdrawl");
        withdrawbtn.setBounds(362,522,150,38);
        withdrawbtn.addActionListener(this);
        image.add(withdrawbtn);
        
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
        if(ae.getSource()==withdrawbtn){
            String amount = amountTF.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an amount");
            }
            else{
                Conn conn = new Conn();
                String query = "INSERT INTO BANK VALUES('"+pinnumber+"', '"+date+"','Withdrawl','"+amount+"')";
                try {
                    ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    conn.s.executeUpdate(query);
                    int curbal = balance - Integer.parseInt(amount);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdraw Successfully");
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
        new Withdrawl("");
    }
}
