package in.studentDaoFactory;

import in.persistence.studentDao;
import in.persistence.studentDaoimpl;

public class studentDaoFactory {
	private studentDaoFactory() {
		
	}
	 static studentDao StudentDao=null;
	
	public static studentDao getStudentDao() {
		if(StudentDao ==null) {
			StudentDao=new studentDaoimpl();	
		}
		
		return StudentDao;
		
	}
}
