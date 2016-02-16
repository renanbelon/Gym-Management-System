import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Login extends JFrame implements ActionListener
{
JLabel loginl,passwordl;
JTextField loginT;
JPasswordField passwordT;
JButton loginb, cancelb;

Menu menu = new Menu();

Queries queries = new Queries();
StudentForm stdForm = new StudentForm();
ArrayList<Student> studentList = null;




public static void main(String args[])
{
new Login();
//test = new usertest1();
}



 //******************************* 
public Login(){
  super("Login Menu");
  setSize(400, 400);
  setLocationRelativeTo(null);
  setLayout(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  //creates labels
  loginl = new JLabel("Username:");
  loginl.setSize(62,25);
  loginl.setLocation(20,100);
  add(loginl);
  
  passwordl = new JLabel("Password:");
  passwordl.setSize(61,25);
  passwordl.setLocation(20,128);
  add(passwordl);
  
  //creates text field.
  loginT = new JTextField();
  loginT.setSize(140,25);
  loginT.setLocation(95,100);
  add(loginT);
 
  //creates password field.
  passwordT = new JPasswordField();
  passwordT.setSize(140,25);
  passwordT.setLocation(95,128);
  add(passwordT);
  
  //creates buttons.
  loginb = new JButton("Login");
  loginb.setSize(75,25);
  loginb.setLocation(20,156);
  loginb.addActionListener(this);
  add(loginb);
  
  cancelb = new JButton("Cancel");
  cancelb.setSize(75,25);
  cancelb.setLocation(98,156);
  cancelb.addActionListener(this);
  add(cancelb);
  
  setVisible(true);


}


//*************************************************8

public void actionPerformed(ActionEvent e){
    if (e.getSource()==cancelb){
        System.exit(0);
    }
    
    if (e.getSource()==loginb){
        String pass = new String(passwordT.getPassword());
        queries.checkLogin(loginT.getText(),pass);
    
        if (queries.checkLogin(loginT.getText(),pass)== true){
            menu.setVisible(true);
            menu.arangestudents();
             menu.arangeStaffs();
            loginT.setText("");
            passwordT.setText("");
            setVisible(false);
        }
    }
}

}
