package Model;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable
{
	private String bID;//
	private Date bDate;
	private Date vDate;
	private String bSts;//
	private String report;
	private double fee;//
	private String dID;//
	private String prob;//
	private String slno;//
	private String pName;
	private String pMob;//
	private String pAge;//
	private String pGen;//
	/*public Booking(String bi,Date bD,String bS, String r,double f,String di,String p,String s, String exp,String n,String m,String age,String g)
	{
		bID=bi;bDate=bD;bSts=bS;report=r;fee=f;dID=di;prob=p;slno=s;pName=n;pMob=m;pAge=age;pGen=g;
	}
	public Booking(String bi,String bS,double f,String di,String s,String n,String m,String age,String p,String g)
	{
		bID=bi;bSts=bS;fee=f;dID=di;slno=s;pName=n;pMob=m;pAge=age;pGen=g;prob=p;
	}*/
	public Booking(String bid,String n,String age,String g,String m,String p,String did,double f,Date bd1,Date vd1)
	{
		bID=bid;pName=n;pMob=m;pAge=age;pGen=g;prob=p;dID=did;fee=f;bDate=bd1;vDate=vd1;
	}
	public Booking(Date d,String did)
	{
		dID=did;bDate=d;
	}
	public String getbID()
	{
		return bID;
	}
	public Date getbDate()
	{
		return bDate;
	}
	public Date getvDate()
	{
		return vDate;
	}
	public String getbSts()
	{
		return bSts;
	}
	public String getReport()
	{
		return report;
	}
	
	public double getfee()
	{
		return fee;
	}
	public String getdID()
	{
		return dID;
	}
	public String getprob()
	{
		return prob;
	}
	public String getslno()
	{
		return slno;
	}
	
	public String getpName()
	{
		return pName;
	}
	
	public String getpMob()
	{
		return pMob;
	}
	public String getpAge()
	{
		return pAge;
	}
	public String getpGen()
	{
		return pGen;
	}
	public void setbSts(String nbsts)
	{
		bSts=nbsts;
	}
	public void setreport(String nreport)
	{
		report=nreport;
	}
}
