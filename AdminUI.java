package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminUI implements ActionListener
{
	JLabel imglbl;
	JFrame fr,jf;
	JPanel pan1;
	JLabel lblstf;
	JRadioButton radiostaff,radioadmin;
	JTextField txtun,txtuid,txtmob;
	JPasswordField txtpwd,txtcpwd;
	JButton respwdbtn,dwrbtn,adocbtn,udocbtn,astaffbtn,backbtn;
	String aty[]={"Select","Admin","Staff"};
	JComboBox atype_cb;
	
	public AdminUI()
	{
		fr=new JFrame("    ADMIN   ");
		fr.setBounds(0, 0, 1400, 800);
		
		/*pan1=new JPanel();
		pan1.setBounds(50,50,550,500);
		pan1.setBackground(Color.BLUE);*/
		
		lblstf=new JLabel("*****    Admin Area    *****");
		lblstf.setBounds(400, 40, 400, 20);
		fr.add(lblstf);
		
		
		
		respwdbtn=new JButton("Reset Password");
		respwdbtn.setBounds(520,80,250,80);
		fr.add(respwdbtn);
		
		dwrbtn=new JButton("Operator Wish Report");
		dwrbtn.setBounds(360,260,340,80);
		fr.add(dwrbtn);
		
		adocbtn=new JButton("Add Doctor");
		adocbtn.setBounds(250,170,250,80);
		fr.add(adocbtn);
		
		udocbtn=new JButton("Update Doctor Details");
		udocbtn.setBounds(520,170,250,80);
		fr.add(udocbtn);
		
		astaffbtn=new JButton("Add Operator");
		astaffbtn.setBounds(250,80,250,80);
		fr.add(astaffbtn);
		
		backbtn=new JButton("Logout");
		backbtn.setBounds(650,50,90,20);
		fr.add(backbtn);
		
		imglbl=new JLabel(new ImageIcon("images/admin.jpg"));
		imglbl.setBounds(0, 0, 1300, 800);
		fr.add(imglbl);
		
		
		
		
		/*lblmsg=new JLabel();
		lblmsg.setBounds(30,60,200,30);
		fr.add(lblmsg);*/
		
		
		adocbtn.addActionListener(this);
		udocbtn.addActionListener(this);
		astaffbtn.addActionListener(this);
		dwrbtn.addActionListener(this);
		respwdbtn.addActionListener(this);
		backbtn.addActionListener(this);
		
		
		
		fr.setLayout(null);
		fr.show();
	}
	public static void main(String []args)
	{
		new AdminUI();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==respwdbtn)
		{
			ResetPass.main(new String[]{});
			fr.dispose();
		}
		else if(e.getSource()==udocbtn)
		{
			Mod_doc.main(new String[]{});
			fr.dispose();
		}
		else if(e.getSource()==adocbtn)
		{
			DoctorUI.main(new String[]{});
			fr.dispose();
		}
		else if(e.getSource()==dwrbtn)
		{
			CashByAdmin.main(new String[]{});
			fr.dispose();
		}
		else if(e.getSource()==astaffbtn)
		{
			AddOperator.main(new String[]{});
			fr.dispose();
		}
		else if(e.getSource()==backbtn)
		{
			Welcome.main(new String[]{});
			fr.dispose();
		}
		
	}

}
