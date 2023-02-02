package in.persistence;
import studentDto.student;
public interface studentDao {
	//Database Access Layer
	public String addStudent(String sname,Integer sage,String saddress);
	public student searchStudent(Integer sid);
	public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
	public String deleteStudent(Integer sid);
}
