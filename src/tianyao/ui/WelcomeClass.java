package tianyao.ui;

import tianyao.utils.BusinessException;
import tianyao.utils.UserIO;

public class WelcomeClass extends BaseClass {

		public void start() {
		println(getString("info.welcome"));
		UserIO userIO=new UserIO();
		boolean flag =true;
		while(flag) {
			println(getString("info.login.reg"));
			println(getString("info.select"));
			String select =input.nextLine();
			
			switch(select) {
			case "1":
				
				try {
					new LoginClass().login();
					println(getString("login.success"));
					flag=false;
				} catch (BusinessException e) {
					println(getString(e.getMessage()));
				}
				break;
			case "2": 
			
				try {
					new ResgisterClass().register();
					println(getString("reg.success"));
					flag =false;
				}catch (BusinessException e) {
					println(getString("reg.error"));
				}
				
				
				break;
			default:
				println(getString("input.error"));
				break;
							
			}
		}
		
		//登录完成后显示商品界面。
		HomeClass homeClass=new HomeClass();
		homeClass.show();
	}
}
