package in.Service;

import studentDto.student;

public interface studentService {
	public String addStudent(String sname,Integer sage,String saddress);
	public student searchStudent(Integer sid);
	public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
	public String deleteStudent(Integer sid);
	
}
