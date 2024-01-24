import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRooms extends JFrame implements ActionListener
{
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
    SearchRooms()
    {
    	JLabel l1= new JLabel("Search Room");
    	l1.setFont(new Font("Tahoma" , Font.PLAIN , 20));
    	l1.setBounds(400,30,200,30);
    	add(l1);
    	JLabel l2= new JLabel("Room Bed Type");
    	l2.setBounds(50,100,100,20);
    	add(l2);
    	JLabel room = new JLabel("Room Number");
		room.setBounds(50,160,100,20);
		add(room);
		JLabel availability = new JLabel("Availability");
		availability.setBounds(270,160,100,20);
		add(availability);
		JLabel status = new JLabel("Cleaning Status");
		status.setBounds(450,160,120,20);
		add(status);
		JLabel price = new JLabel("Price");
		price.setBounds(670,160,80,20);
		add(price);
		JLabel type = new JLabel("Bed Type");
		type.setBounds(850,160,100,20);
		add(type);
    	c1 =new JComboBox (new String [] {"Single Bed","Double Bed"});
    	c1.setBounds(150,100,150,25);
    	c1.setBackground(Color.WHITE);
    	add(c1);
    	c2 =new JCheckBox ("Only Display Available");
    	c2.setBounds(650,100,150,25);
    	c2.setBackground(Color.WHITE);
    	add(c2);
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
    			String str1 ="select * from room where bed_type ='"+c1.getSelectedItem()+"'";
    			String str2 ="select * from room where availability ='Available'AND bed_type ='"+c1.getSelectedItem()+"'";
    			conn c = new conn ();
    			ResultSet rs = c.s.executeQuery(str1);
    			t1.setModel(DbUtils.resultSetToTableModel(rs));
    			if (c2.isSelected())
    			{
    				ResultSet rs2 = c.s.executeQuery(str2);
    				t1.setModel(DbUtils.resultSetToTableModel(rs2));
    			}
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
    public static void main(String args[])
    {
    	new SearchRooms().setVisible(true);
    }
    
}
