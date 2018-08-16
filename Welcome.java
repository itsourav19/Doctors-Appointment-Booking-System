package UI;


import java.awt.event.*;

import javax.swing.*;

import IO.Admin_IO;
import IO.Staff_Io;
import IO.Staff_Job;
import Model.Operator;


public class Welcome implements ActionListener
{	
	JFrame fr;
	JLabel lblpwd,lbluid,lblatype,lblmsg,lblwlcm,lblimg;
	JRadioButton radiostaff,radioadmin;
	JTextField txtuid;
	JPasswordField txtpwd;
	JButton loginbtn;
	ButtonGroup atype;	
	
	public Welcome()
	{
		fr=new JFrame("     WELCOME    ");
		fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		lblwlcm=new JLabel("Welcome to Global Hospital");
		lblwlcm.setBounds(550,10,500,100);
		fr.add(lblwlcm);
		
		lbluid=new JLabel("User ID");
		lbluid.setBounds(1050, 80, 80, 20);
		fr.add(lbluid);
		
		txtuid=new JTextField();
		txtuid.setBounds(1150, 80, 100, 20);
		fr.add(txtuid);
		
		lblpwd=new JLabel("Password");
		lblpwd.setBounds(1050, 110, 80, 20);
		fr.add(lblpwd);
		
		txtpwd=new JPasswordField();
		txtpwd.setBounds(1150, 110, 100, 20);
		fr.add(txtpwd);
		
		radioadmin=new JRadioButton("Admin");
		radioadmin.setBounds(1070,140,70,20);
		fr.add(radioadmin);
		
		radiostaff=new JRadioButton("Staff");
		radiostaff.setBounds(1150,140,60,20);
		fr.add(radiostaff);
		
		atype=new ButtonGroup();
		atype.add(radiostaff);
		atype.add(radioadmin);
				
				
		lblmsg=new JLabel();
		lblmsg.setBounds(10,210,200,30);
		fr.add(lblmsg);
		
		
		loginbtn=new JButton("Log In");
		loginbtn.setBounds(1100,170,90,20);
		fr.add(loginbtn);
		
		
		loginbtn.addActionListener(this);

		lblimg=new JLabel(new ImageIcon("images/welcome.jpg"));
		lblimg.setBounds(0, 0, 1300, 750);
		fr.add(lblimg);		
		
		fr.setLayout(null);
		fr.show();
	}
	public static void main(String []args)
	{
		new Welcome();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		 if (e.getSource()==loginbtn)
		{
					String id=txtuid.getText();
					String ty="";
					if (radiostaff.isSelected())
						ty="Staff";
					else if (radioadmin.isSelected())
						ty="Admin";
					else
						{
							lblmsg.setText("Please select User type");
							return;
						}
					String pwd=txtpwd.getText();
					if(id.equals("") || pwd.equals(""))
					{
						lblmsg.setText("Empty Filed");
						return;
					}
					if(id.equals("admin")&&pwd.equals("admin")&&ty.equals("Admin"))
					{
						AdminUI.main(new String[]{});
						fr.dispose();
					}
					Admin_IO aio=new Admin_IO();
					Staff_Io sio=new Staff_Io();
					String ch="Admin";
					if(ch==ty)
					{
						if (aio.adminValidation(id,pwd))
						{
							AdminUI.main(new String[]{});
							fr.dispose();
						}
						else
						{
							txtuid=null;
							txtpwd=null;
						}
						
					
					}
					else
					{
						if (sio.staffValidation(id,pwd))
							{
								Staff_UI.main(new String[]{});	
							}
							else
							{
								//Give a msg user name and pass error
								txtuid=null;
								txtpwd=null;
							}
						}
					}
		}
}