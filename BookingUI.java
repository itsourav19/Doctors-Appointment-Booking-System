package UI;

import java.awt.Color;
import java.awt.event.*;
import java.text.ParseException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;


import IO.Admin_IO;
import IO.Staff_Io;
import Model.Booking;
import Model.Doctor;
import Model.Operator;

public class BookingUI implements ActionListener
{
	JComboBox atype_cb,id_cb;
	JPanel pan1;
	JLabel lblimg,lblhead,lblmsg1,lblbkdt,lblmsg,lblbname,lblfee,lblslno,imglbl,lblprob,lblbk,lbldsp,lbldate,lblddt,lbldid,lblpname,lblpage,lblpgen,lblpatient,lblpmob,lbldsts,lblbid;
	JTextField txtbkdt,txtdname,txtdate,txtslno,txtfee,txtpname,txtpage,txtpgen,txtpmob,txtdsts,txtbid,txtprob;
	JFrame fr;
	JTable jt;
	String aty[]={"Select","Cardiology","Dentist","Eye","General","Gynecologist","Neurologist","Orthopedic","Pediatrician","Psychiatrist","Urologist"};
	JComboBox dtype_cb,gen_cb;
	String  [][]data;
	String []field_name={"ID","Name","Specialization","Availibility","Fees"};
	String []id;
	JButton submitbtn,resetbtn,cancelbtn;
	Date d,d1;
	JRadioButton radiomale,radiofemale;
	ButtonGroup gen;
	int cds;
	
	public BookingUI()
	{
		fr=new JFrame("Booking");
		fr.setBounds(00, 00, 1400, 800);

		/*pan1=new JPanel();
		
		pan1.setBounds(0,0,1400,800);
		pan1.setBackground(Color.cyan);*/
		fr.getContentPane().setBackground(Color.cyan);
	
		lblbk=new JLabel("****     Patient Booking     *****");
		lblbk.setBounds(600,10,400,100);
		fr.add(lblbk);
		
		/*lblslno=new JLabel("Sl No.");
		lblslno.setBounds(50, 100, 120, 20);
		fr.add(lblslno);
		
		txtslno=new JTextField();
		txtslno.setBounds(200, 100, 120, 20);
		fr.add(txtslno);*/
		
		lblbid=new JLabel("Booking ID");
		lblbid.setBounds(50,130,120,20);
		fr.add(lblbid);
		
		txtbid=new JTextField();
		txtbid.setBounds(200,130,120,20);
		fr.add(txtbid);
		
		lbldsp=new JLabel("Doctor Specalization");
		lbldsp.setBounds(50,160,150,20);
		fr.add(lbldsp);
		
		dtype_cb=new JComboBox(aty);
		dtype_cb.setBounds(210, 160, 120, 20);
		fr.add(dtype_cb);
		dtype_cb.addActionListener(this);
		
		SimpleDateFormat sdf_input=new SimpleDateFormat("dd-MMM-yyyy");
		d=new Date();
		lbldate=new JLabel("Date & Time");
		lbldate.setBounds(1000,100,180,20);
		fr.add(lbldate);
		
		txtdate=new JTextField(String.valueOf(d));
		txtdate.setBounds(1100, 100, 200, 20);
		fr.add(txtdate);
		
		lblddt=new JLabel("Doctor Details");
		lblddt.setBounds(50,200,200,20);
		fr.add(lblddt);
		
		lblhead=new JLabel("ID                            Name                         Availability                         Mobile                    Gender");
		lblhead.setBounds(50,220,700,20);
		fr.add(lblhead);
		
		lbldid=new JLabel("Doctor Id");
		lbldid.setBounds(1000,130,120,20);
		//Staff_Io a=new Staff_Io();
		  //id=a.getDoctorIdBySpecial();
		fr.add(lbldid);
		
		
		id_cb=new JComboBox();
		//id_cb.setBounds(1000, 150, 120, 20);
		fr.add(id_cb);
		id_cb.addActionListener(this);
		
		lblbname=new JLabel("Doctor Name");
		lblbname.setBounds(1000,175,120,20);
		fr.add(lblbname);
		
		txtdname=new JTextField();
		txtdname.setBounds(1000,195,120,20);
		fr.add(txtdname);
		
		lbldsts=new JLabel("Patient Booked Under Dr.");
		lbldsts.setBounds(1000,570,200,20);
		fr.add(lbldsts);
		
		txtdsts=new JTextField();
		txtdsts.setBounds(1000, 590, 50, 20);
		fr.add(txtdsts);
		
		lblfee=new JLabel("FEE");
		lblfee.setBounds(1000, 370, 120, 20);
		fr.add(lblfee);
		
		txtfee=new JTextField();
		txtfee.setBounds(1000, 390, 70, 20);
		fr.add(txtfee);
		
		lblbkdt=new JLabel("Booking Date");
		lblbkdt.setBounds(50, 100, 150, 20);
		fr.add(lblbkdt);
		
		txtbkdt=new JTextField();
		txtbkdt.setBounds(200, 100, 120, 20);
		fr.add(txtbkdt);
		
		lblpatient=new JLabel("Patient Details");
		lblpatient.setBounds(100,450,140,20);
		fr.add(lblpatient);
		
		lblpname=new JLabel("Name");
		lblpname.setBounds(50,480,120,20);
		fr.add(lblpname);
		
		txtpname=new JTextField();
		txtpname.setBounds(200,480,120,20);
		fr.add(txtpname);
		
		lblpage=new JLabel("Age");
		lblpage.setBounds(50, 510, 120, 20);
		fr.add(lblpage);
		
		txtpage=new JTextField();
		txtpage.setBounds(200, 510, 50, 20);
		fr.add(txtpage);
		
		lblpgen=new JLabel("Gender");
		lblpgen.setBounds(50, 540, 120, 20);
		fr.add(lblpgen);
		
		radiofemale=new JRadioButton("Female");
		radiofemale.setBounds(200,540,100,20);
		fr.add(radiofemale);
		
		radiomale=new JRadioButton("Male");
		radiomale.setBounds(300,540,100,20);
		fr.add(radiomale);
				
		gen=new ButtonGroup();
		gen.add(radiomale);
		gen.add(radiofemale);
		
		lblpmob=new JLabel("Mobile");
		lblpmob.setBounds(50,570,120,20);
		fr.add(lblpmob);
		
		txtpmob=new JTextField();
		txtpmob.setBounds(200,570,120,20);
		fr.add(txtpmob);
		
		lblprob=new JLabel("Problem");
		lblprob.setBounds(50, 600, 120, 20);
		fr.add(lblprob);
		
		txtprob=new JTextField();
		txtprob.setBounds(200, 600, 120, 50);
		fr.add(txtprob);
		 
		
		cancelbtn=new JButton("Back");
		cancelbtn.setBounds(300,700,100,20);
		fr.add(cancelbtn);
		
		submitbtn=new JButton("Submit");
		submitbtn.setBounds(600,700,100,20);
		fr.add(submitbtn);
		
		/*resetbtn=new JButton("Reset");
		resetbtn.setBounds(900,700,100,20);
		fr.add(resetbtn);*/
		
		cancelbtn.addActionListener(this);
		submitbtn.addActionListener(this);
		//resetbtn.addActionListener(this);
		
		
		lblmsg=new JLabel();
		lblmsg.setBounds(580,670,200,20);
		fr.add(lblmsg);
		
		lblmsg1=new JLabel();
		lblmsg1.setBounds(1000, 630, 50, 20);
		fr.add(lblmsg1);
		
		
		//fr.add(pan1);
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
		/*else if(e.getSource()==resetbtn)
		{
			//txtdate.setText(null);
			txtslno.setText(null);
			txtfee.setText(null);
			txtpname.setText(null);
			txtpage.setText(null);
			txtpgen.setText(null);
			txtpmob.setText(null);
			txtdsts.setText(null);
			txtbid.setText(null);
			txtprob.setText(null);
			dtype_cb.setSelectedItem("Select");
			
		}*/
		else if(e.getSource()==dtype_cb)
		{
			//data=new String [5][5];
			
			
			String sp=dtype_cb.getSelectedItem().toString();
			Staff_Io sio=new Staff_Io();
			ArrayList al=sio.getAllDoctorsBySp(sp);
			String [][]arr=new String[al.size()][5];
			int i=0;	
			
			for(Object obj : al)
			{
				Doctor d=(Doctor)obj;
				arr[i][0]=d.getdID();
				arr[i][1]=d.getdName();
				arr[i][2]=d.getdScdl();
				arr[i][3]=d.getdMob();
				arr[i][4]=d.getdGen();
				
				//System.out.println(arr[i][0]);
				i++;
			}
			jt=new JTable(arr,field_name);
			fr.add(jt.getTableHeader());
			jt.setBounds(30,240,700,200);
			jt.setBackground(Color.LIGHT_GRAY);
			fr.add(jt);
			fr.show();
			
			ArrayList al1=sio.getDoctorsIdBySp(sp);
			String []array=new String[al1.size()+1];
			int j=1;
			array[0]="select";
			for(Object obj : al1)
			{
				Doctor d=(Doctor)obj;
				array[j]=d.getdID();
				j++;
			}
			id_cb=new JComboBox(array);
			id_cb.setBounds(1000, 150, 120, 20);
			fr.add(id_cb);
			id_cb.addActionListener(this);
			
			fr.show();
		}
		else if(e.getSource()==id_cb)
		{
			//System.out.print("test");
			String id=id_cb.getSelectedItem().toString();
			
		 	Admin_IO a=new Admin_IO();
		 	
		    Doctor dd=a.getDoctorById(id);
		    txtdname.setText(dd.getdName());
		    cds=0;
		   // if(cds<10)
			//{
		    	SimpleDateFormat sdf_input=new SimpleDateFormat("dd-MMM-yyyy");
				try 
				{
				Date d1=sdf_input.parse(txtbkdt.getText());
				String did=id_cb.getSelectedItem().toString();
				Staff_Io sio=new Staff_Io();
				
				 int ds=sio.getNoPatient(did,d1);
				txtdsts.setText(String.valueOf(ds));
				//cds=ds;
			    
				
				} 
				catch (ParseException e1) 
				{
						e1.printStackTrace();
				}
			//}
		    //else
		   // {
		   // 	lblmsg1.setText("Booking Not Available");
		   // }
		 	
		}
		else if(e.getSource()==submitbtn)
		{

		 	String pMob=txtpmob.getText();
			String pName=txtpname.getText();
			String pAge=txtpage.getText();
			String prob=txtprob.getText();
			String bid=txtbid.getText();
			String did=id_cb.getSelectedItem().toString();
			double f=Double.parseDouble(txtfee.getText());
			String pGen="";
			if (radiomale.isSelected())
				pGen="Male";
			else if (radiofemale.isSelected())
				pGen="Female";
			else
			{
				lblmsg.setText("select Gender type");
				return;
			}
			lblmsg.setText("Empty Filed");
			if(pMob.equals("") || pName.equals("") || pAge.equals("")||prob.equals("")||bid.equals("")||pGen.equals("")||f==0.0||did.equals(""))
			{
				lblmsg.setText("Empty Filed");
				return;
			}
			try
			{
			SimpleDateFormat input=new SimpleDateFormat("dd-MMM-yyyy");
			Date cd=input.parse(txtbkdt.getText());
			Date tod=new Date();
			
			Booking bk=new Booking(bid,pName,pAge,pGen,pMob,prob,did,f,cd,tod);
			Staff_Io sio=new Staff_Io();
			if(sio.addBooking(bk))
				lblmsg.setText("Patient Booked");
			else
				lblmsg.setText("Patient not Booked");
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
			
		}
		
		
	}
	
	


	public static void main(String[] args)
	{
		new BookingUI();
	}
}
