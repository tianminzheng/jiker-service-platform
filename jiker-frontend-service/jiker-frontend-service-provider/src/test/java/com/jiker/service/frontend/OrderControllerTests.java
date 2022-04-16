package com.jiker.service.frontend;

import com.alibaba.fastjson.JSONObject;
import com.jiker.service.frontend.controller.OrderController;
import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;
import com.jiker.service.frontend.service.OrderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class) // 初始化了测试Controller所需的Spring MVC的基础设施
public class OrderControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private OrderService orderService;

	@Test
	public void testAddOrder() throws Exception {

		Order order = buildOrder();
		Order savedOrder = mockOrder();

		// 模拟OrderService保存Order的效果
		given(orderService.addOrder(order)).willReturn(savedOrder);

		String orderJson = JSONObject.toJSONString(order);

		this.mvc.perform(post("/orders").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(orderJson)).andExpect(status().isOk());
	}

	private Order mockOrder() {
		Order order = buildOrder();
		order.setId(1L);
		return order;
	}

	private Order buildOrder() {

		Order order = new Order();

		order.setAccountId(1L);
		order.setStatus(OrderStatus.INITIALIZED);

		List<Item> items = new ArrayList<>();
		Item item1 = new Item();
		item1.setItemCount(1);
		item1.setProductCode("product_code1");
		item1.setProductName("product_name1");
		item1.setProductPrice(100F);
		items.add(item1);

		Item item2 = new Item();
		item2.setItemCount(2);
		item2.setProductCode("product_code2");
		item2.setProductName("product_name2");
		item2.setProductPrice(150F);
		items.add(item2);

		order.setItems(items);

		return order;
	}
}
