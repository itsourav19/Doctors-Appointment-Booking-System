package UI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CashByStaff implements ActionListener
{
	JFrame fr;
	JLabel lbldate,lblsid,lblscash;
	JTextField txtdate,txtsid,txtscash;
	JButton submitbtn,resetbtn,cancelbtn;
	public CashByStaff()
	 {
		fr=new JFrame("Staff Cash Collection");	
		fr.setBounds(0,0,600,600);
		
		lbldate=new JLabel("Date");
		lbldate.setBounds(400,10,80,20);
		fr.add(lbldate);
		
		txtdate=new JTextField();
		txtdate.setBounds(450,10,80,20);
		fr.add(txtdate);
		
		lblsid=new JLabel("Staff ID");
		lblsid.setBounds(20,100,80,20);
		fr.add(lblsid);
		
		txtsid=new JTextField();
		txtsid.setBounds(100,100,80,20);
		fr.add(txtsid);
		
		lblscash=new JLabel("Cash");
		lblscash.setBounds(20,150,80,20);
		fr.add(lblscash);
		
		txtscash=new JTextField();
		txtscash.setBounds(100,150,80,20);
		fr.add(txtscash);
		
		submitbtn=new JButton("Back");
		submitbtn.setBounds(100,400,150,50);
		fr.add(submitbtn);
			
		
		
		submitbtn.addActionListener(this);
		
		
		
		fr.setLayout(null);
		fr.show();
		



	 }
	
	
	public static void main(String args[])
	{
		new CashByStaff();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==submitbtn)
		{
		 Staff_UI.main(new String[]{});
			fr.dispose();
		}
		
	}
}
