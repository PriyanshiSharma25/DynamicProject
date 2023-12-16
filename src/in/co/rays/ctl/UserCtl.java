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
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");

		if (id != null) {

			userModel model = new userModel();

			try {
				userBean bean = model.findByPk(Integer.parseInt(id));

				req.setAttribute("bean", bean);

				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			resp.sendRedirect("UserRegistration.jsp"); 
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               
		String op = req.getParameter("operation");

		String id = req.getParameter("id");
		System.out.println("id===================" + id);
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (op.equals("SignUp")) {

			userBean bean = null;

			userModel model = new userModel();

			try {
				bean = model.findByLogin(loginId);

				if (bean != null) {

					req.setAttribute("msg", "User Already exist");

				} else {

					bean = new userBean();

					bean.setFirstName(firstName);
					bean.setLastName(lastName);
					bean.setLoginId(loginId);
					bean.setPassword(password);
					bean.setDob(sdf.parse(dob));
					bean.setAddress(address);

					model.add(bean);

					req.setAttribute("msg", "User Register Successfully...!!!");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");

			rd.forward(req, resp);
		}

		if (op.equals("Reset")) {

			resp.sendRedirect("UserRegistration.jsp");

		}

		if (op.equals("List")) {
			resp.sendRedirect("UserListCtl.do");
		}

		if (op.equals("Update")) {

			userBean bean = new userBean();
			bean.setId(Integer.parseInt(id));
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassword(password);
			try {
				bean.setDob(sdf.parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			bean.setAddress(address);

			userModel model = new userModel();

			try {
				model.update(bean);

				bean = model.findByPk(bean.getId());

				req.setAttribute("bean", bean);

				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}