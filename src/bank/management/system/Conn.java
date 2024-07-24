/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //1.Register The Driver
//            Class.forName("com.mysql.cj.jdbc.Driver"); //no need after adding sql connector library
            
            //2.Create Connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Nikhil@1119");
            
            //3.Create Statement
            s = c.createStatement();
            
            
        }
        catch(Exception e){
            System.out.println("Error  = "+e);
        }
    }
}
