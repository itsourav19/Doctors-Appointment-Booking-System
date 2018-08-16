package UI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import IO.Admin_IO;
import Model.Operator;

public class AddOperator implements ActionListener
{
	JFrame fr;
	JLabel lblstaffnm,lblstaffid,lblpwd,lblcpwd,lblmob,lblmsg,lblimg,lblores,lblsl;
	JTextField txtstaffnm,txtstaffid,txtmob;
	JPasswordField txtpwd,txtcpwd;
	JButton submitbtn,cancelbtn,resetbtn;
	JRadioButton radiostaff,radioadmin;
	ButtonGroup atype;
	 public AddOperator()
	 {
		 fr=new JFrame("Operator Registration");	
			fr.setBounds(0,0,800,800);
			
			lblores=new JLabel("*****     Operator Registration     *****");
			lblores.setBounds(250, 20,300,20);
			fr.add(lblores);
			
			lblstaffid=new JLabel("ID");
			lblstaffid.setBounds(150,50,80,20);
			fr.add(lblstaffid);
			
			txtstaffid=new JTextField();
			txtstaffid.setBounds(250,50,80,20);
			fr.add(txtstaffid);
			
			lblstaffnm=new JLabel("Name");
			lblstaffnm.setBounds(350,50,80,20);
			fr.add(lblstaffnm);
			
			txtstaffnm=new JTextField();
			txtstaffnm.setBounds(450,50,80,20);
			fr.add(txtstaffnm);
			
			
			
			lblpwd=new JLabel("Password");
			lblpwd.setBounds(150,80,80,20);
			fr.add(lblpwd);
			
			txtpwd=new JPasswordField();
			txtpwd.setBounds(250,80,80,20);
			fr.add(txtpwd);
			
			lblcpwd=new JLabel("Cpassword");
			lblcpwd.setBounds(350,80,80,20);
			fr.add(lblcpwd);
			
			txtcpwd=new JPasswordField();
			txtcpwd.setBounds(450,80,80,20);
			fr.add(txtcpwd);
			
			lblmob=new JLabel("Mobile");
			lblmob.setBounds(300,110,80,20);
			fr.add(lblmob);
			
			txtmob=new JTextField();
			txtmob.setBounds(350,110,80,20);
			fr.add(txtmob);
			
			radiostaff=new JRadioButton("Staff");
			radiostaff.setBounds(270, 140, 80, 20);
			fr.add(radiostaff);
			
			radioadmin=new JRadioButton("Admin");
			radioadmin.setBounds(400, 140, 80, 20);
			fr.add(radioadmin);
			
			atype=new ButtonGroup();
			atype.add(radioadmin);
			atype.add(radiostaff);

			cancelbtn=new JButton("Back");
			cancelbtn.setBounds(200,200,100,20);
			fr.add(cancelbtn);
			
			submitbtn=new JButton("submit");
			submitbtn.setBounds(350,200,100,20);
			fr.add(submitbtn);
			
			resetbtn=new JButton("reset");
			resetbtn.setBounds(500,200,100,20);
			fr.add(resetbtn); 
			
			lblmsg=new JLabel();
			lblmsg.setBounds(350,180,200,20);
			fr.add(lblmsg);
			
			/*lblsl=new JLabel();
			lblsl.setBounds(10,220,150,20);
			fr.add(lblsl);*/
			
			
			
			lblimg=new JLabel(new ImageIcon("images/oper.jpg"));
			lblimg.setBounds(0, 0, 800, 800);
			fr.add(lblimg);	
			
			cancelbtn.addActionListener(this);
			submitbtn.addActionListener(this);
			resetbtn.addActionListener(this);
			
			fr.setLayout(null);
			fr.show();
	 }
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==cancelbtn)
				{
					AdminUI.main(new String[]{});
					fr.dispose();
				}
				 else if(e.getSource()==resetbtn)
				 {
					 txtstaffnm.setText(null);
					 txtstaffid.setText(null);
					 txtpwd.setText(null);
					 txtcpwd.setText(null);
					 txtmob.setText(null);
					
				 }
				 else if(e.getSource()==submitbtn)
				 {
					 String uid=txtstaffid.getText();
						String name=txtstaffnm.getText();
						String mob=txtmob.getText();
						String pwd=txtpwd.getText();
						String cpwd=txtcpwd.getText();
						if(pwd.equals(cpwd)==false)
						{
							lblmsg.setText("Password mismatched");
							return;
						}
						if(uid.equals("") || name.equals("") || pwd.equals("")||mob.equals(""))
						{
							lblmsg.setText("Empty Filed");
							return;
						}
						String ty="";
						if (radiostaff.isSelected())
							ty="Staff";
						else if (radioadmin.isSelected())
							ty="Admin";
						else
						{
							lblmsg.setText(" Select User type");
							return;
						}
						
						
						Operator op=new Operator(name,uid,pwd,ty,mob);
						Admin_IO aio=new Admin_IO();
						if(aio.addOperator(op))
							lblmsg.setText("Added Succ...");
						else
							lblmsg.setText("Duplicate ID");
				 }
	 }
	 public static void main(String args[])
		{
			new AddOperator();
		}
}

