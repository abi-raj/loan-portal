package servletfiles;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ApplicationModel;
import operations.AppDoa;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ApplyLoan")
public class ApplyLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplyLoan() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int user_id = 1;
		int plan_id = Integer.parseInt(request.getParameter("plan"));
		String loan_type = request.getParameter("loan");
		String pan = request.getParameter("pan");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String remarks = request.getParameter("remarks");

		ApplicationModel appModel = new ApplicationModel(plan_id, user_id, pan, amount, loan_type, remarks, "pending");

		try {
			if (AppDoa.applyLoan(appModel)) {
				response.sendRedirect("customer.jsp");
			} else {
				response.sendRedirect("applyLoan.jsp");
			}
		} catch (Throwable ex) {
			System.out.println("ex " + ex.getMessage());
		}

	}

}
