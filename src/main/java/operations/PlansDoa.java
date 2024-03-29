package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.PlanType;

public class PlansDoa {
//	public static void main(String[] args) throws ClassNotFoundException {
//		PlanType plan = new PlanType("Type 1",6,5,10);
//		plan.setPlan_id(1);
//		editPlan(plan);
//		
//		
//	}
	
public static boolean createPlan(PlanType plan) throws ClassNotFoundException {
	

		try {
			 Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
			String plainQuery = "insert into plan_type values(default,'%s',%d,%d,%d)";
			String insertQuery = String.format(plainQuery,plan.getName(),plan.getDuration(),plan.getRate(),plan.getPenalty());
			PreparedStatement stmt = con.prepareStatement(insertQuery);
			stmt.executeUpdate();
			return true;
			}
		catch(Exception exp) {
			System.out.println("create plans: "+exp.getMessage());
		}
	return false;
	
}
public static boolean editPlan(PlanType plan) throws ClassNotFoundException {
	 Class.forName("org.postgresql.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
			String plainQuery = "update plan_type set name='%s',duration=%d,rate=%d,penalty=%d where plan_id=%d ";
			String updateQuery = String.format(plainQuery,plan.getName(),plan.getDuration(),plan.getRate(),plan.getPenalty(),plan.getPlan_id());
			PreparedStatement stmt = con.prepareStatement(updateQuery);
			stmt.executeUpdate();
			return true;
		}
		catch(Exception exp) {
			System.out.println("edit plans: "+exp.getMessage());
		}
	return false;
}
public static ArrayList<PlanType> getAllPlans(){
	
	ArrayList<PlanType> plans = new ArrayList<PlanType>();
	try {
		 Class.forName("org.postgresql.Driver");
		 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal","postgres","Test@123");
		 String selectQuery = "select * from plan_type ";
		 PreparedStatement stmt = con.prepareStatement(selectQuery);
		 ResultSet rs = stmt.executeQuery();
		 
		 while(rs.next()) {
			 PlanType plan = new PlanType(rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getInt(5));
			 plan.setPlan_id(rs.getInt(1));
			 plans.add(plan);
		 }
	}catch(Exception exp) {
		System.out.println("get plans: "+exp.getMessage());
	}
	return plans;
	
}
	
}
