import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
  AddEmployee()
  {
	  JLabel name = new JLabel("NAME");
	  name.setBounds(60,30,120,30);
	  name.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(name);
	  JLabel age = new JLabel("AGE");
	  age.setBounds(60,80,120,30);
	  age.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(age);
	  JLabel gender = new JLabel("GENDER");
	  gender.setBounds(60,130,120,30);
	  gender.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(gender);
	  JLabel job = new JLabel("JOB");
	  job.setBounds(60,180,120,30);
	  job.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(job);
	  JLabel salary = new JLabel("SALARY");
	  salary.setBounds(60,230,120,30);
	  salary.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(salary);
	  JLabel phone = new JLabel("PHONE");
	  phone.setBounds(60,280,120,30);
	  phone.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(phone);
	  JLabel adhar = new JLabel("ADHAR");
	  adhar.setBounds(60,330,120,30);
	  adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(adhar);
	  JLabel email = new JLabel("EMAIL");
	  email.setBounds(60,380,120,30);
	  email.setFont(new Font("Tahoma",Font.PLAIN,17));
	  add(email);
	  t1 = new JTextField ();
	  t1.setBounds(200,30,150,30);
	  add(t1);
	  t2 = new JTextField ();
	  t2.setBounds(200,80,150,30);
	  add(t2);
	  t3 = new JTextField ();
	  t3.setBounds(200,230,150,30);
	  add(t3);
	  t4 = new JTextField ();
	  t4.setBounds(200,280,150,30);
	  add(t4);
	  t5 = new JTextField ();
	  t5.setBounds(200,330,150,30);
	  add(t5);
	  t6 = new JTextField ();
	  t6.setBounds(200,380,150,30);
	  add(t6);
	  r1 = new JRadioButton("Male");
	  r1.setBounds(200,130,70,30);
	  r1.setFont(new Font("Tahoma",Font.PLAIN,14));
	  r1.setBackground(Color.white);
	  add(r1);
	  r2 = new JRadioButton("Female");
	  r2.setBounds(280,130,70,30);
	  r2.setFont(new Font("Tahoma",Font.PLAIN,14));
	  r2.setBackground(Color.white);
	  add(r2);
	  String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
	  c1 = new JComboBox(str);
	  c1.setBounds(200,180,150,30);
	  c1.setBackground(Color.white);
	  add(c1);
	  b1 = new JButton("SUBMIT");
	  b1.setBackground(Color.white);
	  b1.setForeground(Color.black);
	  b1.setBounds(200,430,150,30);
	  b1.addActionListener(this);
	  add(b1);
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
	  JLabel l1 =new JLabel(i1);
	  l1.setBounds (380,60,450,450);
	  add(l1);
	  JLabel l2 = new JLabel("ADD EMPLOYEE DETAILS");
	  l2.setForeground(Color.blue);
	  l2.setFont(new Font("Tahoma",Font.PLAIN,30));
	  l2.setBounds (420,30,400,30);
	  add(l2);
	  getContentPane().setBackground(Color.white);
	  setLayout(null);
	  setBounds(200,100,850,540);
	  setResizable(false);
	  setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
	  String name = t1.getText();
	  String age = t2.getText();
	  String salary = t3.getText();
	  String phone = t4.getText();
	  String adhar = t5.getText();
	  String email = t6.getText();
	  String gender = null;
	  if (r1.isSelected())
	  {
		  gender = "male";
      }
	  else if(r2.isSelected())
	  {
		  gender = "female";
	  }
	  String job =(String)c1.getSelectedItem();
	  conn c = new conn();
	  String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+adhar+"','"+email+"')";
	  try
	  {
		 c.s.executeUpdate(str) ;
		 JOptionPane.showMessageDialog(null, "New Employee Added");
		 this.setVisible(false);
	  }
	  catch (Exception e)
	  {
		  
	  }
  }
	  
  public static void main (String args[])
  {
	  new AddEmployee().setVisible(true);
  }
}
  
