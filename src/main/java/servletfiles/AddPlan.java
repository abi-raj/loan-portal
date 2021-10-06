package servletfiles;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import operations.PlansDoa;
import jakarta.servlet.annotation.WebServlet;
import models.PlanType;

/**
 * Servlet implementation class AddPlan
 */
@WebServlet("/AddPlan")
public class AddPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlan() {
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int duration = Integer.parseInt(request.getParameter("duration"));
		int interest =Integer.parseInt(request.getParameter("interest"));
		int penalty = Integer.parseInt(request.getParameter("penalty"));
		PlanType plan = new PlanType(name,duration,interest,penalty );
		try {
			if(PlansDoa.createPlan(plan)) {
				response.getWriter().print("success");
			}else {
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
