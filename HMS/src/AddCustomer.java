import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	Choice c2;
	JComboBox c1;
	JButton b1,b2;
	JRadioButton r1,r2;
  AddCustomer()
  {
	  JLabel l1 = new JLabel("New Customer Form");
	  l1.setBounds(100,20,300,30);
	  l1.setForeground(new Color(123,50,250));
	  l1.setFont(new Font("Tahoma",Font.PLAIN,20));
	  add(l1);
	  JLabel id = new JLabel("ID");
	  id.setBounds(35,80,100,20);
	  add(id);
	  JLabel number = new JLabel("Number");
	  number.setBounds(35,120,100,20);
	  add(number);
	  JLabel name = new JLabel("Name");
	  name.setBounds(35,160,100,20);
	  add(name);
	  JLabel gender = new JLabel("Gender");
	  gender.setBounds(35,200,100,20);
	  add(gender);
	  JLabel country = new JLabel("Country");
	  country.setBounds(35,240,100,20);
	  add(country);
	  JLabel room = new JLabel("Allocated Room Number");
	  room.setBounds(35,280,150,20);
	  add(room);
	  JLabel status = new JLabel("Checked In");
	  status.setBounds(35,320,100,20);
	  add(status);
	  JLabel deposit = new JLabel("Deposit");
	  deposit.setBounds(35,360,100,20);
	  add(deposit);
	  t1 = new JTextField ();
	  t1.setBounds(200,120,150,25);
	  add(t1);
	  t2 = new JTextField ();
	  t2.setBounds(200,160,150,25);
	  add(t2);
	  t3 = new JTextField ();
	  t3.setBounds(200,240,150,25);
	  add(t3); 
	  t4 = new JTextField ();
	  t4.setBounds(200,320,150,25);
	  add(t4);
	  t5 = new JTextField ();
	  t5.setBounds(200,360,150,25);
	  add(t5);
	  c1 = new JComboBox(new String []  {"Passport","Adhar Card","Voter ID Card","Driving License"});
	  c1.setBounds(200,80,150,25);
	  c1.setBackground(Color.white);
	  add(c1);
	  r1 = new JRadioButton("Male");
	  r1.setBounds(200,200,60,25);
	  r1.setFont(new Font("Tahoma",Font.PLAIN,14));
	  r1.setBackground(Color.white);
	  add(r1);
	  r2 = new JRadioButton("Female");
	  r2.setBounds(270,200,80,25);
	  r2.setFont(new Font("Tahoma",Font.PLAIN,14));
	  r2.setBackground(Color.white);
	  add(r2);
	  c2 = new Choice();
	  try 
	  {
		  conn c = new conn();
		  String str ="select * from room";
		  ResultSet rs =c.s.executeQuery(str);
		  while(rs.next())
		  {
			  c2.add(rs.getString("room"));
		  }
	  }
	  catch (Exception e)
	  {
		  
	  }
	  c2.setBounds(200,280,150,25);
	  add(c2);
	  b1 = new JButton("Add Customer");
      b1.setBackground(Color.white); 
	  b1.setForeground(Color.black);
	  b1.setBounds(50,410,120,25);
      b1.addActionListener(this);
	  add(b1);
	  b2 = new JButton("Cancel");
	  b2.setBackground(Color.white);
	  b2.setForeground(Color.black);
	  b2.setBounds(190,410,120,25);
	  b2.addActionListener(this);
	  add(b2);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ninth.png"));
	  Image i2= i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  JLabel l10 =new JLabel(i3);
	  l10.setBounds (400,50,300,400);
	  add(l10);
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setBounds(200,100,800,550);
	  setResizable(false);
	  setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==b1)
	  {
	    String id = (String)c1.getSelectedItem();
		String number =t1.getText();
		String name =t2.getText();
		String gender = null;
		if (r1.isSelected())
		  {
			  gender = "male";
	      }
		  else if(r2.isSelected())
		  {
			  gender = "female";
		  }
		String country =t3.getText();
		String room = c2.getSelectedItem();
		String status =t4.getText();
		String deposit =t5.getText();
		String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
		String str2="update room set availability='Occupied' where room ='"+room+"'";
		try
		{
			conn c = new  conn();
			c.s.executeUpdate(str) ;
			c.s.executeUpdate(str2);
			JOptionPane.showMessageDialog(null, "New Customer Added");
			new Reception().setVisible(true);
			this.setVisible(false);
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

  public static void main (String args[])
  {
	  new AddCustomer().setVisible(true);
  }
}
