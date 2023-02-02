package in.studentServiceFactory;

import in.Service.studentService;
import in.Service.studentServiceimpl;
//abstraction logic of implementation
public class stuentServiceFactory {
	//make constructor private to avoid from object creation
	private stuentServiceFactory() {
		
	}
	private static studentService studentService=null;
	public static studentService getStuentService() {
		if(studentService ==null) {
			studentService=new studentServiceimpl();
		}
		return studentService;
	}
}
