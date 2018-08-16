package UI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;

import IO.Admin_IO;
import Model.*;

public class DoctorUI implements ActionListener
{
	JComboBox dtype_cb,gen_cb;
	String aty[]={"Select","Cardiology","Dentist","Eye","General","Gynecologist","Neurologist","Orthopedic","Pediatrician","Psychiatrist","Urologist"};
	String aty1[]={"Select","Female","Male"};
	JFrame fr;
	JLabel lbldname,lbldid,lbldspl,lbldavl,lbldmob,lblmsg,lbladoc,lblavl,lblgen,lblimg;
	JTextField txtdname,txtdid,txtdspl,txtdavl,txtdmob;
	JRadioButton radioweekend,radioweekday,radioeveryday;
	ButtonGroup atype;
	JButton submitbtn,resetbtn,cancelbtn;
	JRadioButton radiomale,radiofemale;
	ButtonGroup gen;
	
	public DoctorUI()
	{
		fr=new JFrame("Add Doctor");
		fr.setBounds(00, 00, 1400, 800);
		
		lbladoc=new JLabel("Doctor Registration");
		lbladoc.setBounds(50,10,400,100);
		fr.add(lbladoc);
		
		lbldid=new JLabel("Doctor ID");
		lbldid.setBounds(50, 130, 100, 20);
		fr.add(lbldid);
		
		txtdid=new JTextField();
		txtdid.setBounds(250, 130, 100, 20);
		fr.add(txtdid);
		
		lbldname=new JLabel("Doctor Name");
		lbldname.setBounds(50, 170, 100, 20);
		fr.add(lbldname);
		
		txtdname=new JTextField();
		txtdname.setBounds(250, 170, 100, 20);
		fr.add(txtdname);
		
		lbldmob=new JLabel("Mobile No");
		lbldmob.setBounds(50, 210, 100, 20);
		fr.add(lbldmob);
		
		txtdmob=new JTextField();
		txtdmob.setBounds(250, 210, 100, 20);
		fr.add(txtdmob);
		
		lbldspl=new JLabel("Specialization");
		lbldspl.setBounds(50,250,100,20);
		fr.add(lbldspl);
		
		dtype_cb=new JComboBox(aty);
		dtype_cb.setBounds(250, 250, 120, 20);
		fr.add(dtype_cb);
		
		lblgen=new JLabel("Gender");
		lblgen.setBounds(50,290,100,20);
		fr.add(lblgen);
		
		radiofemale=new JRadioButton("Female");
		radiofemale.setBounds(250,280,100,20);
		fr.add(radiofemale);
		
		radiomale=new JRadioButton("Male");
		radiomale.setBounds(250,300,100,20);
		fr.add(radiomale);
				
		gen=new ButtonGroup();
		gen.add(radiomale);
		gen.add(radiofemale);
		
		lblavl=new JLabel("Availability");
		lblavl.setBounds(170,330,100,20);
		fr.add(lblavl);
		
		radioweekend=new JRadioButton("Weekend");
		radioweekend.setBounds(50, 360, 100, 20);
		fr.add(radioweekend);
		
		radioweekday=new JRadioButton("Weekday");
		radioweekday.setBounds(160, 360, 100, 20);
		fr.add(radioweekday);
		
		radioeveryday=new JRadioButton("Everyday");
		radioeveryday.setBounds(270, 360, 100, 20);
		fr.add(radioeveryday);		
		
		atype=new ButtonGroup();
		atype.add(radioweekend);
		atype.add(radioweekday);
		atype.add(radioeveryday);		
		
		cancelbtn=new JButton("Back");
		cancelbtn.setBounds(50,420,90,20);
		fr.add(cancelbtn);
		
		submitbtn=new JButton("Submit");
		submitbtn.setBounds(160,420,90,20);
		fr.add(submitbtn);
		
		resetbtn=new JButton("Reset");
		resetbtn.setBounds(270,420,90,20);
		fr.add(resetbtn);
		
		lblmsg=new JLabel();
		lblmsg.setBounds(50,450,200,30);
		fr.add(lblmsg);
		
		lblimg=new JLabel(new ImageIcon("images/doctor.jpg"));
		lblimg.setBounds(0, 0, 1300, 750);
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
		 else if(e.getSource()==submitbtn)
		 {
			 	String dID=txtdid.getText();
				String dName=txtdname.getText();
				String dmob=txtdmob.getText();
				String dSpcl=dtype_cb.getSelectedItem().toString();
				String ty="";
				if (radiomale.isSelected())
					ty="Male";
				else if (radiofemale.isSelected())
					ty="Female";
				else
				{
					lblmsg.setText("Please select Gender type");
					return;
				}
				String ty1="";
				if(radioweekend.isSelected())
					ty1="Weekend";
				else if(radioweekday.isSelected())
					ty1="Weekday";
				else if(radioeveryday.isSelected())
					ty1="Everyday";
				else
				{
					lblmsg.setText("Please Enter Doctor Availability");
					return ;
				}
					
				if(dID.equals("") || dName.equals("") || dmob.equals("")||ty.equals("")||ty1.equals(""))
				{
					lblmsg.setText("Empty Filed");
					return;
				}
				Doctor d=new Doctor(dID,dName,dmob,dSpcl,ty1,ty);
				Admin_IO aio=new Admin_IO();
				if(aio.addDoctor(d))
					lblmsg.setText("Added Succ....");
				else
					lblmsg.setText("Duplicate Id");
			 
		 }
		else if(e.getSource()==resetbtn)
		{
			txtdname.setText(null);
			txtdid.setText(null);
			txtdmob.setText(null);
			atype.clearSelection();
			gen.clearSelection();
			
		}
	}
	public static void main(String[] args)
	{
		new DoctorUI();
	}
}
