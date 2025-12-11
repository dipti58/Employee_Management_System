package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername;
    JPasswordField tfpassword;  //it declar global scope
    JButton registerBtn;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(400,20,100,30);
        add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(500,20,150,30);
        add(tfusername);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(400,70,100,30);
        add(lblpassword);
        
        tfpassword=new JPasswordField();
        tfpassword.setBounds(500,70,150,30);
        add(tfpassword);
        
        JButton login=new JButton("LOGIN");         
        login.setBounds(500,140,150,30);
        login.setBackground(Color.LIGHT_GRAY);
        login.setForeground(Color.DARK_GRAY);
        login.addActionListener(this);
        add(login);       
        
        registerBtn = new JButton("REGISTER");
        registerBtn.setBounds(500, 200, 150, 30);
        registerBtn.setBackground(Color.LIGHT_GRAY);
        registerBtn.setForeground(Color.DARK_GRAY);

        registerBtn.addActionListener(e -> {
            setVisible(false);
            new Register();   // Open Register Page
        });

        add(registerBtn);
     
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBg = new ImageIcon(bgImage);

        JLabel bg = new JLabel(scaledBg);
        bg.setBounds(100, 0, 900, 600);
        add(bg);
   
      setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    
        }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            
            String username=tfusername.getText();
            String password=new String(tfpassword.getPassword());
            
            
            Conn c=new Conn();
            String query ="select * from login where username='"+username+"' and password='"+password+"'";
                    
            ResultSet rs=c.s.executeQuery(query);    
            if(rs.next()){
                setVisible(false);
                new Home();                       //we create home class object because when if block will be true that time home page wil be open
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login();
    }
    
}