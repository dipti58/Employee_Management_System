package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {

    JTextField tfusername, tfemail;
    JPasswordField tfpassword;
    JButton registerBtn, loginBtn;

    public Register() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Register New User");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(480, 10, 250, 30);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(400, 70, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(500, 70, 150, 30);
        add(tfusername);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(400, 120, 100, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(500, 120, 150, 30);
        add(tfemail);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(400, 170, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(500, 170, 150, 30);
        add(tfpassword);

        registerBtn = new JButton("REGISTER");
        registerBtn.setBounds(500, 230, 150, 30);
        registerBtn.addActionListener(this);
        add(registerBtn);

        loginBtn = new JButton("BACK TO LOGIN");
        loginBtn.setBounds(500, 280, 150, 30);
        loginBtn.addActionListener(e -> {
            setVisible(false);
            new Login();
        });
        add(loginBtn);
        
        ImageIcon rIcon = new ImageIcon(ClassLoader.getSystemResource("icons/register2.jpg"));
        Image rImage = rIcon.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBg = new ImageIcon(rImage);

        JLabel bg = new JLabel(scaledBg);
        bg.setBounds(100,0, 900, 600);
        add(bg);
                
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = tfusername.getText();
            String email = tfemail.getText();
            String password = new String(tfpassword.getPassword());

            Conn c = new Conn();

            String query = "INSERT INTO login(username, email, password) VALUES(?,?,?)";
            PreparedStatement ps = c.c.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();

            if(result > 0){
                JOptionPane.showMessageDialog(null, "Registration Successful!");
                setVisible(false);
                new Login();
            } else {
                JOptionPane.showMessageDialog(null, "Error! Try Again.");
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}


