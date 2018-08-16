package UI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Staff_UI implements ActionListener
{
	JLabel imglbl;
	JFrame fr,jf;
	JPanel pan1;
	JLabel lblstf;
	JRadioButton radiostaff,radioadmin;
	JTextField txtun,txtuid,txtmob;
	JPasswordField txtpwd,txtcpwd;
	JButton submitbtn,resetbtn,cancelbtn,backbtn;
	String aty[]={"Select","Admin","Staff"};
	JComboBox atype_cb;
	
	public Staff_UI()
	{
		fr=new JFrame("    STAFF   ");
		fr.setBounds(0, 0, 1400, 800);
		
		
		lblstf=new JLabel("*****               Staff Area              *****");
		lblstf.setBounds(600, 50, 250, 30);
		fr.add(lblstf);
		
		
		
		submitbtn=new JButton("Change Password");
		submitbtn.setBounds(600,180,200,80);
		fr.add(submitbtn);
		
		resetbtn=new JButton("Day Wise Report");
		resetbtn.setBounds(850,180,200,80);
		fr.add(resetbtn);
		
		cancelbtn=new JButton("Patient Booking");
		cancelbtn.setBounds(350,180,200,80);
		fr.add(cancelbtn);
		
		imglbl=new JLabel(new ImageIcon("images/staff.jpg"));
		imglbl.setBounds(0, 0, 1400, 800);
		fr.add(imglbl);
		
		/*lblmsg=new JLabel();
		lblmsg.setBounds(30,60,200,30);
		fr.add(lblmsg);*/
		backbtn=new JButton("Logout");
		backbtn.setBounds(850,100,90,20);
		fr.add(backbtn);
		
		submitbtn.addActionListener(this);
		resetbtn.addActionListener(this);
		cancelbtn.addActionListener(this);
		backbtn.addActionListener(this);
		
		fr.setLayout(null);
		fr.show();
	}
	public static void main(String []args)
	{
		new Staff_UI();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==submitbtn)
		{
		 Change_pass.main(new String[]{});
			fr.dispose();
		}
	 else if(e.getSource()==resetbtn)
	 {
		 CashByStaff.main(new String[]{});
		 fr.dispose();
	 }
	 else if (e.getSource()==cancelbtn)
	 {
		 BookingUI.main(new String[]{});
		 fr.dispose();
	 }
	 else if (e.getSource()==backbtn)
	 {
		 Welcome.main(new String[]{});
		 fr.dispose();
	 }
		
	}
}
