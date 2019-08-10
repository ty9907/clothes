package tianyao.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import tianyao.bean.Order;

public class OrderIO {

	private static List<Order> orders=new ArrayList();
	private static final String ORDER_FILE="order.obj";
	
	public void add(Order order)throws BusinessException{
		orders.add(order);
	}
	
	public List<Order> list() throws BusinessException{
		return orders;
	}
	
	public Order findByOrderId(int orderId)throws BusinessException{
		Order order=null;
		int oid;
		for(Order o:orders) {
			oid=o.getOrderId();
			if(oid==orderId) {
				order =o;
				break;
			}
		}
		return order;
	}
	
	public boolean writeOrders() {
		try {
			ObjectOutputStream out =new ObjectOutputStream(
					new FileOutputStream(ORDER_FILE));
			out.writeObject(orders);
			out.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean readOrders() {
		try {
			ObjectInputStream in =new ObjectInputStream(new FileInputStream(ORDER_FILE));
			orders =(List<Order>) in.readObject();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
