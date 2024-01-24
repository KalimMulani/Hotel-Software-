import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class PickUp extends JFrame implements ActionListener
{
	Choice c1;
	JButton b1,b2;
	JTable t1;
    PickUp()
    {
    	JLabel l1= new JLabel("Search Driver");
    	l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
    	l1.setBounds(400,30,200,30);
    	add(l1);
    	JLabel l2= new JLabel("Type Of Car");
    	l2.setBounds(50,100,100,20);
    	add(l2);
    	JLabel name = new JLabel("Name");
		name.setBounds(60,160,120,30);
		add(name);
		JLabel age = new JLabel("Age");
		age.setBounds(200,160,120,30);
		add(age);
		JLabel gender = new JLabel("Gender");
		gender.setBounds(330,160,120,30);
		add(gender);
		JLabel company = new JLabel("Car Company");
		company.setBounds(460,160,120,30);
		add(company);
		JLabel model = new JLabel("Car Model");
		model.setBounds(610,160,120,30);
		add(model);
		JLabel availability = new JLabel("Availability");
		availability.setBounds(750,160,120,30);
		add(availability);
		JLabel location = new JLabel("Location");
		location.setBounds(880,160,120,30);
		add(location);
    	c1 =new Choice ();
    	try 
    	{
    	 conn c =new conn();
    	 ResultSet rs= c.s.executeQuery("select *from driver");
    	 while(rs.next())
    	 {
    		 c1.add(rs.getString("car_model"));
    	 }
    	}
    	catch(Exception e)
    	{
    		
    	}
    	c1.setBounds(150,100,200,25);
    	c1.setBackground(Color.WHITE);
    	add(c1);
    	t1= new JTable ();
    	t1.setBounds(0,200,1000,300);
    	t1.setBackground(Color.WHITE);
    	add(t1);
    	b1 = new JButton("Submit");
		b1.setBackground(Color.white); 
		b1.setForeground(Color.black);
		b1.setBounds(300,520,120,30);
		b1.addActionListener(this);
		add(b1);
		b2 = new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(500,520,120,30);
		b2.addActionListener(this);
		add(b2);
		getContentPane().setBackground(Color.white);
    	setLayout(null);
		setBounds(200,50,1000,650);
		setResizable(false);
		setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if (ae.getSource()==b1)
    	{
    		try
    		{
    			String str1 ="select * from driver where car_model ='"+c1.getSelectedItem()+"'";
    			conn c = new conn ();
    			ResultSet rs = c.s.executeQuery(str1);
    			t1.setModel(DbUtils.resultSetToTableModel(rs));
    		}
    		catch (Exception e) 
    		{
    			
    		}
    	}
    	    else if (ae.getSource()==b2)
		   {
			new Reception().setVisible(true);
			this.setVisible(false);
	       }
    }
    public static void main(String args[])
    {
    	new PickUp().setVisible(true);
    }
    
}
