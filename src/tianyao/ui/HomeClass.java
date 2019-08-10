package tianyao.ui;

import java.util.Date;
import java.util.List;

import tianyao.bean.Clothes;
import tianyao.bean.Order;
import tianyao.bean.OrderItem;
import tianyao.service.ClothesService;
import tianyao.service.OrderService;
import tianyao.service.impl.ClothesServiceImpl;
import tianyao.service.impl.OrderServiceImpl;
import tianyao.utils.BusinessException;
import tianyao.utils.ConsoleTable;
import tianyao.utils.DateUtils;
import tianyao.utils.OrderIO;



/**���˵�
 * ��ʾ��Ʒ���棻
 * @author ty
 *
 */
public class HomeClass extends BaseClass {


	private OrderService orderSevice=new OrderServiceImpl();
	private ClothesService clothesService=new ClothesServiceImpl();
	
	public void show() {
		showProducts();
		println("welcome"+currUser.getUsername());
		menu();
		
		
	}
	
	private void menu() {
		// TODO Auto-generated method stub
		boolean flag=true;
		while(flag) {
			println(getString("home.function"));
			println(getString("info.select"));
			String select=input.nextLine();
			switch(select) {
			
			//��ѯȫ������
			case "1":
				findOrderList();
				flag=false;
				break;
			//���Ҷ���
			case "2":
				findOrderById();
				flag=false;
				break;
			//����
			case "3":
				try {
					buyProducts();
					flag=false;
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					println(e.getMessage());
				}
				break;
			//�˳�
			case "4":
				show();
				break;
				//��ʾ��Ʒ
			case "0":
				flag=false;
				System.exit(0);
				break;
			default:
				println(getString("input.error"));
				break;
			}
		}
	}

	//������Ʒ
	private void buyProducts() throws BusinessException{
		// ���ɶ���
		boolean flag=true;
		int count =1;		//�������
		float sum=0.0f;	//�ܽ��
		Order order =new Order();
		while(flag) {
			println(getString("product.input.id"));
			String id=input.nextLine();
			println(getString("product.input.shoppingNum"));
			String shoppingNum=input.nextLine();
			OrderItem orderItem=new OrderItem();
			Clothes clothes=clothesService.findById(id);
			int num=Integer.parseInt(shoppingNum);
			
			//�ж��û������Ƿ���ڿ��
			if(num>clothes.getNum()) {
				throw new BusinessException("produce.num.error");
			}
			
			//һ��������ϸ
			clothes.setNum(clothes.getNum()-num);		//��ȥ���
			orderItem.setClothes(clothes);
			orderItem.setShoppingNum(num);
			orderItem.setSum(clothes.getPrice()*num);
			sum +=orderItem.getSum();
			orderItem.setItemId(count++);
			
			order.getOrderItemList().add(orderItem);
			
			println(getString("product.buy.continue"));
			String isBuy=input.nextLine();
			switch (isBuy) {
			case "1":
				flag=true;
				break;
			case "2":
				flag=false;
				break;
			default:
				flag=false;
				break;
			}
		}
		
		order.setCreatDate(DateUtils.toDate(new Date()));
		order.setUserId(currUser.getId());
		order.setSum(sum);
		order.setOrderId(orderSevice.list().size()+1);
		orderSevice.buyProduct(order);
		clothesService.update();
		show();
	}

	private void findOrderById() {
		println(getString("product.order.oid"));
		String oid =input.nextLine();
		Order order =orderSevice.findById(Integer.parseInt(oid));
		if(order!=null) {
			showOrder(order);
		}else {
			println(getString("product.order.error"));
		}
		menu();
	}

	private void showOrder(Order o) {

		println(getString("product.order.oid")+o.getOrderId());
		println("\t"+getString("product.order.createDate")+o.getCreateDate());
		println("\t"+getString("product.order.sum")+o.getSum());
		ConsoleTable t=new ConsoleTable(9,true);
		t.appendRow();
		t.appendColumn("itemId");
		t.appendColumn("brand");
		t.appendColumn("style");
		t.appendColumn("color");
		t.appendColumn("size");
		t.appendColumn("price");
		t.appendColumn("description");
		t.appendColumn("shoppingNum");
		t.appendColumn("sum");
		
		for(OrderItem item: o.getOrderItemList()) {
			t.appendRow();
			t.appendColumn(item.getItemId());
			t.appendColumn(item.getClothes().getBrand());
			t.appendColumn(item.getClothes().getStyle());
			t.appendColumn(item.getClothes().getColor());
			t.appendColumn(item.getClothes().getSize());
			t.appendColumn(item.getClothes().getPrice());
			t.appendColumn(item.getClothes().getDescription());
			t.appendColumn(item.getShoppingNum());
			t.appendColumn(item.getSum());
		}
		println(t.toString());
	}

	private void findOrderList() {

		List<Order> list=orderSevice.list();
		for(Order o: list) {
			showOrder(o);
		}
		menu();
	}

	private void showProducts() {
		List<Clothes> list=clothesService.list();
		ConsoleTable t=new ConsoleTable(8,true);
		t.appendRow();
		t.appendColumn("id");
		t.appendColumn("brand");
		t.appendColumn("style");
		t.appendColumn("color");
		t.appendColumn("size");
		t.appendColumn("num");
		t.appendColumn("price");
		t.appendColumn("description");
		for(Clothes c: list) {
			t.appendRow();
			t.appendColumn(c.getId());
			t.appendColumn(c.getBrand());
			t.appendColumn(c.getStyle());
			t.appendColumn(c.getColor());
			t.appendColumn(c.getSize());
			t.appendColumn(c.getNum());
			t.appendColumn(c.getPrice());
			t.appendColumn(c.getDescription());
		}
		
		println(t.toString());
	}
}
