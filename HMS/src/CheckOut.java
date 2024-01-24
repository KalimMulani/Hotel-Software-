import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener
{
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
  CheckOut()
  {
	  JLabel l1 = new JLabel("Check Out");
	  l1.setForeground(new Color(123,50,250)); 
	  l1.setFont(new Font("Tahoma",Font.PLAIN,20));
	  l1.setBounds(100,20,100,30);
	  add(l1);
	  JLabel l2 = new JLabel("Customer ID");
	  l2.setBounds(30,80,100,30);
	  add(l2);
	  JLabel l3 = new JLabel("Room Number");
	  l3.setBounds(30,130,100,20);
	  add(l3);
	  t1=new JTextField();
	  t1.setBounds(150,130,150,30);
	  add(t1);
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
	  c1.setBounds(150,80,150,30);
	  add(c1);
	  b1 = new JButton("Check Out");
      b1.setBackground(Color.white); 
	  b1.setForeground(Color.black);
	  b1.setBounds(30,200,120,30);
      b1.addActionListener(this);
	  add(b1);
	  b2 = new JButton("Back");
	  b2.setBackground(Color.white);
	  b2.setForeground(Color.black);
	  b2.setBounds(170,200,120,30);
	  b2.addActionListener(this);
	  add(b2);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelveth.png"));
	  Image i2= i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  b3 =new JButton(i3);
	  b3.setBounds (310,80,20,20);
	  b3.addActionListener(this);
	  add(b3);
	  ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/thirteenth.jpg"));
	  Image i5= i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
	  ImageIcon i6 = new ImageIcon(i5);
	  JLabel l4 =new JLabel(i6);
	  l4.setBounds (350,0,400,250);
	  add(l4);
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setBounds(200,100,800,300);
	  setResizable(false);
	  setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
	  if(ae.getSource()==b1)
	  {
		  String id = c1.getSelectedItem();
		  String room =t1.getText();
		  String str ="delete from customer where number='"+id+"'";
		  String str1 ="update room set availability='Available' where room='"+room+"'";
		  conn c = new conn ();
		  try 
		  {
			  c.s.executeUpdate(str);
			  c.s.executeUpdate(str1);
			  JOptionPane.showMessageDialog(null, "Check-Out Done");
			  new Reception().setVisible(true);
			  this.setVisible(false);
		  }
		  catch (Exception e)
		  {
			  System.out.println(e);
		  }
	  }
		  else if (ae.getSource()==b2)
		  {
				new Reception().setVisible(true);
				this.setVisible(false);
		  }
		  else if (ae.getSource()==b3)
		  {
			  conn c = new conn ();
			  String id = c1.getSelectedItem();
			  try
			  {
			  ResultSet rs =c.s.executeQuery("select * from customer where number='"+id+"'");
			  while (rs.next())
			  {
				  t1.setText(rs.getString("room"));
			  }
			  }
			  catch (Exception e)
			  {
				  
			  }
		  }
 }
  
  public static void main(String args[])
  {
	  new  CheckOut().setVisible(true);
  }
}
