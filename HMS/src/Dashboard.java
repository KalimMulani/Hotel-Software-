import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
  Dashboard()
  {
	  mb = new JMenuBar();
	  add(mb);
	  m1 = new JMenu("Hotel Management");
	  m1.setForeground(Color.red);
	  mb.add(m1);
	  m2 = new JMenu("Admin");
	  m2.setForeground(Color.blue);
	  mb.add(m2);
	  i1 = new JMenuItem("Reception");
	  i1.addActionListener(this);
	  m1.add(i1);
	  i2 = new JMenuItem("Add Employee");
	  i2.addActionListener(this);
	  m2.add(i2);
	  i3 = new JMenuItem("Add Rooms");
	  i3.addActionListener(this);
	  m2.add(i3);
	  i4 = new JMenuItem("Add Drivers");
	  i4.addActionListener(this);
	  m2.add(i4);
	  mb.setBounds(0,0,1950,30);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
	  JLabel l1 =new JLabel(i1);
	  l1.setBounds (0,0,1550,900);
	  add(l1);
	  JLabel l2 = new  JLabel("THE RAMANUJ INNS WELCOMES YOU");
	  l2.setBounds(400,30,1000,50);
	  l2.setForeground(Color.white);
	  l2.setFont(new Font("Tahoma",Font.PLAIN,40));
	  l1.add(l2);
	  setLayout(null);
	  setBounds(0,0,1950,1020);
	  setResizable(false);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
	  
  }
  public void actionPerformed(ActionEvent ae)
	{
	  if (ae.getActionCommand().equals("Reception"))
	  {
		  new Reception().setVisible(true);
      }
	  else if(ae.getActionCommand().equals("Add Employee"))
	  {
		  new AddEmployee().setVisible(true);
	  }
	  else if(ae.getActionCommand().equals("Add Rooms"))
	  {
		  new AddRooms().setVisible(true);
	  }
	  else if(ae.getActionCommand().equals("Add Drivers"))
	  {
		  new AddDrivers().setVisible(true);
	  }
		
		
	}
  public static void main (String args[])
  {
	  new Dashboard().setVisible(true);
  }
}
