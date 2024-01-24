import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener 
{ 
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	Login()
	{
		l1=new JLabel("Username");
		l1.setBounds(40,20,100,30);
		add(l1);
		l2=new JLabel("Password");
		l2.setBounds(40,70,100,30);
		add(l2);
		t1=new JTextField();
		t1.setBounds(150,20,150,30);
		add(t1);
		t2=new JPasswordField();
		t2.setBounds(150,70,150,30);
		add(t2);
		b1=new JButton("Login");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(40,150,120,30);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(180,150,120,30);
		add(b2);
		b2.addActionListener(this);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		JLabel l3=new JLabel (i1);
		l3.setBounds(300,10,300,300);
		add(l3);
		setLayout(null);
		setBounds(300,100,600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1) 
		{
			String Username = t1.getText();
			String Password = t2.getText();
			conn c = new conn();
			String str = "select * from login where username ='"+Username+"'and password ='"+Password+"'";
			try
			{
			 ResultSet rs = c.s.executeQuery(str);
			 if(rs.next())
			 {
				 new Dashboard().setVisible(true);
				 this.setVisible(false);
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null, "Invalid Username and Password");
				 this.setVisible(false);
			 }
			}
			catch(Exception e)
			{
				
			}
			
		}
		else if(ae.getSource()==b2)
		{
			System.exit(0);
		}
		
		
	}
	public static void main (String args[])
	{
	new Login();
	}
}
