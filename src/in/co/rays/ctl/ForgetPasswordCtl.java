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

@WebServlet("/ForgetPasswordCtl")
public class ForgetPasswordCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginId = req.getParameter("loginId");
		if(loginId!= null) {
			userModel model = new userModel();
			try {
				userBean bean = model.findByLogin(loginId);
				req.setAttribute("bean", bean);
				RequestDispatcher rd = req.getRequestDispatcher("ForgetPasswordView.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resp.sendRedirect("ForgetPasswordView.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginId = req.getParameter("loginId");
	    
		userModel model = new userModel();
		
			userBean bean = new userBean();
			bean.setLoginId(loginId);


			try {
				model.update(bean);

				bean = model.findByLogin(bean.getLoginId());

				req.setAttribute("bean", bean);

				RequestDispatcher rd = req.getRequestDispatcher("ForgetPasswordView.jsp");
				rd.forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	}

