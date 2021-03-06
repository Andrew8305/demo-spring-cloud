package top.bootz.stream;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import top.bootz.common.message.MessaegPayload;
import top.bootz.stream.message.MessageSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoStreamOrderApplicationTests {

	@Autowired
	public MessageSender sender;

	@Test
	public void orderToPurchaseWithToken() {
		MessaegPayload message = new MessaegPayload("app_order", "app_purchase", LocalDateTime.now(),
				"test_order_to_purchase");
		Map<String, String> headers = new HashMap<>();
		headers.put("token", UUID.randomUUID().toString());
		sender.orderToPurchase(message, headers);
	}

	// @Test
	public void orderToPurchase() {
		MessaegPayload message = new MessaegPayload("app_order", "app_purchase", LocalDateTime.now(),
				"test_order_to_purchase");
		sender.orderToPurchase(message, new HashMap<String, String>());
	}

	// @Test
	public void orderToMall() {
		MessaegPayload message = new MessaegPayload("app_order", "app_mall", LocalDateTime.now(), "test_order_to_mall");
		sender.orderToMall(message);
	}

	// @Test
	public void orderToPurchaseRedirectMall() {
		MessaegPayload message = new MessaegPayload("app_order", "app_purchase_redirect_app_mall", LocalDateTime.now(),
				"test_order_to_mall");
		sender.orderToPurchaseRedirectMall(message);
	}

}
