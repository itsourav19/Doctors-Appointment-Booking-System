package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import IO.Admin_IO;
import IO.Staff_Io;
import IO.Staff_Job;
import Model.Operator;

public class Change_pass implements ActionListener
{

		JFrame fr;
		JLabel lblsid,lblmsg,lblscpwd,lblspwd;
		JTextField txtsid,txtspwd,txtscpwd;
		JButton submitbtn,resetbtn,cancelbtn;
		public Change_pass()
		{
			fr=new JFrame("Change password Window");
			fr.setBounds(00, 00, 1400, 1400);
			
			lblmsg=new JLabel("Change Password");
			lblmsg.setBounds(500,10,400,100);
			fr.add(lblmsg);
			
			lblsid=new JLabel("Staff ID");
			lblsid.setBounds(20, 120, 80, 20);
			fr.add(lblsid);
			
			txtsid=new JTextField();
			txtsid.setBounds(180, 120, 150, 20);
			fr.add(txtsid);
			
			lblspwd=new JLabel("Password");
			lblspwd.setBounds(20, 180, 80, 20);
			fr.add(lblspwd);
			
			txtspwd=new JPasswordField();
			txtspwd.setBounds(180, 180, 150, 20);
			fr.add(txtspwd);
			
			lblscpwd=new JLabel("Confirm Password");
			lblscpwd.setBounds(20, 240, 180, 20);
			fr.add(lblscpwd);
			
			txtscpwd=new JPasswordField();
			txtscpwd.setBounds(180, 240, 150, 20);
			fr.add(txtscpwd);
			
			cancelbtn=new JButton("Back");
			cancelbtn.setBounds(50,420,90,20);
			fr.add(cancelbtn);
			
			submitbtn=new JButton("Submit");
			submitbtn.setBounds(160,420,90,20);
			fr.add(submitbtn);
			
			resetbtn=new JButton("Reset");
			resetbtn.setBounds(270,420,90,20);
			fr.add(resetbtn);
			
			
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
				Staff_UI.main(new String[]{});
				fr.dispose();
			}
			
			else if(e.getSource()==resetbtn)
			{
				txtsid.setText(null);
				txtspwd.setText(null);
				txtscpwd.setText(null);
			}
			else if (e.getSource()==submitbtn)
			{
				
			    String sid=txtsid.getText();
				
				String snpwd=txtspwd.getText();
				String sncpwd=txtscpwd.getText();
				if(snpwd.equals(sncpwd)==false)
				{
					lblmsg.setText("Password mismatched");
					return;
				}
				if(sid.equals("") ||  snpwd.equals("") || sncpwd.equals(""))
				{
					lblmsg.setText("Empty Field");
					return;
				}				
				Staff_Io sio=new Staff_Io();
				if(sio.Change_Pass(sid,snpwd))
				    lblmsg.setText("Succ Changed");
				else
					lblmsg.setText("No Change");
			}
				
		}
		
		public static void main(String[] args)
		{
			new Change_pass();
		}
		
	}



