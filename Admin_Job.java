package IO;

import Model.*;

public interface Admin_Job 
{
	boolean addOperator(Operator o) ;
	boolean addDoctor(Doctor d);
	boolean Mod_doc(Doctor d);
	boolean ResetPass(String ui, String npwd);
	boolean adminValidation(String id,String pwd);
}
