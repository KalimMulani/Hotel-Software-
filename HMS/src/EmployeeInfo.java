import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class EmployeeInfo extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1,b2;
	EmployeeInfo()
	{
		t1 = new JTable();
		t1.setBounds(0,40,1000,500);
		add(t1);
		b1 = new JButton("Load Data");
		b1.setBackground(Color.white); 
		b1.setForeground(Color.black);
		b1.setBounds(350,560,120,30);
		b1.addActionListener(this);
		add(b1);
		b2 = new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(530,560,120,30);
		b2.addActionListener(this);
		add(b2);
		JLabel name = new JLabel("NAME");
		  name.setBounds(40,10,70,20);
		  name.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(name);
		  JLabel age = new JLabel("AGE");
		  age.setBounds(170,10,70,20);
		  age.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(age);
		  JLabel gender = new JLabel("GENDER");
		  gender.setBounds(290,10,70,20);
		  gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(gender);
		  JLabel job = new JLabel("JOB");
		  job.setBounds(420,10,70,20);
		  job.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(job);
		  JLabel salary = new JLabel("SALARY");
		  salary.setBounds(540,10,70,20);
		  salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(salary);
		  JLabel phone = new JLabel("PHONE");
		  phone.setBounds(670,10,70,20);
		  phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(phone);
		  JLabel adhar = new JLabel("ADHAR");
		  adhar.setBounds(790,10,70,20);
		  adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(adhar);
		  JLabel email = new JLabel("EMAIL");
		  email.setBounds(910 ,10,70,20);
		  email.setFont(new Font("Tahoma",Font.PLAIN,17));
		  add(email);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,50,1000,650);
		setResizable(false);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try 
			{
				conn c =new conn();
				String str ="select * from employee";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e)
			{
				
			}
		}
		else if (ae.getSource()==b2)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main (String args []) 
	{
		new EmployeeInfo().setVisible(true);
	}
}
