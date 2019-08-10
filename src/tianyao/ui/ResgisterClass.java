package tianyao.ui;

import tianyao.bean.User;
import tianyao.service.UserService;
import tianyao.service.impl.UserServiceImpl;
import tianyao.utils.BusinessException;

public class ResgisterClass extends BaseClass {

	public void register() throws BusinessException {
		println(getString("input.username"));
		String username = input.nextLine();
		println(getString("input.password"));
		String password = input.nextLine();
		User user=new User(username,password); 
		UserService userService=new UserServiceImpl();
		userService.register(user);
		
	}
}

