import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener
{
	JButton b1,b2;
	JTable t1;
    Department()
    {
    	JLabel l1 = new JLabel("Department");
		l1.setBounds(120,10,120,30);
		add(l1);
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(460,10,120,30);
		add(l2);
    	t1= new JTable ();
    	t1.setBounds(0,50,700,350);
    	t1.setBackground(Color.WHITE);
    	add(t1);
    	b1 = new JButton("Submit");
		b1.setBackground(Color.white); 
		b1.setForeground(Color.black);
		b1.setBounds(180,400,120,30);
		b1.addActionListener(this);
		add(b1);
		b2 = new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(380,400,120,30);
		b2.addActionListener(this);
		add(b2);
		getContentPane().setBackground(Color.white);
    	setLayout(null);
		setBounds(200,50,700,480);
		setResizable(false);
		setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if (ae.getSource()==b1)
    	{
    		try
    		{
    			String str1 ="select * from department";
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
    	new Department().setVisible(true);
    }
    
}
