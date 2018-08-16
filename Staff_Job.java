package IO;

import Model.Booking;

public interface Staff_Job 
{
	boolean staffValidation(String id,String pwd);
	boolean addPatient(Booking o) ;
	boolean addChange_pass(String sid, String spwd) ;
}
