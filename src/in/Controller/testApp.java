package in.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.Service.studentService;
import in.studentServiceFactory.stuentServiceFactory;
import studentDto.student;

public class testApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			try {
				System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String option = br.readLine();

			switch (option) {
			case "1":
				insert();
				break;
			case "2":
				search();
				break;
			case "3":
				update();
				break;
			case "4":
				delete();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}

		}
		
	}

	private static void update() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of the student for the update operation");
		int sid=sc.nextInt();
		
		studentService studentService = stuentServiceFactory.getStuentService();
		student std = studentService.searchStudent(sid);
		
		if(std!=null) {
			System.out.println("old name is "+std.getSname()+"enter the new name");
			 String sname=sc.next();
			 
			System.out.println("old name is "+std.getSage()+"enter the new age");
			 Integer sage=sc.nextInt();
			System.out.println("old name is "+std.getSaddress()+"enter the new address");
			 String saddress=sc.nextLine();
			 String msg=studentService.updateStudent(sid, sname, sage, saddress);
				if(msg.equalsIgnoreCase("sucess"))
					System.out.println("Record Updated Sucessfully");
				else
					System.out.println("Failed to update the record");
		}
		else {
			System.out.println("Record not found for this id");
		}
		
		
		
	}

	private static void search() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of the student");
		int sid=sc.nextInt();
		studentService studentService = stuentServiceFactory.getStuentService();
		student std = studentService.searchStudent(sid);
		if(std!=null) {
			
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
		}
		else {
			System.out.println("Record not found for this id");
		}

		

	}
	private static void delete() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id of the student for delete operation");
		int sid=sc.nextInt();
		studentService studentService = stuentServiceFactory.getStuentService();
		String std = studentService.deleteStudent(sid);
		if(std.equals("sucess"))
			System.out.println("Recorded Deleted Sucessfully!");
		else
			System.out.println("Failed");
		
	}

	private static void insert(){
		// TODO Auto-generated method stub
		studentService studentService = stuentServiceFactory.getStuentService();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the student");
		String sname=sc.next();
		System.out.println("Enter the address of the student ");
		String saddress =sc.next();
		System.out.println("Enter the age of the student");
		int sage=sc.nextInt();
		
		String msg = studentService.addStudent(sname, sage, saddress);

		if(msg.equals("sucess"))
			System.out.println("Recorded Inserted Sucessfully!");
		else
			System.out.println("Failed");
	}
	

}
