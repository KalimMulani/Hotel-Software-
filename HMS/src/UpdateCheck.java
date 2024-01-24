import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
  UpdateCheck()
  {
	  JLabel l1=new JLabel("Check-In Details");
	  l1.setBounds(50,30,300,30);
	  l1.setForeground(new Color(123,50,250)); 
	  l1.setFont(new Font("Tahoma",Font.PLAIN,20));
	  add(l1); 
	  JLabel id = new JLabel("Customer ID");
	  id.setBounds(30,80,100,20);
	  add(id);
	  JLabel room = new JLabel("Room Number");
	  room.setBounds(30,120,100,20);
	  add(room);
	  JLabel availability = new JLabel("Name");
	  availability.setBounds(30,160,100,20);
	  add(availability);
	  JLabel status = new JLabel("Check-In Status");
	  status.setBounds(30,200,100,20);
	  add(status);
	  JLabel paid = new JLabel("Amount Paid");
	  paid.setBounds(30,240,100,20);
	  add(paid);
	  JLabel pending = new JLabel("Amount Pending");
	  pending.setBounds(30,280,100,20);
	  add(pending);
	  c1 = new Choice();
	  try 
	  {
		  conn c = new conn();
		  String str ="select * from customer";
		  ResultSet rs =c.s.executeQuery(str);
		  while(rs.next())
		  {
			  c1.add(rs.getString("number"));
		  }
	  }
	  catch (Exception e)
	  {
		  
	  }
	  c1.setBounds(200,80,150,25);
	  add(c1);
	  t1=new JTextField();
	  t1.setBounds(200,120,150,25);
	  add(t1);
	  t2=new JTextField();
	  t2.setBounds(200,160,150,25);
	  add(t2);
	  t3=new JTextField();
	  t3.setBounds(200,200,150,25);
	  add(t3);
	  t4=new JTextField();
	  t4.setBounds(200,240,150,25);
	  add(t4);
	  t5=new JTextField();
	  t5.setBounds(200,280,150,25);
	  add(t5);
	  b1 = new JButton("Check");
      b1.setBackground(Color.white); 
	  b1.setForeground(Color.black);
	  b1.setBounds(30,340,100,30);
      b1.addActionListener(this);
	  add(b1);
	  b2 = new JButton("Update");
	  b2.setBackground(Color.white);
	  b2.setForeground(Color.black);
	  b2.setBounds(150,340,100,30);
	  b2.addActionListener(this);
	  add(b2);
	  b3 = new JButton("Back");
      b3.setBackground(Color.white); 
	  b3.setForeground(Color.black);
	  b3.setBounds(270,340,100,30);
      b3.addActionListener(this);
	  add(b3);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleventh.jpg"));
	  JLabel l6 =new JLabel(i1);
	  l6.setBounds (400,50,500,300);
	  add(l6);
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setBounds(200,100,980,500);
	  setResizable(false);
	  setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
	  if(ae.getSource()==b1)
	  {
		  conn c = new conn();
		  String id = c1.getSelectedItem();
		  String str="select * from customer where number='"+id+"'";
		  try
		  {
			String room = null; 
			String deposit = null;
			String price = null;
			int amountPaid;
			ResultSet rs =c.s.executeQuery(str);
			while(rs.next())
			{
				t1.setText(rs.getString("room"));
				t2.setText(rs.getString("name"));
				t3.setText(rs.getString("check_in_status"));
				t4.setText(rs.getString("deposit"));
				room = rs.getString("room");
				deposit = rs.getString("deposit");
			}
			ResultSet rs1 =c.s.executeQuery("select * from room where room='"+room+"'");
			while (rs1.next())
			{
				price = rs1.getString("price");
				amountPaid = Integer.parseInt(price)-Integer.parseInt(deposit);
				t5.setText(Integer.toString(amountPaid));
			}
		  }
		  catch(Exception e)
		  {
			 System.out.println(e);
		  }
	  }
	  else if (ae.getSource()==b2)
	  {
		  
	  }
	  else if (ae.getSource()==b3)
	  {
			new Reception().setVisible(true);
			this.setVisible(false);
	  }
  }
  public static void main (String args[])
  {
	  new UpdateCheck().setVisible(true);
  }
}
