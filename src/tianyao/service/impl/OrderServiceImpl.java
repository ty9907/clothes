package tianyao.service.impl;

import java.util.List;

import tianyao.bean.Order;
import tianyao.service.OrderService;
import tianyao.utils.BusinessException;
import tianyao.utils.OrderIO;

public class OrderServiceImpl implements OrderService {

	private OrderIO orderIO=new OrderIO();
	public void buyProduct(Order o) throws BusinessException {
		// TODO Auto-generated method stub
		orderIO.add(o);

	}

	@Override
	public List<Order> list() throws BusinessException {
		// TODO Auto-generated method stub
		
		return orderIO.list();
	}

	@Override
	public Order findById(int orderId) throws BusinessException {
		// TODO Auto-generated method stub
		return orderIO.findByOrderId(orderId);
	}

}
