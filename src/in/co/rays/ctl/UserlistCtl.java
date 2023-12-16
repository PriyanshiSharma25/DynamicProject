package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.userBean;
import in.co.rays.model.userModel;

@WebServlet("/UserListCtl.do")
public class UserlistCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		userModel model = new userModel();
		int pageNo =1 ;
		int pageSize =5;

		try {
			List list = model.search(null, 1, 5);
			List nextList = model.search(null, pageNo + 1 , pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("nextListSize", nextList.size());
			
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String op = req.getParameter("operation");
    int pageNo = Integer.parseInt(req.getParameter("pageNo"));
    int pageSize = 5;
    userBean bean = new userBean();
    userModel model = new userModel();
    if(op.equals("search")) {
    	String firstName = req.getParameter("firstName");
    	bean.setFirstName("firstName");
    }
    if(op.equals("next")) {
    	pageNo++;
    }
    if(op.equals("previous")) {
    	pageNo--;
    }
    if(op.equals("delete")) {
    	pageNo = 1;
    	String[] ids = req.getParameterValues("ids");
    	for(String id :ids) {
    		try {
				model.delete(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }
    if(op.equals("Back")) {
    	RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
    	rd.forward(req, resp);
    }
    try {
		List list = model.search(bean, pageNo, pageSize);
		List nextList = model.search(null, pageNo + 1, pageSize);
		
		req.setAttribute("list", list);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("nextListSize", nextList.size());
		
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	} catch (Exception e) {
		e.printStackTrace();
	}
    
	}

}