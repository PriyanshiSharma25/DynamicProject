package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.userBean;
import in.co.rays.model.userModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("UserRegistration.jsp");
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    	String op = req.getParameter("Operations");
        if(op.equals("SignUp")) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    	userBean bean = new userBean();
    	bean.setFirstName(req.getParameter("firstName"));
    	bean.setLastName( req.getParameter("lastName"));
    	bean.setLoginId(req.getParameter("loginId"));
    	bean.setPassword(req.getParameter("password"));
    	try {
			bean.setDob(sdf.parse(req.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	bean.setAddress(req.getParameter("address"));
    	
    	userModel model = new userModel();
    	try {
         bean = model.findByLogin("loginId");   
    		if (bean != null) {

				req.setAttribute("msg", "User Already exist");

			} else {

				model.add(bean);

				req.setAttribute("msg", "User Register Successfully...!!!");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

    	
    	
    	RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
    	rd.forward(req, resp);
        }
    	if(op.equals("Reset")) {
    		resp.sendRedirect("UserRegistration.jsp");
    	}
    }
}
