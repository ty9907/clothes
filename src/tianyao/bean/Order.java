package tianyao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tianyao.utils.OrderStatusType;


/**
*order与order是一对多的关系。
*在order里可以找到orderItem。
*order还与user挂钩。即该订单属于哪个用户。
*/
public class Order implements Serializable {

	private int orderId;		
	private List<OrderItem> orderItemList =new ArrayList();
	private String createDate;	//订单生成时间
	private float sum;	//总金额
	private OrderStatusType status =OrderStatusType.UNPAID;	//购买状态
	private int userId;
	public String getCreateDate(){
		return createDate;
	}
	
	public OrderStatusType getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatusType status) {
		this.status=status;
	}
		
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userID) {
		this.userId=userId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId=orderId;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setCreatDate(String date) {
		// TODO Auto-generated method stub
		this.createDate=date;
	}

	public void setSum(float sum) {
		this.sum=sum;
	}

	public float getSum() {
		// TODO Auto-generated method stub
		return sum;
	}
	
	
}	
