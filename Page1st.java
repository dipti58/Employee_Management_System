
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Page1st extends JFrame implements ActionListener {

    Page1st(){

     getContentPane().setBackground(Color.WHITE);       //we can access the frame through getContentPane() & we set the color
     setLayout(null);                                   //disable layout manager otherwise we can't give our own setbounds

     JLabel heading=new JLabel("EMPLOYEE  MANAGMENT  SYSTEM");
     heading.setBounds(400,30,1200,60);                  //we give the position to our heading
     heading.setFont(new Font("serif", Font.PLAIN, 40));
     heading.setForeground(Color.BLUE);
     add(heading);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
     Image i2 = i1.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(50,100,1450,600);
     add(image);
     
     
     JButton clickme=new JButton("CLICK HERE");         //we add a button 
     clickme.setBounds(600,400,200,50);
     clickme.setBackground(Color.LIGHT_GRAY);
     clickme.setForeground(Color.DARK_GRAY);
     clickme.addActionListener(this);
     image.add(clickme);                                // we add button respect of image / we add button on image
     
     
     setSize(1270,950);                                // we set the frame size
     setLocation(200,50);                               //frame location
     setVisible(true);                                  //frame visibility
     
     while(true){                                     // if we want to dipper to our heading then we should go to this
         heading.setVisible(false);
         try{
             Thread.sleep(500);
         }catch(Exception e){
             
         }
         heading.setVisible(true);
         try{
             Thread.sleep(1000);
         }catch(Exception e){
             
         }
      }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();                    //it create a object then call the login constructer / and it call the login page
    }
    public static void main(String[] args) {
        new Page1st();
    }
}

