package Model;

import java.io.Serializable;

public class Doctor implements Serializable 
{
	private String dID;
	private String dName;
	private String dSpcl;
	private String dMob;
	private String dScdl;
	private String dGen;
	public Doctor(String id, String n,String m,String spcl,String scdl,String gen)
	{
		dID=id;dName=n;dSpcl=spcl;dMob=m;dScdl=scdl;dGen=gen;
	}
	/*public Doctor(String dmob2, String ty1) {
		dMob=dmob2;dScdl=ty1;
	}*/
	public String getdID()
	{
		return dID;
	}
	public String getdName()
	{
		return dName;
	}
	public String getdMob()
	{
		return dMob;
	}
	public String getdSpcl()
	{
		return dSpcl;
	}
	public String getdScdl()
	{
		return dScdl;
	}
	public String getdGen()
	{
		return dGen;
	}
	public void setdMob(String mob)
	{
		dMob=mob;
		
	}
	public void setdScdl(String nScdl)
	{
		dScdl=nScdl;
		
	}
	
}
