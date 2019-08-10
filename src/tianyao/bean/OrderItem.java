package tianyao.bean;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private int itemId; 	//购买明细
	private Clothes clothes;	//商品
	private int shoppingNum;	//购买数量
	private float sum;	//购买总金额
	
	public int getItemId() { 
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId=itemId;
	}
	
	public Clothes getClothes() {
		return clothes; 
	}
	
	public void setClothes(Clothes clothes) {
		this.clothes=clothes;
	}
	
	public int getShoppingNum() {
		return shoppingNum;
	}
	
	public void setShoppingNum(int shoppingNum) {
		this.shoppingNum=shoppingNum;
	}
	
	public float getSum() {
		return sum;
	}
	
	public void setSum(float sum) {
		this.sum=sum;
	}
}
