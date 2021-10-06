package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.UserModel;
public class UserDoa {

//	public static void main(String[] args) throws Throwable {
//		/*
//		 * UserModel user= new UserModel("abiraj","abiraj@gmail.com",19,87,"12345");
//		 * registerUser(user);
//		 */
//System.out.println(checkUserLogin("abi@gmail.com", "12345"));
//	}
	public static boolean registerUser(UserModel user) throws ClassNotFoundException {
		 Class.forName("org.postgresql.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
			String plainQuery ="insert into users values(default,'%s','%s',%d,%d,'%s')";
			String insertQuery = String.format(plainQuery,user.getName(),user.getEmail(),user.getAge(),user.getPhone(),user.getPassword());
			PreparedStatement stmt = con.prepareStatement(insertQuery);
			stmt.executeUpdate();
			return true;
		}catch(Exception excep) {
			System.out.println("Exception in Register user : "+excep.getMessage());
		}
		return false;
	}
public static UserModel checkUserLogin(String email,String password) throws ClassNotFoundException {
	Class.forName("org.postgresql.Driver");
	UserModel user=null ;
	try {
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
		String plainQuery ="select * from users where email='%s' and password='%s'";
		String checkQuery = String.format(plainQuery, email,password);
		PreparedStatement stmt = con.prepareStatement(checkQuery);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			user = new UserModel(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
			user.setUser_id(rs.getInt(1));
			
			System.out.println(user.getUser_id());
		}
		
	}catch(Exception exp) {
		System.out.println("Exception in Login user : "+exp.getMessage());	
	}
	return user;
}
}
