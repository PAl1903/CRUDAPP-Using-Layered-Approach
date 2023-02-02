package in.persistence;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.persistence.studentDao;
import in.util.JdbcUtil;
import studentDto.student;
public class studentDaoimpl implements studentDao{
	Connection connection =null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	student std=null;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		 String insertquery="insert into students(`sname`,`sage`,`saddress`) values(?,?,?)";
		try {
				connection =JdbcUtil.getJdbcConnection();
				if(connection!=null) {
					pstmt=connection.prepareStatement(insertquery);
				}
				
				if(pstmt!=null) {
					

					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3,saddress);
					int rowaffected=pstmt.executeUpdate();
					if(rowaffected ==1) {
						return "sucess";
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "failure";
	}

	@Override
	public student searchStudent(Integer sid) {
		student std=new student();
		 String selectQuery="select sid,sname,sage,saddress from students where sid=?";
			try {
					connection =JdbcUtil.getJdbcConnection();
					if(connection!=null) {
						pstmt=connection.prepareStatement(selectQuery);
					}
					
					if(pstmt!=null) {
						
						pstmt.setInt(1, sid);
					}
					if(pstmt!=null) {
						resultSet = pstmt.executeQuery();
						
						//we cannot send resultset object to another layer because it does not implement serializable
					}
					if(resultSet!=null) {
						if(resultSet.next()) {
							std.setSid(resultSet.getInt("sid"));
							std.setSname(resultSet.getString("sname"));
							std.setSage(resultSet.getInt("sage"));
							std.setSaddress(resultSet.getString("saddress"));
						}
						else {
							return null;
						}
						
					}
					else {
						return null;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return std;
		}

	

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		
		String sqlupdatequery="update students set sname=?,sage=?,saddress = ? where sid = ?";
			try {
					connection =JdbcUtil.getJdbcConnection();
					if(connection!=null) {
						pstmt=connection.prepareStatement(sqlupdatequery);
					}
					
					if(pstmt!=null) {
						

						pstmt.setString(1, sname);
						pstmt.setInt(2, sage);
						pstmt.setString(3,saddress);
						pstmt.setInt(4, sid);
						int rowaffected=pstmt.executeUpdate();
						if(rowaffected ==1) {
							return "sucess";
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "failure";
	}

	@Override
	public String deleteStudent(Integer sid) {
		String deleteQuery="delete from students where sid=?";
			try {
				connection=JdbcUtil.getJdbcConnection();
				if(connection!=null) {
					pstmt=connection.prepareStatement(deleteQuery);
				}
				if(pstmt!=null) {
					pstmt.setInt(1, sid);
				}
				if(pstmt!=null) {
					int rowaffected=pstmt.executeUpdate();
					if(rowaffected==1)return "sucess";
					else return "No record found";
				}
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "failure";
	}
	
}
