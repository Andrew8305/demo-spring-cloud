package top.bootz.stream;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import top.bootz.common.message.MessaegPayload;
import top.bootz.stream.message.MessageSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoStreamPurchaseApplicationTests {

	@Autowired
	public MessageSender sender;

	@Test
	public void orderToPurchaseRedirectMall() {
		MessaegPayload message = new MessaegPayload("app_purchase", "app_mall", LocalDateTime.now(),
				"test_purchase_to_mall");
		sender.purchaseToMall(message);
	}

}
