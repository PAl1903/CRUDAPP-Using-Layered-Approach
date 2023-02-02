package in.Service;
import in.Service.studentService;
import in.persistence.studentDao;
import in.studentDaoFactory.studentDaoFactory;
import in.studentServiceFactory.stuentServiceFactory;
import studentDto.student;
public class studentServiceimpl implements studentService {
	private studentDao stddao;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stddao=studentDaoFactory.getStudentDao();
		
		if(stddao!=null) {
			
		return stddao.addStudent(sname, sage, saddress);
		}
		else {
			return "Failure";
		}
	}

	@Override
	public student searchStudent(Integer sid) {
            stddao=studentDaoFactory.getStudentDao();
		
		if(stddao!=null) {
			
		return stddao.searchStudent(sid);
		}
		else {
			return null;
		}
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
      stddao=studentDaoFactory.getStudentDao();
		
		if(stddao!=null) {
			
		return stddao.updateStudent(sid, sname, sage, saddress);
		}
		else {
			return null;
		}
	}

	@Override
	public String deleteStudent(Integer sid) {
		stddao=studentDaoFactory.getStudentDao();
		
		
		if(stddao!=null) {
			
			return stddao.deleteStudent(sid);
			}
			else {
				return "Failure";
			}
	}

}
