package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Model.*;
public class Admin_IO implements Admin_Job
{

	FileInputStream fin;
	FileOutputStream fout;
	ObjectInputStream ooin;
	ObjectOutputStream oout;
	ArrayList al,al1;
	public boolean addOperator(Operator o)
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
				if(oper.getUID().equals(o.getUID()))
					return false;
			}
			al.add(o);
			fout=new FileOutputStream("operator.dat");
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
	public boolean addDoctor(Doctor d)
	{
		al=new ArrayList();
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
			}
			for(Object obj: al)
			{
				Doctor doc=(Doctor)obj;
				if(doc.getdID().equals(d.getdID()))
					return false;
			}
			al.add(d);
			fout=new FileOutputStream("doctor.dat");
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
	
	public Doctor getDoctorById(String id)
	{
		al=new ArrayList();
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
			}
			for(Object obj: al)
			{
				Doctor doc=(Doctor)obj;
				
				if(doc.getdID().equals(id))
					return doc;
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
			
		}
		
	}
	public String [] getDoctorIds()
	{
		String []dids;
		al=new ArrayList();
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
			}
			dids=new String[al.size()+1];
			dids[0]="select";
			int i=1;
			for(Object obj: al)
			{
				Doctor doc=(Doctor)obj;
				dids[i++]=doc.getdID();
			}
			return dids;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	public boolean adminValidation(String id,String pwd)
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
	public boolean ResetPass(String ui, String npwd)
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
				if(oper.getUID().equals(ui))
				{
					oper.setPWD(npwd);
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
	public boolean Mod_doc(Doctor d) 
	{
		
		return false;
	}
	
}
