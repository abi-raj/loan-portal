package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import models.ApplicationModel;

public class AppDoa {

	public static boolean applyLoan(ApplicationModel app) throws Throwable {
		 Class.forName("org.postgresql.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
				String plainQuery = "insert into applications values(deafult,%d,%d,'%s',%d,'%s','%s','%s')";
				String insertQuery = String.format(plainQuery,app.getPlan_id(),app.getUser_id(),app.getPan(),app.getAmount(),app.getLoan_type(),app.getRemarks(),app.getStatus());
				PreparedStatement stmt = con.prepareStatement(insertQuery);
				stmt.executeUpdate();
				return true;
			}catch(Exception exp) {
				System.out.println("application insert : "+exp.getMessage());
			}
			return false;
	}
	public static ArrayList<ApplicationModel> getAllApplications(String type) throws ClassNotFoundException{
		ArrayList<ApplicationModel> apps = new ArrayList<ApplicationModel>();
		 Class.forName("org.postgresql.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
				String plainQuery = "select * from applications where ";
				
				}
			catch(Exception exp) {
					System.out.println("application get : "+exp.getMessage());
				}
		
		return apps;
	}
}
