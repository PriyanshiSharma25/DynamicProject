package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.Marksheet_bean;
import in.co.rays.model.Marksheet_Model;

@WebServlet("/StudentCtl")
public class StudentCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = 0;
		String name = req.getParameter("name");
	    String Id = req.getParameter(Integer.toString(id));
	    Marksheet_Model model = new Marksheet_Model();
	    try {
			Marksheet_bean bean = model.Authenticate(id, name);
			HttpSession session = req.getSession();
		    session.setAttribute("student", bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
