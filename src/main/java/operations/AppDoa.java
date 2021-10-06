package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.ApplicationModel;

public class AppDoa {

	
	public static void main(String[] args) throws Throwable {
//		ApplicationModel app = new ApplicationModel(1,1,"ABC11",2000,"Education","for ed purpose","pending");
//		applyLoan(app);
	getApplicationsByStatus("pending");
	}
	public static boolean applyLoan(ApplicationModel app) throws Throwable {
		 Class.forName("org.postgresql.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
				String plainQuery = "insert into applications values(default,%d,%d,'%s',%d,'%s','%s','%s')";
				String insertQuery = String.format(plainQuery,app.getPlan_id(),app.getUser_id(),app.getPan(),app.getAmount(),app.getLoan_type(),app.getRemarks(),app.getStatus());
				PreparedStatement stmt = con.prepareStatement(insertQuery);
				stmt.executeUpdate();
				return true;
			}catch(Exception exp) {
				System.out.println("application insert : "+exp.getMessage());
			}
			return false;
	}
	public static ArrayList<ApplicationModel> getApplicationsByStatus(String status) throws ClassNotFoundException{
		ArrayList<ApplicationModel> apps = new ArrayList<ApplicationModel>();
		 Class.forName("org.postgresql.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
				String plainQuery = "select * from applications inner join users on applications.user_id=users.user_id inner join plan_type on applications.plan_id=plan_type.plan_id ";
				String selectQuery = String.format(plainQuery, status);
				PreparedStatement stmt = con.prepareStatement(selectQuery);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
System.out.println("size : "+rs.getString(4));
				}
				}
			catch(Exception exp) {
					System.out.println("application get : "+exp.getMessage());
				}
		
		return apps;
	}
}
