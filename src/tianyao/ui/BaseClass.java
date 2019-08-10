package tianyao.ui;

import java.util.ResourceBundle;
import java.util.Scanner;
import tianyao.bean.User;

public abstract class BaseClass {
	
	protected static Scanner input=new Scanner(System.in);
	protected static User currUser;		//当前用户对象；
	private static ResourceBundle r=
			ResourceBundle.getBundle("tianyao.res.r");
	
	public static String getString(String key) {
		return r.getString(key);
	}
	
	public static void println(String s) {
		System.out.println(s);
	}
}
