package tianyao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tianyao.utils.OrderStatusType;


/**
*order��order��һ�Զ�Ĺ�ϵ��
*��order������ҵ�orderItem��
*order����user�ҹ������ö��������ĸ��û���
*/
public class Order implements Serializable {

	private int orderId;		
	private List<OrderItem> orderItemList =new ArrayList();
	private String createDate;	//��������ʱ��
	private float sum;	//�ܽ��
	private OrderStatusType status =OrderStatusType.UNPAID;	//����״̬
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
