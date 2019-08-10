package tianyao.service;

import java.util.List;

import tianyao.bean.Order;
import tianyao.utils.BusinessException;

public interface OrderService {

	public void buyProduct(Order o)throws BusinessException;
	public List<Order> list()throws BusinessException;
	public Order findById(int orderId)throws BusinessException;
}
