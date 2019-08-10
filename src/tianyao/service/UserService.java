package tianyao.service;

import tianyao.bean.User;
import tianyao.utils.BusinessException;

public interface UserService {
	

		public  User register(User user)throws BusinessException;
	 
		public User login(String username,String password)
				throws BusinessException;
}
