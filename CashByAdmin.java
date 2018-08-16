package UI;

import java.awt.event.*;

import javax.swing.*;

public class CashByAdmin implements ActionListener
{
	JFrame fr;
	JLabel lbloper,lbldate,lblcash;
	JTextField txtdate,txtcash;
	JButton alloperbtn,submitbtn;
	JComboBox atype_cb;
	JComboBox oper_cb;
	String aty[]={"Select","1001","1002","1003","1004"};
	public CashByAdmin()
	{
		fr=new JFrame("Ad_TotalCash");	
		fr.setBounds(0,0,600,600);
		
		lbloper=new JLabel("Operator");
		lbloper.setBounds(20,10,80,20);
		fr.add(lbloper);
		
		 oper_cb=new JComboBox(aty);
		  oper_cb.setBounds(100,10,100,20);
		  fr.add(oper_cb);
		  
		    lbldate=new JLabel("Date");
			lbldate.setBounds(20,50,80,20);
			fr.add(lbldate);
			
			/*txtdate=new JTextField(20);
			txtdate.setBounds(100,50,100,20);
			fr.add(txtdate);*/

			
			lblcash=new JLabel("Total Cash");
			lblcash.setBounds(20,90,80,20);
			fr.add(lblcash);
			
			txtcash=new JTextField();
			txtcash.setBounds(100,90,100,20);
			fr.add(txtcash);
			
			
			  alloperbtn= new JButton("ALL_OP");
			  alloperbtn.setBounds(240,10,80,20);
			  fr.add(alloperbtn);
			  
			  //alloperbtn.addActionListener(this);
			  /*try
				{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				df.setLenient(false);  
				System.out.println(df.format(cal.getTime()));
				String date=df.format(cal.getTime());


				/*temp=new JLabel(dd1);
				temp.setBounds(750,35,80,20);
				add(temp);


				}
				catch (Exception e)
					{
					e.printStackTrace();
					}*/
			  submitbtn=new JButton("Back");
				submitbtn.setBounds(100,400,150,50);
				fr.add(submitbtn);
					
				
				
				submitbtn.addActionListener(this);
			 

			  fr.setLayout(null);
			  fr.show();
	}
	 public static void main(String args[])
	 {
		 new CashByAdmin();
	 }
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==submitbtn)
		{
		 AdminUI.main(new String[]{});
			fr.dispose();
		}
		
	}

}
