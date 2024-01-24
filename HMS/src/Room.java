import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.*;
public class Room extends JFrame implements ActionListener
{
  JTable t1;
  JButton b1,b2;
  Room()
  {     
	    t1 = new JTable();
		t1.setBounds(0,40,500,400);
		add(t1);
	    b1 = new JButton("Load Data");
		b1.setBackground(Color.white); 
		b1.setForeground(Color.black);
		b1.setBounds(100,460,120,30);
		b1.addActionListener(this);
		add(b1);
		b2 = new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(250,460,120,30);
		b2.addActionListener(this);
		add(b2);
		JLabel room = new JLabel("Room Number");
		room.setBounds(10,10,100,20);
		add(room);
		JLabel availability = new JLabel("Availability");
		availability.setBounds(120,10,100,20);
		add(availability);
		JLabel status = new JLabel("Cleaning Status");
		status.setBounds(205,10,120,20);
		add(status);
		JLabel price = new JLabel("Price");
		price.setBounds(330,10,80,20);
		add(price);
		JLabel type = new JLabel("Bed Type");
		type.setBounds(410,10,100,20);
		add(type);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eighth.jpg"));
		Image i2= i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 =new JLabel(i3);
		l6.setBounds (500,0,500,600);
		add(l6);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,50,1020,600);
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
				String str ="select * from room";
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
		new Room().setVisible(true);
	}
}


