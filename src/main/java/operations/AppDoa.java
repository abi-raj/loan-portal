package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.ApplicationModel;
import models.CountModel;
import models.LoanModel;

public class AppDoa {

	public static void main(String[] args) throws Throwable {
//		ApplicationModel app = new ApplicationModel(1,1,"ABC11",2000,"Education","for ed purpose","pending");
//		applyLoan(app);
		// System.out.println(getApplicationsByStatus("pending").size());;
		getDashCounts();
	}

	public static boolean applyLoan(ApplicationModel app) throws Throwable {
		Class.forName("org.postgresql.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal", "postgres",
					"Test@123");
			String plainQuery = "insert into applications values(default,%d,%d,'%s',%d,'%s','%s','%s')";
			String insertQuery = String.format(plainQuery, app.getPlan_id(), app.getUser_id(), app.getPan(),
					app.getAmount(), app.getLoan_type(), app.getRemarks(), app.getStatus());
			PreparedStatement stmt = con.prepareStatement(insertQuery);
			stmt.executeUpdate();
			return true;
		} catch (Exception exp) {
			System.out.println("application insert : " + exp.getMessage());
		}
		return false;
	}

	public static ArrayList<LoanModel> getApplicationsByStatus(String status) throws ClassNotFoundException {
		ArrayList<LoanModel> apps = new ArrayList<LoanModel>();
		Class.forName("org.postgresql.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal", "postgres",
					"Test@123");
			String plainQuery = "select * from applications inner join users on applications.user_id=users.user_id inner join plan_type on applications.plan_id=plan_type.plan_id ";
			String selectQuery = String.format(plainQuery, status);
			PreparedStatement stmt = con.prepareStatement(selectQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LoanModel loan = new LoanModel(rs.getInt(1), rs.getString(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(10), rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getString(16), rs.getInt(17), rs.getInt(18));
				apps.add(loan);

			}
		} catch (Exception exp) {
			System.out.println("application get : " + exp.getMessage());
		}

		return apps;
	}

	public static CountModel getDashCounts() {
		CountModel count = null;
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LoanPortal", "postgres",
					"Test@123");
			String t_count = "select count(id) from applications";
			String a_count = "select count(id) from applications where status='approved'";
			String p_count = "select count(id) from applications where status='pending'";
			String r_count = "select count(id) from applications where status='rejected'";

			PreparedStatement stmt = con.prepareStatement(t_count);
			ResultSet rs = stmt.executeQuery();
			int t = 0;
			while (rs.next()) {
				t = rs.getInt(1);
			}

			stmt = con.prepareStatement(a_count);
			rs = stmt.executeQuery();
			int a = 0;
			while (rs.next()) {
				a = rs.getInt(1);
			}

			stmt = con.prepareStatement(p_count);
			rs = stmt.executeQuery();
			int p = 0;
			while (rs.next()) {
				p = rs.getInt(1);
			}

			stmt = con.prepareStatement(r_count);
			rs = stmt.executeQuery();
			int r = 0;
			while (rs.next()) {
				r = rs.getInt(1);
			}

			count = new CountModel(t, a, p, r);
		} catch (Exception exp) {
			System.out.println("count exp : " + exp.getMessage());
		}
		return count;
	}
}
