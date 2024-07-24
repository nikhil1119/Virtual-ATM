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

public class SignupTwo extends JFrame implements ActionListener{
    
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JTextField panTF, adharTF;
    JComboBox religion,category,occupation,education, income;
    String formno="0";
    
    SignupTwo(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        //Religion 
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Christian","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        //category
                
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        //Income
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000",">5,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
        //education
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
           
        //qualification
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationvalues[] = {"Non-Graduate","Graduate","Post-Graduation","Doctorate","Other"};
        education = new JComboBox(educationvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
        
        //Occupation
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD, 20));
        marital.setBounds(100,380,200,30);
        add(marital);
        
        String occupationvalues[] = {"Salaried","Self-Employeed","Business","Student","Retired","Other"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300,380,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        //PAN Number 
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD, 20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTF = new JTextField();
        panTF.setFont(new Font("Raleway",Font.BOLD,14));
        panTF.setBounds(300,440,400,30);
        add(panTF);
        
        //Adhar Number
        JLabel adhar = new JLabel("Adhar Number:");
        adhar.setFont(new Font("Raleway",Font.BOLD, 20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        
        adharTF = new JTextField();
        adharTF.setFont(new Font("Raleway",Font.BOLD,14));
        adharTF.setBounds(300,490,400,30);
        add(adharTF);
        
        //Senior Citizne
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        add(sno);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
        
        //Exising Account
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        add(eyes);
        eno = new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        add(eno);
        
        ButtonGroup pincodeGroup = new ButtonGroup();
        pincodeGroup.add(eyes);
        pincodeGroup.add(eno);
        
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
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }
        else if(eno.isSelected()){
            existingaccount = "No";
        }
        String span = panTF.getText();
        String sadhar = adharTF.getText();
        
        try{        
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                //4.execute statement
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details uploaded successfully");
                
                setVisible(false);
                new SignupThree(formno);
        }
        catch(Exception e){
            System.out.println("Error = "+e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}
