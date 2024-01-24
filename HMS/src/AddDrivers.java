import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddDrivers extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	JButton b1,b2;
	AddDrivers()
	  {
		JLabel l1 =new JLabel ("Add Drivers");
		l1.setBounds(150,10,150,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,18));
		add(l1);
		JLabel name = new JLabel("Name");
		name.setBounds(60,70,120,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(name);
		JLabel age = new JLabel("Age");
		age.setBounds(60,110,120,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(age);
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60,150,120,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(gender);
		JLabel company = new JLabel("Car Company");
		company.setBounds(60,190,120,30);
		company.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(company);
		JLabel model = new JLabel("Car Model");
		model.setBounds(60,230,120,30);
		model.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(model);
		JLabel availability = new JLabel("Availability");
		availability.setBounds(60,270,120,30);
		availability.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(availability);
		JLabel location = new JLabel("Location");
		location.setBounds(60,310,120,30);
		location.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(location);
		t1 = new JTextField ();
		t1.setBounds(200,70,150,30);
		add(t1);
		t2 = new JTextField ();
		t2.setBounds(200,110,150,30);
		add(t2);
		t3 = new JTextField ();
		t3.setBounds(200,190,150,30);
		add(t3);
		t4 = new JTextField ();
		t4.setBounds(200,230,150,30);
		add(t4);
		t5 = new JTextField ();
		t5.setBounds(200,310,150,30);
		add(t5);
		c1 = new JComboBox(new String[] {"Male","Female"});
		c1.setBounds(200,150,150,30);
		c1.setBackground(Color.white);
		add(c1);
		c2 = new JComboBox(new String[] {"Available","Busy"});
		c2.setBounds(200,270,150,30);
		c2.setBackground(Color.white);
		add(c2);
		b1 = new JButton("Add Driver");
		b1.setBackground(Color.white); 
		b1.setForeground(Color.black);
		b1.setBounds(60,370,130,30);
		b1.addActionListener(this);
		add(b1);
		b2 = new JButton("Cancel");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(210,370,130,30);
		b2.addActionListener(this);
		add(b2);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i2= i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l9 =new JLabel(i3);
		l9.setBounds (400,80,500,300);
		add(l9);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,100,980,470);
		setResizable(false);
		setVisible(true);
	  }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String name = t1.getText();
			String age = t2.getText();
			String gender =(String)c1.getSelectedItem();
			String company = t3.getText();
			String model = t4.getText();
			String availability =(String)c2.getSelectedItem();
			String  location = t5.getText();
			conn c = new conn();
		    try 
		    {
		    	String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+availability+"','"+location+"')";
		    	c.s.executeUpdate(str) ;
				JOptionPane.showMessageDialog(null, "New Driver Added");
				this.setVisible(false);
		    }
		    catch (Exception e)
		    {
		    	
		    }
		}
		else if (ae.getSource()==b2)
		{
			this.setVisible(false);
		}
			
	}
	
       public static void main (String args[])
       {
	     new AddDrivers().setVisible(true);
       }
}
