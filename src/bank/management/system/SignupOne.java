/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTF, fnameTF, emailTF, addressTF, cityTF, stateTF, pincodeTF;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    SignupOne(Login l){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
//        System.out.println(random);

        //form no
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD, 38));
        formno.setBounds(140,20,650,40);
        add(formno);
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD, 20));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);
        
        //name 
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,14));
        nameTF.setBounds(300,140,400,30);
        add(nameTF);
        
        //father name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTF.setBounds(300,190,400,30);
        add(fnameTF);
        
        //DOB
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(340,240,400,30);
        add(dateChooser);
        
        //gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        //email
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway",Font.BOLD,14));
        emailTF.setBounds(300,340,400,30);
        add(emailTF);
        
        //marital status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        //address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTF = new JTextField();
        addressTF.setFont(new Font("Raleway",Font.BOLD,14));
        addressTF.setBounds(300,440,400,30);
        add(addressTF);
        
        //city
        JLabel city = new JLabel("city:");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,14));
        cityTF.setBounds(300,490,400,30);
        add(cityTF);
        
        //state
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway",Font.BOLD,14));
        stateTF.setBounds(300,540,400,30);
        add(stateTF);
        
        //pincode
        JLabel pincode = new JLabel("pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodeTF = new JTextField();
        pincodeTF.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTF.setBounds(300,590,400,30);
        add(pincodeTF);
        
        //next button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,50);
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                l.setVisible(true);
//                Login l = new Login();
//                l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }});
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTF.getText();
        String fname = fnameTF.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTF.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        String address = addressTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pincode = pincodeTF.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's name is Required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "DOB is Required");
            }
            else if(gender == null){
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is Required");
            }
            else if(marital == null){
                JOptionPane.showMessageDialog(null, "Marital Status is Required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required");
            }
            else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            }
            else{
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pincode+"', '"+state+"')";
                //4.execute statement
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details uploaded successfully");
                
                setVisible(false);
                new SignupTwo(formno);
            }
        }
        catch(Exception e){
            System.out.println("Error = "+e);
        }
        
        
    }
    
    

//    public static void main(String args[]) {
////        new SignupOne();
//    }
}
