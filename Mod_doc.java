
package UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import IO.Admin_IO;
import Model.Doctor;

public class Mod_doc implements ActionListener
{
	JFrame fr;
	JComboBox  atype_cb;
	JComboBox did_cb,dspl_cb,choiceid;
	JLabel lblmdoc,lbldname,lbldavl,lbldmob,lblmsg,lbldid,lbldspl,lblimg,lbldgen;
	JTextField txtdname,txtdid,txtdspl,txtdavl,txtdmob,txtdgen;
	JRadioButton radioweekend,radioweekday,radioeveryday;
	JButton submitbtn,resetbtn,cancelbtn;
	ButtonGroup sctype;
	String aty[];
	 public Mod_doc()
	 {
		 fr=new JFrame("Modify Doctor");
		 fr.setBounds(0,0,1400,800);
		  
		  lblmdoc=new JLabel("Update Doctor Details");
		  lblmdoc.setBounds(550, 50, 300, 30);
		  fr.add(lblmdoc);
		  
		  lbldid=new JLabel("Doctor ID");
		  lbldid.setBounds(500,100,100,20);
		  Admin_IO a=new Admin_IO();
		  aty=a.getDoctorIds();
		  fr.add(lbldid);
		  
		  did_cb=new JComboBox(aty);
		  did_cb.setBounds(650,100,100,20);
		  fr.add(did_cb);
		  
		  lbldname=new JLabel("Doctor Name");
		  lbldname.setBounds(500,140,100,20);
		  fr.add(lbldname);
		  
		  txtdname=new JTextField();
		  txtdname.setBounds(650,140,100,20);
		  fr.add(txtdname);
		  
		  lbldspl=new JLabel("Specialization");
		  lbldspl.setBounds(500,180,100,20);
		  fr.add(lbldspl);
		  
		  /*dspl_cb=new JComboBox(aty1);
		  dspl_cb.setBounds(100,90,100,20);
		  fr.add(dspl_cb);*/
		  
		  txtdspl=new JTextField();
		  txtdspl.setBounds(650,180,100,20);
		  fr.add(txtdspl);
		  
		  lbldgen=new JLabel("Gender");
		  lbldgen.setBounds(800,180,100,20);
		  fr.add(lbldgen);
		  
		  txtdgen=new JTextField();
		  txtdgen.setBounds(870,180,100,20);
		  fr.add(txtdgen);
		  
		   lbldmob=new JLabel("Mobile");
		  lbldmob.setBounds(500,220,100,20);
		  fr.add(lbldmob);
		  
		  txtdmob=new JTextField();
		  txtdmob.setBounds(650,220,100,20);
		  fr.add(txtdmob);
		  
		  lbldavl=new JLabel("Availability");
		  lbldavl.setBounds(600,260,200,20);
		  fr.add(lbldavl);
		  
		  radioweekend=new JRadioButton("Weekday");
		  radioweekend.setBounds(500,290,100,20);
		  fr.add(radioweekend);
		  
		  radioweekday=new JRadioButton("Weekend");
		  radioweekday.setBounds(610,290,100,20);
		  fr.add(radioweekday);
		  
		  radioeveryday=new JRadioButton("Everyday");
		  radioeveryday.setBounds(720,290,100,20);
		  fr.add(radioeveryday); 
		  
		  sctype=new ButtonGroup();
		  sctype.add(radioweekday);
		  sctype.add(radioweekend);
		  sctype.add(radioeveryday);
		  
		  cancelbtn= new JButton("Back");
		  cancelbtn.setBounds(500,350,90,30);
		  fr.add(cancelbtn);
		  
		  submitbtn= new JButton("Submit");
		  submitbtn.setBounds(610,350,90,30);
		  fr.add(submitbtn);
		  
		  resetbtn= new JButton("Reset");
		  resetbtn.setBounds(720,350,90,30);
		  fr.add(resetbtn);
		  
		  lblmsg=new JLabel();
			lblmsg.setBounds(620,500,200,30);
			fr.add(lblmsg);
		  
		  lblimg=new JLabel(new ImageIcon("images/doc1.jpg"));
		  lblimg.setBounds(0, 0, 1300, 750);
		  fr.add(lblimg);
		  
		  cancelbtn.addActionListener(this);
		  submitbtn.addActionListener(this);
		  resetbtn.addActionListener(this);
		  did_cb.addActionListener(this);
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
		 else if(e.getSource()==did_cb)
		 {
			 	String did=did_cb.getSelectedItem().toString();
			 	Admin_IO a=new Admin_IO();
			 	
			    Doctor dd=a.getDoctorById(did);
			    txtdname.setText(dd.getdName());
			 	txtdspl.setText(dd.getdSpcl());
			 	txtdmob.setText(dd.getdMob());
			 	txtdgen.setText(dd.getdGen());
		 }
		 else if(e.getSource()==submitbtn)
		 {
			 String did=did_cb.getSelectedItem().toString();
			 String dname=txtdname.getText();
			 String dmob=txtdmob.getText();
			 String dspcl=txtdspl.getText();
			 String dscdl=txtdavl.getText();
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
				lblmsg.setText("Empty Filed");
				if(dmob.equals("")||ty1.equals(""))
				{
					lblmsg.setText("Empty Filed");
					return;
				}
				Doctor d=new Doctor(did,dname,dmob,dspcl,dscdl,ty1);
				Admin_IO aio=new Admin_IO();
				if(aio.addDoctor(d))
					lblmsg.setText("Updated Succ....");
				else
					lblmsg.setText("Not Updated");
		 }
		 else if(e.getSource()==resetbtn)
		 {
			 txtdname.setText(null);
			 txtdmob.setText(null);
			 txtdspl.setText(null);
			 sctype.clearSelection();
		 }
	 }
	 public static void main(String args[])
	 {
		 new Mod_doc();
	 }
}
