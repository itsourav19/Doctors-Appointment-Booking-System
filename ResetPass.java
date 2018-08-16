package UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import IO.Admin_IO;
import Model.Operator;

public class ResetPass implements ActionListener 
{
	
		JFrame fr;
		JLabel lblsid,lblsopwd,lblmsg,lblsnpwd,lblscnpwd;
		JTextField txtsid,txtsopwd,txtsnpwd,txtsncpwd;
		JButton submitbtn,resetbtn,cancelbtn;
		public ResetPass()
		{
			fr=new JFrame("Reset password Window");
			fr.setBounds(00, 00, 1400, 1400);
			
			lblmsg=new JLabel("Reset Password");
			lblmsg.setBounds(500,10,400,100);
			fr.add(lblmsg);
			
			lblsid=new JLabel("Staff ID");
			lblsid.setBounds(20, 120, 80, 20);
			fr.add(lblsid);
			
			txtsid=new JTextField();
			txtsid.setBounds(180, 120, 150, 20);
			fr.add(txtsid);
			
			lblsnpwd=new JLabel("Password");
			lblsnpwd.setBounds(20, 180, 80, 20);
			fr.add(lblsnpwd);
			
			txtsnpwd=new JPasswordField();
			txtsnpwd.setBounds(180, 180, 150, 20);
			fr.add(txtsnpwd);
			
			lblscnpwd=new JLabel("Confirm Password");
			lblscnpwd.setBounds(20, 240, 180, 20);
			fr.add(lblscnpwd);
			
			txtsncpwd=new JPasswordField();
			txtsncpwd.setBounds(180, 240, 150, 20);
			fr.add(txtsncpwd);
			
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
				AdminUI.main(new String[]{});
				fr.dispose();
			}
			 else if(e.getSource()==resetbtn)
			 {
				 txtsnpwd.setText(null);
				 txtsid.setText(null);
				 txtsncpwd.setText(null);
				 //txtscpwd.setText(null);
				 //txtmob.setText(null);
				
			 }
			
			else if (e.getSource()==submitbtn)
			{
				
			    String sid=txtsid.getText();
				
				String snpwd=txtsnpwd.getText();
				String sncpwd=txtsncpwd.getText();
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
				Admin_IO aio=new Admin_IO();
				if(aio.ResetPass(sid,snpwd))
				    lblmsg.setText("updated succ");
				else
					lblmsg.setText("not found");
			}
				
			 }
		
		public static void main(String[] args)
		{
			new ResetPass();
		}
		
	}



