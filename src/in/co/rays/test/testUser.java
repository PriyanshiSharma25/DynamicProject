package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.userBean;
import in.co.rays.model.userModel;

 public class testUser {
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		testsearch();
	}

		private static void testsearch() throws Exception {
			String dob = "2003-03-25" ;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userBean bean = new userBean();
			//bean.setFirstName("p");
			bean.setDob(sdf.parse(dob));

			userModel model = new userModel();
			List list = model.search(bean, 1, 5);
			Iterator it = list.iterator();
			while (it.hasNext()) {

				bean = (userBean) it.next();
				System.out.print(bean.getId());
				System.out.print("\t" + bean.getFirstName());
				System.out.print("\t" + bean.getLastName());
				System.out.print("\t" + bean.getLoginId());
				System.out.print("\t" + bean.getPassword());
				System.out.println("\t" + bean.getDob());
				System.out.println("\t" + bean.getAddress());

			}
		
	}

	private static void testUpdate() throws Exception {
		userBean bean = new userBean();
		bean.setFirstName("hiiiiii");
		bean.setId(5);
		userModel mdl = new userModel();
		mdl.update(bean);
		
		
	}

	private static void testAdd() throws Exception{
		String dob = "1999-05-29";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		userBean bean = new userBean();
		bean.setId(3);
		bean.setFirstName("hii");
		bean.setLastName("S");
		bean.setLoginId("S@gmail.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("Indore");
		userModel model = new userModel();
		model.add(bean);
	}

}
