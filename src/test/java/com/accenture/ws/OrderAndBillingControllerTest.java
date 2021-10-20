package com.accenture.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.accenture.ws.entity.Order;
import com.accenture.ws.repository.OrderRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OrderAndBillingControllerTest {
	
	@Autowired
	private OrderRepository orderRepo;
    
    Order ORDER_1 = new Order(0, "Latte", 4.5, 5, true);
    Order ORDER_2 = new Order(0, "Tea", 5.5, 5, false);
	
	@Test
	@Rollback(false)
	public void getOrderList() {
		orderRepo.save(ORDER_1);
		orderRepo.save(ORDER_2);
		
		List<Order> orders =  (List<Order>) orderRepo.findAll();
		
		for(Order order: orders) {
			System.out.print(order.getOrderName()+" ");
			System.out.print(order.getPrice()+" ");
			System.out.print(order.getIsDiscountPercentage()+" ");
			System.out.println(order.isDiscounted());
		}
		
		assertThat(orders).size().isGreaterThan(2);
	}
	
	@Test
	@Rollback(false)
	public void addOrder() {
		Order mockOrder = new Order (1, "Café Latte", 3.5, 5, true);
		Order savedOrder = orderRepo.save(mockOrder);
		
		assertNotNull(savedOrder);
	}
	
	@Test
	@Rollback(false)
	public void updateOrder() {
		String orderName = "Café Mocha";
		Order mockOrder = new Order (1, orderName, 3.5, 5, false);
		Order updatedOrder = orderRepo.save(mockOrder);
		assertNotNull(updatedOrder);
	}
	
	@Test
	@Rollback(false)
	public void deleteOrder() {
		String orderName = "Café Mocha";
		Order mockOrder = new Order (1, orderName, 3.5, 5, false);
		orderRepo.delete(mockOrder);
	}

}
