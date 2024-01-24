
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class HMS extends JFrame implements ActionListener
	{
		HMS()
		{
			setBounds(0,0,1280,720);
			//setSize(400,400);
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
			JLabel l1=new JLabel (i1);
			l1.setBounds(0,0,1280,720);
			add(l1);
			JLabel l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
			l2.setBounds(0,0,1000,100);
			l1.add(l2);
			l2.setForeground(Color.white);
			l2.setFont(new Font("serif",Font.PLAIN,50));
			JButton b1=new JButton("Next");
			b1.setBackground(Color.white);
			b1.setForeground(Color.black);
			b1.setBounds(1100,650,150,30);
			b1.addActionListener(this);
			l1.add(b1);
			setLayout(null);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			//setLocation(300,300);
			setVisible(true);
			while(true)
			{
				l2.setVisible(false);
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e){}
				l2.setVisible(true);
				try 
				{
				Thread.sleep(500);
				}
				catch(Exception e){}
				
			}
			
		}
		public void actionPerformed(ActionEvent ae)
		{
			new Login().setVisible(true);
			this.setVisible(false);
		}
		public static void main (String args[])
		{
		new HMS();
		}
	}

