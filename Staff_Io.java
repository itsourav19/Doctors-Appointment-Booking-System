package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import Model.Booking;
import Model.Doctor;
import Model.Operator;

public class Staff_Io 
{
	FileInputStream fin;
	FileOutputStream fout;
	ObjectInputStream ooin;
	ObjectOutputStream oout;
	ArrayList al,al1;
	public boolean Change_Pass(String sid, String spwd)
	{
        al=new ArrayList();
		
		try
		{
			File f=new File("operator.dat");
			if(f.exists())
			{
				fin=new FileInputStream("operator.dat");
				ooin=new ObjectInputStream(fin);
				al=(ArrayList)ooin.readObject();
				fin.close();
				ooin.close();
			}
			boolean flag=false;
			for(Object obj: al)
			{
				Operator oper=(Operator)obj;
				if(oper.getUID().equals(sid))
				{
					oper.setPWD(spwd);
					flag=true;
				}
			}
			if(flag==true)
			{
			
			fout=new FileOutputStream("operator.dat");
			oout=new ObjectOutputStream(fout);
			oout.writeObject(al);
			fout.close();
			oout.close();
			return true;
			}
			else
				return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}	
	public ArrayList getAllDoctorsBySp(String sp)
	{
		
		 al=new ArrayList();
			ArrayList temp=new ArrayList();
			try
			{
				File f=new File("doctor.dat");
				if(f.exists())
				{
					fin=new FileInputStream("doctor.dat");
					ooin=new ObjectInputStream(fin);
					al=(ArrayList)ooin.readObject();
					fin.close();
					ooin.close();
					
					for(Object obj: al)
					{
						Doctor oper=(Doctor)obj;
						if(oper.getdSpcl().equals(sp))
							temp.add(oper);
					}
				}
				
				
				
				return temp;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return temp;
	}
	public ArrayList getDoctorsIdBySp(String sp)
	{
		
		 al=new ArrayList();
			ArrayList temp=new ArrayList();
			try
			{
				File f=new File("doctor.dat");
				if(f.exists())
				{
					fin=new FileInputStream("doctor.dat");
					ooin=new ObjectInputStream(fin);
					al=(ArrayList)ooin.readObject();
					fin.close();
					ooin.close();
					
					for(Object obj: al)
					{
						Doctor oper=(Doctor)obj;
						if(oper.getdSpcl().equals(sp))
							temp.add(oper);
					}
					//System.out.println(temp.size());
				}
				
				
				
				return temp;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return temp;
	}
	public boolean addBooking(Booking b)
	{
		al=new ArrayList();
		try
		{
			File f=new File("booking.dat");
			if(f.exists())
			{
				fin=new FileInputStream("booking.dat");
				ooin=new ObjectInputStream(fin);
				al=(ArrayList)ooin.readObject();
				fin.close();
				ooin.close();
			}
			for(Object obj: al)
			{
				Booking book=(Booking)obj;
				if(book.getdID().equals(b.getdID()))
					return false;
			}
			al.add(b);
			fout=new FileOutputStream("booking.dat");
			oout=new ObjectOutputStream(fout);
			oout.writeObject(al);
			fout.close();
			oout.close();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public int getNoPatient(String did,Date d1)
	{
		int count=0;
		
		al=new ArrayList();
		try
		{
			File f=new File("booking.dat");
			if(f.exists())
			{
				fin=new FileInputStream("booking.dat");
				ooin=new ObjectInputStream(fin);
				al=(ArrayList)ooin.readObject();
				fin.close();
				ooin.close();
			}
	
		for(Object obj: al)
		{
			Booking temp=(Booking)obj;
			if(temp.getdID().equals(did))
			{
				if(temp.getbDate().getDay()==d1.getDay()&&temp.getbDate().getMonth()==d1.getMonth()&&temp.getbDate().getYear()==d1.getYear())
				{
					count++;	
				}
				
			}
			
		}
		return count;
		
		
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	public boolean staffValidation(String id,String pwd)
	{
		al=new ArrayList();
		try
		{
			File f=new File("operator.dat");
			if(f.exists())
			{
				fin=new FileInputStream("operator.dat");
				ooin=new ObjectInputStream(fin);
				al=(ArrayList)ooin.readObject();
				fin.close();
				ooin.close();
			}
			for(Object obj: al)
			{
				Operator oper=(Operator)obj;
				if(id.equals(oper.getUID()) && pwd.equals(oper.getPWD()))
					return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
