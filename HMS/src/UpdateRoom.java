import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener
{
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
  UpdateRoom()
  {
	  JLabel l1=new JLabel("Update Room Status");
	  l1.setBounds(30,20,250,30);
	  l1.setForeground(new Color(123,50,250)); 
	  l1.setFont(new Font("Tahoma",Font.PLAIN,25));
	  add(l1);
	  JLabel id=new JLabel("Guest ID");
	  id.setBounds(30,80,120,20);
	  add(id);
	  JLabel room=new JLabel("Room Number");
	  room.setBounds(30,130,120,20);
	  add(room);
	  JLabel availability=new JLabel("Availability");
	  availability.setBounds(30,180,120,20);
	  add(availability);
	  JLabel status=new JLabel("Cleaning Status");
	  status.setBounds(30,230,120,20);
	  add(status);
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
	  t1.setBounds(200,130,150,25);
	  add(t1);
	  t2=new JTextField();
	  t2.setBounds(200,180,150,25);
	  add(t2);
	  t3=new JTextField();
	  t3.setBounds(200,230,150,25);
	  add(t3);
	  b1 = new JButton("Check");
      b1.setBackground(Color.white); 
	  b1.setForeground(Color.black);
	  b1.setBounds(130,300,120,30);
      b1.addActionListener(this);
	  add(b1);
	  b2 = new JButton("Update");
	  b2.setBackground(Color.white);
	  b2.setForeground(Color.black);
	  b2.setBounds(40,350,120,30);
	  b2.addActionListener(this);
	  add(b2);
	  b3 = new JButton("Back");
      b3.setBackground(Color.white); 
	  b3.setForeground(Color.black);
	  b3.setBounds(220,350,120,30);
      b3.addActionListener(this);
	  add(b3);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
	  Image i2= i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  JLabel l10 =new JLabel(i3);
	  l10.setBounds (400,10,500,400);
	  add(l10);
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setBounds(200,100,980,450);
	  setResizable(false);
	  setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
	  if(ae.getSource()==b1)
	  {
		  String room = null;
          String str = c1.getSelectedItem();
		  conn c = new conn();
		  try
		  {
			ResultSet rs =c.s.executeQuery("select * from customer where number ='"+str+"'");
			while(rs.next())
			{
				t1.setText(rs.getString("room"));
				room = rs.getString("room");
			}
			ResultSet rs1 =c.s.executeQuery("select * from room where room='"+room+"'");
			while (rs1.next())
			{
				t2.setText(rs1.getString("availability"));
				t3.setText(rs1.getString("cleaning_status"));
			}
		  }
		  catch(Exception e)
		  {
			 
		  }
	  }
	  else if (ae.getSource()==b2)
	  {
			try
			{
				String room = t1.getText();
				String availability = t2.getText();
				String status = t3.getText();
				conn c = new conn();
				String str2 ="update room set availability='"+availability+"',cleaning_status='"+status+"' where room='"+room+"'";
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "Room Updated Successfully");
				new Reception().setVisible(true);
				this.setVisible(false);
			}
			catch(Exception e)
			{
				
			}
	  }
	  else if (ae.getSource()==b3)
	  {
			new Reception().setVisible(true);
			this.setVisible(false);
	  }
  }
  public static void main (String args[])
  {
	  new UpdateRoom().setVisible(true);
  }
}

