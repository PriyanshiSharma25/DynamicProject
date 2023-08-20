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
			 //bean.setName("a");
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
				

			}
		
	}

	private static void testUpdate() {
		
		
	}

	private static void testAdd() throws Exception{
		String dob = "1999-05-29";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		userBean bean = new userBean();
		bean.setId(3);
		bean.setFirstName("Sunayna");
		bean.setLastName("Sahu");
		bean.setLoginId("SunaynaSahu100@gmail.com");
		bean.setPassword("87654321");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("Indore");
		userModel model = new userModel();
		model.add(bean);
	}

}
