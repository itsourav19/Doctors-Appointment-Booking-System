package Model;

import java.io.Serializable;

public class Operator implements Serializable
{
	 private String name;
	 private String uid;
	 private String pwd;
	 private String atype;
	 private String mob;
	
	 public Operator(String n,String u,String p,String t,String m)
	 {
		 name=n;uid=u;pwd=p;atype=t;mob=m;
	 }
	 public String getName()
	 {
		 return name;
	 }
	 public String getUID()
	 {
		 return uid;
	 }
	 public String getPWD()
	 {
		 return pwd;
	 }
	 public String getMobileNo()
	 {
		 return mob;
	 }
	 
	 public void setPWD(String npwd)
	 {
		 pwd=npwd;
	 }
	 public void setMobileNo(String newmob)
	 {
		 mob=newmob;
	 }

}
