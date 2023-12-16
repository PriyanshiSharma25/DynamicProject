package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.userBean;
import in.co.rays.model.userModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");

		if (op != null) {

			HttpSession session = req.getSession();

			session.invalidate();

		}
		resp.sendRedirect("loginView.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");

		if (op.equals("SignIn")) {

			String loginId = req.getParameter("loginId");
			String password = req.getParameter("password");
			String uri = req.getParameter("uri");

			userModel model = new userModel();

			try {
				userBean bean = model.authenticate(loginId, password);

				if (bean != null) {
					
					HttpSession session = req.getSession();
					session.setAttribute("user", bean);
					
					if(uri.equalsIgnoreCase("null")) {
					resp.sendRedirect("WelcomeCtl");
				} else {
					resp.sendRedirect(uri);
				}

					req.setAttribute("msg", "uh oh..Login & Password is invalid...!!"  );

					RequestDispatcher rd = req.getRequestDispatcher("loginView.jsp");

					rd.forward(req, resp);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals("SignUp")) {

			resp.sendRedirect("UserCtl");

	}
		if(op.equals("ForgetPassword")) {
			RequestDispatcher rd = req.getRequestDispatcher("ForgetPasswordCtl");
			rd.forward(req, resp);
			
		}

	}
}
